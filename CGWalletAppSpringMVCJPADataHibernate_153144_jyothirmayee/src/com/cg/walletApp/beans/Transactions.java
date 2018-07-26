package com.cg.walletApp.beans;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Transactions")
public class Transactions {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int transactionId;
	private String mobileNo;
	private String transactionType;
	private BigDecimal amount;
	private Date dateResult;
	private String transactionStatus;

	{
		transactionStatus = "false";
	}

	public Transactions() {
		super();
	}

	public Transactions(int transactionId, String mobileNo, String transactionType, BigDecimal amount,
			Date dateResult, String transactionStatus) {
		super();
		this.transactionId = transactionId;
		this.mobileNo = mobileNo;
		this.transactionType = transactionType;
		this.amount = amount;
		this.dateResult = dateResult;
		this.transactionStatus = transactionStatus;
	}

	

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getDateResult() {
		return dateResult;
	}

	public void setDateResult(Date dateResult) {
		this.dateResult = dateResult;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", mobileNo=" + mobileNo + ", transactionType="
				+ transactionType + ", amount=" + amount + ", dateResult=" + dateResult + ", transactionStatus="
				+ transactionStatus + "]";
	}

}
