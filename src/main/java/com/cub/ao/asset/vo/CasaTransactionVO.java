package com.cub.ao.asset.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class CasaTransactionVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 545993571579708976L;
	
	private String accountNo;	
	private String txnDate;
	private String txnDescription;
	private BigDecimal chequeNo;
	private BigDecimal credit;
	private BigDecimal debit;
	private BigDecimal accountBalance;
	private String memo;
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getTxnDate() {
		return txnDate;
	}
	public void setTxnDate(String txnDate) {
		this.txnDate = txnDate;
	}
	public String getTxnDescription() {
		return txnDescription;
	}
	public void setTxnDescription(String txnDescription) {
		this.txnDescription = txnDescription;
	}
	public BigDecimal getChequeNo() {
		return chequeNo;
	}
	public void setChequeNo(BigDecimal chequeNo) {
		this.chequeNo = chequeNo;
	}
	public BigDecimal getCredit() {
		return credit;
	}
	public void setCredit(BigDecimal credit) {
		this.credit = credit;
	}
	public BigDecimal getDebit() {
		return debit;
	}
	public void setDebit(BigDecimal debit) {
		this.debit = debit;
	}
	public BigDecimal getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}
