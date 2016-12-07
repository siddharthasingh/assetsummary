package com.cub.ao.asset.vo;

import java.math.BigDecimal;
import java.util.List;

public class CombinedDepositSummaryResponse {

	private BigDecimal combinedDepositTotalTWD;
	private List<CombinedDepositSummaryVO> listOfCombinedDepositDetails;
	private List<ForeignCurrencyTotalVO> listOfForeignCurrencyTotal;

	public BigDecimal getCombinedDepositTotalTWD() {
		return combinedDepositTotalTWD;
	}

	public void setCombinedDepositTotalTWD(BigDecimal combinedDepositTotalTWD) {
		this.combinedDepositTotalTWD = combinedDepositTotalTWD;
	}

	public List<CombinedDepositSummaryVO> getListOfCombinedDepositDetails() {
		return listOfCombinedDepositDetails;
	}

	public void setListOfCombinedDepositDetails(
			List<CombinedDepositSummaryVO> listOfCombinedDepositDetails) {
		this.listOfCombinedDepositDetails = listOfCombinedDepositDetails;
	}

	public List<ForeignCurrencyTotalVO> getListOfForeignCurrencyTotal() {
		return listOfForeignCurrencyTotal;
	}

	public void setListOfForeignCurrencyTotal(
			List<ForeignCurrencyTotalVO> listOfForeignCurrencyTotal) {
		this.listOfForeignCurrencyTotal = listOfForeignCurrencyTotal;
	}

}
