package com.cub.ao.asset.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @author Niraja Deshpande
 *
 */
public class CombinedDepositSummaryVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 545993571579708976L;
	private String customerId;
	private String startDate;
	private String productId;
	private String productName;
	private String currencyCode;
	private BigDecimal fxCurrentBal;
	private BigDecimal fxCurrentBalTwd;
	private String dueDate;
	private String applicationNbr;
	private String lastFxInterestAmt;
	private String fxInterestAmt;
	private String mtmDate;
	private String marketValue;
	private String cumulateGainsRate;
	private String lastGainingDate;
	private BigDecimal ntdCurrentBal;
	private String snapshotDate;



	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public BigDecimal getFxCurrentBal() {
		return fxCurrentBal;
	}

	public void setFxCurrentBal(BigDecimal fxCurrentBal) {
		this.fxCurrentBal = fxCurrentBal;
	}

	public BigDecimal getFxCurrentBalTwd() {
		return fxCurrentBalTwd;
	}

	public void setFxCurrentBalTwd(BigDecimal fxCurrentBalTwd) {
		this.fxCurrentBalTwd = fxCurrentBalTwd;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getApplicationNbr() {
		return applicationNbr;
	}

	public void setApplicationNbr(String applicationNbr) {
		this.applicationNbr = applicationNbr;
	}

	public String getLastFxInterestAmt() {
		return lastFxInterestAmt;
	}

	public void setLastFxInterestAmt(String lastFxInterestAmt) {
		this.lastFxInterestAmt = lastFxInterestAmt;
	}

	public String getFxInterestAmt() {
		return fxInterestAmt;
	}

	public void setFxInterestAmt(String fxInterestAmt) {
		this.fxInterestAmt = fxInterestAmt;
	}

	public String getMtmDate() {
		return mtmDate;
	}

	public void setMtmDate(String mtmDate) {
		this.mtmDate = mtmDate;
	}

	public String getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(String marketValue) {
		this.marketValue = marketValue;
	}

	public String getCumulateGainsRate() {
		return cumulateGainsRate;
	}

	public void setCumulateGainsRate(String cumulateGainsRate) {
		this.cumulateGainsRate = cumulateGainsRate;
	}

	public String getLastGainingDate() {
		return lastGainingDate;
	}

	public void setLastGainingDate(String lastGainingDate) {
		this.lastGainingDate = lastGainingDate;
	}

	public BigDecimal getNtdCurrentBal() {
		return ntdCurrentBal;
	}

	public void setNtdCurrentBal(BigDecimal ntdCurrentBal) {
		this.ntdCurrentBal = ntdCurrentBal;
	}

	public String getSnapshotDate() {
		return snapshotDate;
	}

	public void setSnapshotDate(String snapshotDate) {
		this.snapshotDate = snapshotDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
