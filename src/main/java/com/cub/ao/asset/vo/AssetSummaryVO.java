package com.cub.ao.asset.vo;

import java.io.Serializable;

public class AssetSummaryVO implements Serializable {

		/**
	 * 
	 */
	private static final long serialVersionUID = -6908158469258550583L;
		private String accountNumber;	
		private String customerId;
		private String productName;
		private String currencyCode;
		private String interest;
		private String productType;
		private String productSubType;
		private String status;
		private String openDate;
		private String closeDate;
		private String twdBalance;
		private String branchCode;
		private String availableBalanceWod;
		private String tdFaceAmt;
		private String accountDueDate;
		
		private String term1;
		private String term2;
		private String availBalanceOd;
		private String acUpdTimestamp;
		private String acSyncTimestamp;
		private String systems;
		public String getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}
		public String getCustomerId() {
			return customerId;
		}
		public void setCustomerId(String customerId) {
			this.customerId = customerId;
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
		public String getInterest() {
			return interest;
		}
		public void setInterest(String interest) {
			this.interest = interest;
		}
		public String getProductType() {
			return productType;
		}
		public void setProductType(String productType) {
			this.productType = productType;
		}
		public String getProductSubType() {
			return productSubType;
		}
		public void setProductSubType(String productSubType) {
			this.productSubType = productSubType;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getOpenDate() {
			return openDate;
		}
		public void setOpenDate(String openDate) {
			this.openDate = openDate;
		}
		public String getCloseDate() {
			return closeDate;
		}
		public void setCloseDate(String closeDate) {
			this.closeDate = closeDate;
		}
		public String getTwdBalance() {
			return twdBalance;
		}
		public void setTwdBalance(String twdBalance) {
			this.twdBalance = twdBalance;
		}
		public String getBranchCode() {
			return branchCode;
		}
		public void setBranchCode(String branchCode) {
			this.branchCode = branchCode;
		}
		public String getAvailableBalanceWod() {
			return availableBalanceWod;
		}
		public void setAvailableBalanceWod(String availableBalanceWod) {
			this.availableBalanceWod = availableBalanceWod;
		}
		public String getTdFaceAmt() {
			return tdFaceAmt;
		}
		public void setTdFaceAmt(String tdFaceAmt) {
			this.tdFaceAmt = tdFaceAmt;
		}
		public String getAccountDueDate() {
			return accountDueDate;
		}
		public void setAccountDueDate(String accountDueDate) {
			this.accountDueDate = accountDueDate;
		}
		public String getTerm1() {
			return term1;
		}
		public void setTerm1(String term1) {
			this.term1 = term1;
		}
		public String getTerm2() {
			return term2;
		}
		public void setTerm2(String term2) {
			this.term2 = term2;
		}
		public String getAvailBalanceOd() {
			return availBalanceOd;
		}
		public void setAvailBalanceOd(String availBalanceOd) {
			this.availBalanceOd = availBalanceOd;
		}
		public String getAcUpdTimestamp() {
			return acUpdTimestamp;
		}
		public void setAcUpdTimestamp(String acUpdTimestamp) {
			this.acUpdTimestamp = acUpdTimestamp;
		}
		public String getAcSyncTimestamp() {
			return acSyncTimestamp;
		}
		public void setAcSyncTimestamp(String acSyncTimestamp) {
			this.acSyncTimestamp = acSyncTimestamp;
		}
		public String getSystems() {
			return systems;
		}
		public void setSystems(String systems) {
			this.systems = systems;
		}
		
}