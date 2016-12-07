package com.cub.ao.asset.utility;


/**
 * This class is an utility class for Asset microservice
 *
 */
public class Utility {/*
		private static final Logger LOGGER = LoggerFactory.getLogger(Utility.class);
		private static final String CLASS_NAME = Utility.class.getName();
	private Utility() {
	};
	

	*//**
	 * This operation builds casa summary response
	 * @param assetSummaryList
	 * @param casaDao
	 * @return List<CasaSummaryVO>
	 *//*
	public static List<CasaSummaryVO> buildCasaSummaryResponse(
			List<CasaSummary> assetSummaryList, AssetSummaryDao casaDao) {
		List<CasaSummaryVO> assetSummaryVOList = new ArrayList<CasaSummaryVO>();
		CasaSummaryVO casaSummaryVO;
		BigDecimal totalAssets = new BigDecimal(0);

		for (CasaSummary assetSum : assetSummaryList) {
			casaSummaryVO = new CasaSummaryVO();
			casaSummaryVO.setAccountBalance(assetSum.getTwdBalance());
			casaSummaryVO.setAccountNumber(assetSum.getAccountNumber());
			if (!StringUtils.isEmpty(assetSum.getProductType())) {
				String productTypeCode = assetSum.getProductType().substring(
						CasaConstants.INDEX_ZERO, CasaConstants.INDEX_ONE);
				if (CasaConstants.PRODUCT_TYPE_CODE_2
						.equalsIgnoreCase(productTypeCode)) {
					casaSummaryVO
							.setAccountType(CasaConstants.PRODUCT_TYPE_DESC_SAVINGS);
				} else if (CasaConstants.PRODUCT_TYPE_CODE_1
						.equalsIgnoreCase(productTypeCode)) {
					casaSummaryVO
							.setAccountType(CasaConstants.PRODUCT_TYPE_DESC_CURRENT);
				}
			}
			casaSummaryVO.setAvailableBalance(assetSum.getAvailableBalanceWod());
			casaSummaryVO.setBranchName(getBranchDetail(
					assetSum.getBranchCode(), casaDao));
			casaSummaryVO.setCurrencyCode(assetSum.getCurrencyCode());
			casaSummaryVO.setTdFaceAmount(assetSum.getTdFaceAmt());
			DateFormat sqlDateFormat = new SimpleDateFormat(AssetConstants.DATE_FORMAT_DD_MMM_YY);
			if (null != assetSum.getOpenDate()) {
				casaSummaryVO.setOpenDate(sqlDateFormat.format(assetSum
						.getOpenDate()));
			}
			if (null != assetSum.getCloseDate()) {
				casaSummaryVO.setCloseDate(sqlDateFormat.format(assetSum
						.getCloseDate()));
			}
			DateFormat dateFormat = new SimpleDateFormat(
					"dd/MM/yyyy HH:mm:ss.SSS");
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			casaSummaryVO.setTimeStamp(dateFormat.format(timestamp));
			DateFormat dateFormatInput = new SimpleDateFormat(
					"yyyyMMddHHmmssSS");
			try {
				Date date  = dateFormatInput.parse(assetSum.getAcSyncTimestamp());
				DateFormat dateFormat = new SimpleDateFormat(
						"dd/MM/yyyy HH:mm:ss.SS");
				//Timestamp timestamp = new Timestamp(dateFormat.);
				casaSummaryVO.setTimeStamp(dateFormat.format(date));
			} catch (ParseException e) {
				LOGGER.info("Error in parsing date"+assetSum.getAcSyncTimestamp());
			}
			totalAssets = totalAssets.add(casaSummaryVO.getAvailableBalance());
			assetSummaryVOList.add(casaSummaryVO);
		}

		return assetSummaryVOList;
	}
	*//**
	 * This operations builds response for Casa transaction summary
	 * @param transactionList
	 * @return List<CasaTransactionVO>
	 *//*
	public static List<CasaTransactionVO> buildCasaTransactionResponse(
			List<CasaTransaction> transactionList) {

		List<CasaTransactionVO> casaTransVoList = new ArrayList<CasaTransactionVO>();
		CasaTransactionVO casaTransVo;

		for (CasaTransaction casaTran : transactionList) {
			casaTransVo = new CasaTransactionVO();

			casaTransVo.setAccountBalance(casaTran.getAccountBalance());
			casaTransVo.setAccountNo(casaTran.getAccountNo());
			casaTransVo.setChequeNo(casaTran.getChequeNo());
			casaTransVo.setCredit(casaTran.getCredit());
			casaTransVo.setDebit(casaTran.getDebit());
			casaTransVo.setMemo(casaTran.getMemo());

			DateFormat sqlDateFormat = new SimpleDateFormat("dd-MMM-yy");
			if (null != casaTran.getTxnDate()) {
				casaTransVo.setTxnDate(sqlDateFormat.format(casaTran
						.getTxnDate()));
			}
			casaTransVo.setTxnDescription(casaTran.getTxnDescription());

			casaTransVoList.add(casaTransVo);
		}
		return casaTransVoList;
	}
	*//**
	 * This operation get the branch details based on the given branch no.
	 * @param branchNo
	 * @param casaDao
	 * @return String
	 *//*
	public static String getBranchDetail(String branchNo,
			AssetSummaryDao casaDao) {

		String branchName = null;

		BranchDetails branchDetails = casaDao.getBranchDetails(branchNo);
		if (null != branchDetails) {
			branchName = branchDetails.getBranchName();
		}

		return branchName;

	}

	*//**
	 * This operation builds deposit summary response
	 * @param assetSummaryList
	 * @param assetSummaryDao
	 * @return List<DepositSummaryVO>
	 *//*

	public static List<DepositSummaryVO> buildDepositSummaryResponse(
			List<DepositSummary> assetSummaryList,
			AssetSummaryDao assetSummaryDao) {
		List<DepositSummaryVO> assetSummaryVOList = new ArrayList<DepositSummaryVO>();
		DepositSummaryVO depositSummaryVO;

		for (DepositSummary assetSum : assetSummaryList) {
			depositSummaryVO = new DepositSummaryVO();
			depositSummaryVO.setAccountBalance(assetSum.getAvailableBalanceWod());
			depositSummaryVO.setAccountNumber(assetSum.getAccountNumber());
			depositSummaryVO
					.setAccountType(DepositConstants.PRODUCT_TYPE_DESC_DEPOSIT);
			depositSummaryVO
					.setAvailableBalance(assetSum.getAvailableBalanceWod());
			depositSummaryVO.setBranchName(getBranchDetail(
					assetSum.getBranchCode(), assetSummaryDao));
			depositSummaryVO.setCurrencyCode(assetSum.getCurrencyCode());
			depositSummaryVO.setTdFaceAmount(assetSum.getTdFaceAmt());
			DateFormat sqlDateFormat = new SimpleDateFormat("dd-MMM-yy");
			if (null != assetSum.getOpenDate()) {
				depositSummaryVO.setOpenDate(sqlDateFormat.format(assetSum
						.getOpenDate()));
			}
			if (null != assetSum.getCloseDate()) {
				depositSummaryVO.setCloseDate(sqlDateFormat.format(assetSum
						.getCloseDate()));
			}
			DateFormat dateFormatInput = new SimpleDateFormat(
					"yyyyMMddHHmmssSS");
			try {
				Date date  = dateFormatInput.parse(assetSum.getAcSyncTimestamp());
				DateFormat dateFormat = new SimpleDateFormat(
						"dd/MM/yyyy HH:mm:ss.SS");
				//Timestamp timestamp = new Timestamp(dateFormat.);
				depositSummaryVO.setTimeStamp(dateFormat.format(date));
			} catch (ParseException e) {
				LOGGER.info("Error in parsing date"+assetSum.getAcSyncTimestamp());
			}
		
			assetSummaryVOList.add(depositSummaryVO);
		}

		return assetSummaryVOList;

	}
	

	*//**
	 * This operation builds combined deposit summary response
	 * @param assetSummaryList
	 * @param assetSummaryDao
	 * @return List<DepositSummaryVO>
	 *//*

	public static CombinedDepositSummaryResponse buildCombinedDepositSummaryResponse(
			List<CombinedDepositSummary> combinedDepositSummaryList) {
		
		final String methodName = "buildCombinedDepositSummaryResponse";
		LOGGER.info(AssetConstants.LOG_ENTER_METHOD + methodName + AssetConstants.LOG_OF_CLASS + CLASS_NAME);
		
		List<CombinedDepositSummaryVO> combinedDepositSummaryVOList = new ArrayList<CombinedDepositSummaryVO>();
		CombinedDepositSummaryResponse resp = new CombinedDepositSummaryResponse();
		Map<String, ForeignCurrencyTotalVO> foreignCurrencyMap = new HashMap<>();
		BigDecimal totalTWD = new BigDecimal(0);

		for (CombinedDepositSummary combinedDeposit : combinedDepositSummaryList) {
			String currencyCodeDesc = combinedDeposit.getCurrencyCode();
			ForeignCurrencyTotalVO foreignCurrTotalVO;
			CombinedDepositSummaryVO combinedDepositSummaryVO = new CombinedDepositSummaryVO();
			
			if(foreignCurrencyMap.containsKey(currencyCodeDesc)){
				foreignCurrTotalVO = foreignCurrencyMap.get(currencyCodeDesc);
				foreignCurrTotalVO.setCurrencyCodeDesc(currencyCodeDesc);
				foreignCurrTotalVO.setAvailableBalanceTotal(foreignCurrTotalVO.getAvailableBalanceTotal().add(combinedDeposit.getFxCurrentBal().setScale(0,BigDecimal.ROUND_HALF_EVEN)));
				foreignCurrTotalVO.setAvailableBalanceTWDTotal(foreignCurrTotalVO.getAvailableBalanceTWDTotal().add(combinedDeposit.getFxCurrentBalTwd().setScale(0,BigDecimal.ROUND_HALF_EVEN)));
				foreignCurrencyMap.put(currencyCodeDesc, foreignCurrTotalVO);
			}else{
				foreignCurrTotalVO = new ForeignCurrencyTotalVO();
				foreignCurrTotalVO.setCurrencyCodeDesc(currencyCodeDesc);
				foreignCurrTotalVO.setAvailableBalanceTotal(combinedDeposit.getFxCurrentBal().setScale(0,BigDecimal.ROUND_HALF_EVEN));
				foreignCurrTotalVO.setAvailableBalanceTWDTotal(combinedDeposit.getFxCurrentBalTwd().setScale(0,BigDecimal.ROUND_HALF_EVEN));
				foreignCurrencyMap.put(currencyCodeDesc, foreignCurrTotalVO);
				
			}
			
			
			combinedDepositSummaryVO.setCustomerId(combinedDeposit.getCustomerId());
			DateFormat sqlDateFormat = new SimpleDateFormat("yyyy/MM/dd");
			
			if (null != combinedDeposit.getStartDate()) {
				combinedDepositSummaryVO.setStartDate(sqlDateFormat.format(combinedDeposit
						.getStartDate()));
			}
			
			combinedDepositSummaryVO.setProductId(combinedDeposit.getProductId());
			
			String productName = combinedDeposit.getProductName().replace(combinedDeposit.getProductId(),"").trim();
			combinedDepositSummaryVO.setProductName(productName);
			combinedDepositSummaryVO.setCurrencyCode(combinedDeposit.getCurrencyCode());
			combinedDepositSummaryVO.setFxCurrentBal(combinedDeposit.getFxCurrentBal().setScale(0,BigDecimal.ROUND_HALF_EVEN));
			combinedDepositSummaryVO.setFxCurrentBalTwd(combinedDeposit.getFxCurrentBalTwd().setScale(0,BigDecimal.ROUND_HALF_EVEN));
			if (null != combinedDeposit.getDueDate()) {
				combinedDepositSummaryVO.setDueDate(sqlDateFormat.format(combinedDeposit
						.getDueDate()));
			}
			
			combinedDepositSummaryVO.setApplicationNbr(combinedDeposit.getApplicationNbr());
			combinedDepositSummaryVO.setLastFxInterestAmt(combinedDeposit.getLastFxInterestAmt());
			combinedDepositSummaryVO.setFxInterestAmt(combinedDeposit.getFxInterestAmt());
			combinedDepositSummaryVO.setMtmDate(combinedDeposit.getMtmDate());
			combinedDepositSummaryVO.setMarketValue(combinedDeposit.getMarketValue());
			combinedDepositSummaryVO.setCumulateGainsRate(combinedDeposit.getCumulateGainsRate());
			combinedDepositSummaryVO.setLastGainingDate(combinedDeposit.getLastGainingDate());
			
			combinedDepositSummaryVO.setNtdCurrentBal(combinedDeposit.getNtdCurrentBal());
			
			if (null != combinedDeposit.getSnapshotDate()) {
				combinedDepositSummaryVO.setSnapshotDate(sqlDateFormat.format(combinedDeposit
						.getSnapshotDate()));
			}
			
			totalTWD = totalTWD.add(combinedDeposit.getFxCurrentBalTwd().setScale(0,BigDecimal.ROUND_HALF_EVEN));
			
			combinedDepositSummaryVOList.add(combinedDepositSummaryVO);
		}

		List<ForeignCurrencyTotalVO> foreignCurrTotalVOList = new ArrayList<>();
		if(!foreignCurrencyMap.isEmpty()){
			
			foreignCurrencyMap.forEach((k,v)->{
				foreignCurrTotalVOList.add(foreignCurrencyMap.get(k));
			});
		}

		resp.setListOfCombinedDepositDetails(combinedDepositSummaryVOList);
		resp.setListOfForeignCurrencyTotal(foreignCurrTotalVOList);
		resp.setCombinedDepositTotalTWD(totalTWD);
		
		
		LOGGER.info(AssetConstants.LOG_EXIT_METHOD + methodName + AssetConstants.LOG_OF_CLASS + CLASS_NAME);
		
		
		return resp;

	}
	
	public static CasaSummary buildCasaEntity(AssetSummaryVO assetVo) throws ParseException{
		
		CasaSummary casaEnt = null;
		try{
			casaEnt = new CasaSummary();
			SimpleDateFormat  dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat  dateFormat1 = new SimpleDateFormat("ddMMyyyy");
			
			casaEnt.setAccountNumber(assetVo.getAccountNumber());
			casaEnt.setCustomerId(assetVo.getCustomerId().trim());
			casaEnt.setProductName(assetVo.getProductName());
			casaEnt.setCurrencyCode(assetVo.getCurrencyCode());
			BigDecimal intRate = new BigDecimal(assetVo.getInterest());
			casaEnt.setInterest(intRate);
			casaEnt.setProductType(assetVo.getProductType());
			casaEnt.setProductSubType(assetVo.getProductSubType());
			casaEnt.setStatus(assetVo.getStatus());
			
			if (null != assetVo.getOpenDate() && !assetVo.getOpenDate().equals("99999999")) {
				try {
					java.util.Date parsed = dateFormat1.parse(assetVo.getOpenDate());
					casaEnt.setOpenDate(new java.sql.Date(parsed.getTime()));
				} catch (Exception e) {
					casaEnt.setOpenDate(null);
					LOGGER.error("Error pasrsing getOpenDate() ");
				}						
			}
			if (null != assetVo.getCloseDate() && !assetVo.getCloseDate().equals("99999999")) {
				try {
					java.util.Date parsed = dateFormat1.parse(assetVo.getCloseDate());
					casaEnt.setCloseDate(new java.sql.Date(parsed.getTime()));
				} catch (Exception e) {
					casaEnt.setOpenDate(null);
					LOGGER.error("Error pasrsing getCloseDate() ");
				}						
			}
			BigDecimal twdBalance = new BigDecimal(assetVo.getTwdBalance().isEmpty()?"0":assetVo.getTwdBalance());
			twdBalance = twdBalance.movePointLeft(3);
			casaEnt.setTwdBalance(twdBalance);
			casaEnt.setBranchCode(assetVo.getBranchCode());
			BigDecimal availBalWod = new BigDecimal(assetVo.getAvailableBalanceWod().isEmpty()?"0":assetVo.getAvailableBalanceWod());
			availBalWod = availBalWod.movePointLeft(3);
			casaEnt.setAvailableBalanceWod(availBalWod);
			BigDecimal tdFaceAmt = new BigDecimal(assetVo.getTdFaceAmt().isEmpty()?"0":assetVo.getTdFaceAmt());
			tdFaceAmt = tdFaceAmt.movePointLeft(3);
			casaEnt.setTdFaceAmt(tdFaceAmt); 
			if (null != assetVo.getAccountDueDate() && (!assetVo.getAccountDueDate().startsWith("99"))) {
				try {
					java.util.Date parsed = dateFormat.parse(assetVo.getAccountDueDate());
					casaEnt.setAccountDueDate(new java.sql.Date(parsed.getTime()));
				} catch (Exception e) {
					casaEnt.setOpenDate(null);
					LOGGER.error("Error pasrsing getAccountDueDate() ");
				}						
			}
			BigDecimal availBalOd = new BigDecimal(assetVo.getAvailBalanceOd().trim().isEmpty()?"0":assetVo.getAvailBalanceOd());
			availBalOd = availBalOd.movePointLeft(3);
			casaEnt.setAvailBalanceOd(availBalOd);
			casaEnt.setTerm1(assetVo.getTerm1().trim());
			casaEnt.setTerm2(assetVo.getTerm2().trim());
			casaEnt.setAcSyncTimestamp(assetVo.getAcSyncTimestamp());
			casaEnt.setAcUpdateTimestamp(assetVo.getAcUpdTimestamp());
			casaEnt.setSystems(assetVo.getSystems());
		}catch(Exception e){
			
			LOGGER.info("TwdBalance:"+assetVo.getTwdBalance()+" Avail Balance Wod:"+assetVo.getAvailableBalanceWod()+" Td Face Amt:"
					+assetVo.getTdFaceAmt()+" Avail Bal Od"+assetVo.getAvailBalanceOd());
			LOGGER.error(e.getMessage(),e);
			casaEnt = null;
		}
		
		return casaEnt;
	}
	
	
*/}
