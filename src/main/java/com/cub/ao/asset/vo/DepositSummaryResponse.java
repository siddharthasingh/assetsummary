package com.cub.ao.asset.vo;

import java.math.BigDecimal;
import java.util.List;

public class DepositSummaryResponse {

	private String customerId;
	private BigDecimal totalAssets;
	private List<DepositSummaryVO> assetSummaryList;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public BigDecimal getTotalAssets() {
		return totalAssets;
	}
	public void setTotalAssets(BigDecimal totalAssets) {
		this.totalAssets = totalAssets;
	}
	public List<DepositSummaryVO> getAssetSummaryList() {
		return assetSummaryList;
	}
	public void setAssetSummaryList(List<DepositSummaryVO> assetSummaryList) {
		this.assetSummaryList = assetSummaryList;
	}
	
	
	
}
