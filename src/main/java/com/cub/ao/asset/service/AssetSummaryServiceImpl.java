package com.cub.ao.asset.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cub.ao.asset.exception.CasaException;
import com.cub.ao.asset.exception.RecordNotFoundException;
import com.cub.ao.asset.utility.AssetConstants;
import com.cub.ao.asset.vo.CasaSummaryVO;
/**
 * This class is the service implementation class for Asset summary microservice 
 * It has operations to get AssetCasa summary or deposit summary based on customer Id and
 * operation to get Casa transaction summary based on account number.
 *
 */
@Service
public class AssetSummaryServiceImpl implements AssetSummaryService {
	
	
	@Autowired
	private RestTemplate restTemplate;	
	
	@Value("${server.host}")
	private String hostname;
	
	@Value("${aointegration.port}")
	private String integrationPort;
	
	@Value("${aointegration.baseuri}")
	private String integrationBaseUri;
	
	@Value("${aointegration.sync.baseuri}")
	private String integrationSyncBaseUri;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AssetSummaryServiceImpl.class);
	private static final String CLASS_NAME = AssetSummaryServiceImpl.class.getName();
	
	public List<CasaSummaryVO> getCaSaSummary(String custId){
		final String methodName = "getCaSaSummary";
		LOGGER.debug(AssetConstants.LOG_ENTER_METHOD + methodName + AssetConstants.LOG_OF_CLASS + CLASS_NAME);
		List<CasaSummaryVO> casaSummaryVOList = new ArrayList<CasaSummaryVO>();
		try{
			
			CasaSummaryVO casaVO = new CasaSummaryVO();
			casaVO.setAccountBalance(new BigDecimal(1000.00));
			casaVO.setAccountNumber("12345678");
			casaVO.setAccountType("Savings");
			casaVO.setBranchName("TCS - India");
			casaVO.setCurrencyCode("INR");
			casaVO.setAvailableBalance(new BigDecimal(1000.00));
			casaSummaryVOList.add(casaVO);
			
		}catch(RecordNotFoundException ex){
			throw ex; 
		}catch(Exception e){
			LOGGER.error(e.getMessage(), e);
			throw new CasaException(e.getMessage());
		}
		LOGGER.debug(AssetConstants.LOG_EXIT_METHOD + methodName + AssetConstants.LOG_OF_CLASS + CLASS_NAME);
		return casaSummaryVOList;
	}
	
	/*public List<DepositSummaryVO> getDepositSummary(String custId){
		final String methodName = "getDepositSummary";
		LOGGER.debug(AssetConstants.LOG_ENTER_METHOD + methodName + AssetConstants.LOG_OF_CLASS + CLASS_NAME);
		List<DepositSummaryVO> depositSummaryVOList = new ArrayList<DepositSummaryVO>();
		try{
			List<DepositSummary> depositSummaryList = assetSummaryDao.getDepositSummaryByCustId(custId);
			if(null != depositSummaryList && !depositSummaryList.isEmpty()){
				depositSummaryVOList = Utility.buildDepositSummaryResponse(depositSummaryList,assetSummaryDao);
			}else{
				throw new RecordNotFoundException("No Records found");
			}
		}catch(RecordNotFoundException ex){
			throw ex; 
		}catch(Exception e){
			LOGGER.error(e.getMessage(), e);
			throw new DepositException(e.getMessage());
		}
		LOGGER.debug(AssetConstants.LOG_EXIT_METHOD + methodName + AssetConstants.LOG_OF_CLASS + CLASS_NAME);
		return depositSummaryVOList;
		
	}
	
	
	public List<CasaTransactionVO> getCaSaTransaction(String accountNo) {
		final String methodName = "getCaSaTransaction";
		LOGGER.debug(AssetConstants.LOG_ENTER_METHOD + methodName + AssetConstants.LOG_OF_CLASS + CLASS_NAME);
		List<CasaTransactionVO> casaTranVoList = new ArrayList<CasaTransactionVO>();
		try{
			List<CasaTransaction> casaTransactionList = assetSummaryDao.getTransactionByAccNo(accountNo);
			
			if(null != casaTransactionList && !casaTransactionList.isEmpty()){
				casaTranVoList = 	Utility.buildCasaTransactionResponse(casaTransactionList);
			}
			else{
				throw new RecordNotFoundException(CasaConstants.NO_RECORDS_FOUND);
			}
		}catch(RecordNotFoundException ex){
			throw ex; 
		}catch(Exception e){
			LOGGER.error(e.getMessage(), e);
			throw new DepositException(e.getMessage());
		}
		LOGGER.debug(AssetConstants.LOG_EXIT_METHOD + methodName + AssetConstants.LOG_OF_CLASS + CLASS_NAME);
		return casaTranVoList;
	}

	@Override
	public ResponseMessageVo getAssetAccountsList(String custId) {
		ResponseMessageVo responseMsg = new ResponseMessageVo();
		final String methodName = "getCaSaAccountsList";
		LOGGER.debug(AssetConstants.LOG_ENTER_METHOD + methodName + AssetConstants.LOG_OF_CLASS + CLASS_NAME);
		List<String> accountList = null;
		Gson gson = new Gson();
		int updCount = 0;
		try {
			accountList = assetSummaryDao.getAssetAccountsList(custId);
			if(null != accountList && !accountList.isEmpty()){
				URI targetUrl = UriComponentsBuilder.fromUriString(integrationBaseUri).scheme("http").host(hostname).port(integrationPort).build().toUri();
				LOGGER.info("URI :: " + targetUrl);
				String [] str =  accountList.toArray(new String[accountList.size()]);
				AOUpdatedAccountsInfo aoData = restTemplate.postForObject(targetUrl, str, AOUpdatedAccountsInfo.class);
				
				if(null != aoData && (null != aoData.getJsonAccountInfoList())) {
					
					for(String dataList : aoData.getJsonAccountInfoList()) {
						AssetSummaryVO assetVO = gson.fromJson(dataList, AssetSummaryVO.class);
						CasaSummary casa = Utility.buildCasaEntity(assetVO);
						boolean assetUpdated = assetSummaryDao.saveUpdateBancsDetails(casa);
						if(assetUpdated) {
							updCount ++;
							sendDataForSync(casa.getAccountNumber(),casa.getAcSyncTimestamp().toString());
						}
					}
					if(accountList.size() == updCount) {
						responseMsg.setMessageCode("S");
						responseMsg.setMessage("Update successful.");
					}				
				}
				else if(null == aoData || (null == aoData.getJsonAccountInfoList())) {
					responseMsg.setMessageCode("S");
					responseMsg.setMessage("No records to sync");				
				} 
			}else{
				responseMsg.setMessageCode("S");
				responseMsg.setMessage("No records to sync");	
			}
		} catch(Exception e){
			responseMsg.setMessageCode("F");
			responseMsg.setMessage("No records to sync");
			LOGGER.error(e.getMessage(), e);
		}
		return responseMsg;
	}
	
	public void sendDataForSync(String accNo, String timeStamp){
		URI targetUrl = UriComponentsBuilder.fromUriString(integrationSyncBaseUri).scheme("http").host(hostname).port(integrationPort)
				.queryParam("accno", accNo).queryParam("time", timeStamp).build().toUri();
		LOGGER.debug("Calling URI: " + targetUrl);
		try{
			//ResponseEntity<List<AssetSummaryVO>> assetResponse =
			   ResponseEntity<String> resp= restTemplate.exchange(targetUrl, HttpMethod.GET, null, String.class);
			   resp.getBody();
		
		}catch (Exception ex){
			
				LOGGER.error(""+targetUrl,ex);
			
		}
	}
	
	public CombinedDepositSummaryResponse getCombinedDepositSummary(String custId){
		final String methodName = "getCombinedDepositSummary";
		LOGGER.debug(AssetConstants.LOG_ENTER_METHOD + methodName + AssetConstants.LOG_OF_CLASS + CLASS_NAME);
		CombinedDepositSummaryResponse combinedDepositSummaryResponse = new CombinedDepositSummaryResponse();
		try{
			

			List<CombinedDepositSummary> combinedDepositSummaryList = assetSummaryDao.getCombinedDepositSummaryByCustId(custId);
			if(null != combinedDepositSummaryList && !combinedDepositSummaryList.isEmpty()){
				combinedDepositSummaryResponse = 	Utility.buildCombinedDepositSummaryResponse(combinedDepositSummaryList);
			}else{
				throw new RecordNotFoundException(AssetConstants.NO_RECORDS_FOUND);
			}
	
		}catch(RecordNotFoundException ex){
			throw ex; 
		}catch(Exception e){
			LOGGER.error(e.getMessage(), e);
			throw new CombinedDepositException(e.getMessage());
		}
		LOGGER.debug(AssetConstants.LOG_EXIT_METHOD + methodName + AssetConstants.LOG_OF_CLASS + CLASS_NAME);
		return combinedDepositSummaryResponse;
		
	}
*/
}
