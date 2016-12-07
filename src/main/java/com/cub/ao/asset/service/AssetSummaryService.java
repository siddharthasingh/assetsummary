package com.cub.ao.asset.service;

import java.util.List;

import com.cub.ao.asset.vo.CasaSummaryVO;
import com.cub.ao.asset.vo.CasaTransactionVO;
import com.cub.ao.asset.vo.CombinedDepositSummaryResponse;
import com.cub.ao.asset.vo.CombinedDepositSummaryVO;
import com.cub.ao.asset.vo.DepositSummaryVO;
import com.cub.ao.asset.vo.ResponseMessageVo;

public interface AssetSummaryService {
	public List<CasaSummaryVO> getCaSaSummary(String custId);

	/*public List<CasaTransactionVO> getCaSaTransaction(String accountNo);

	public List<DepositSummaryVO> getDepositSummary(String custId);
	
	public ResponseMessageVo getAssetAccountsList(String custId);	
	
	public CombinedDepositSummaryResponse getCombinedDepositSummary(String custId);*/
}
