package com.cg.walletApp.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Customer {

	private static final long serialVersionUID = 1L;
	@NotEmpty
	private String name;
	@Id
	@NotEmpty
	@Pattern(regexp="[1-9][0-9]{9}")
	private String mobileNo;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="wallet_id")
	private Wallet wallet;

	public Customer() {
		super();
	}

	public Customer(String name, Wallet wallet) {
		super();
		this.name = name;
		this.wallet = wallet;
	}

	public Customer(String mobileNo) {
		super();
		this.mobileNo = mobileNo;
	}

	public Customer(String name, String mobileNo, Wallet wallet) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
		this.wallet = wallet;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	
	@Override
	public String toString() {
		return "Customer name=" + name + ", mobileNo=" + mobileNo
				 + wallet;
	}
		
}
