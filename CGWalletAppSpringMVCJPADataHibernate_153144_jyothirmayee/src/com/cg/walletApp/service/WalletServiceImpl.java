package com.cg.walletApp.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.walletApp.beans.Customer;
import com.cg.walletApp.beans.Transactions;
import com.cg.walletApp.beans.Wallet;
import com.cg.walletApp.exception.InsufficientBalanceException;
import com.cg.walletApp.exception.InvalidInputException;
import com.cg.walletApp.repo.TransactionRepo;
import com.cg.walletApp.repo.WalletRepo;

@Component(value="walletService")
public class WalletServiceImpl implements WalletService {

	//service is dependent on repo
	@Autowired(required=true)
	private WalletRepo repo;

	@Autowired
	private TransactionRepo transactionRepo;

	//@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public Customer createAccount(Customer customer) {

		return repo.save(customer);
	}

	@Override
	public Customer showBalance(String mobileNo) throws InvalidInputException {

		Customer customer=repo.findOne(mobileNo);

		if(customer!=null)
			return customer;
		else
			throw new InvalidInputException("Invalid mobile no ");
	}

	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) throws InvalidInputException, InsufficientBalanceException {

		if(isValid(sourceMobileNo) == false || isValid(targetMobileNo) == false) 
			throw new InvalidInputException();

		Customer customer = withdrawAmount(sourceMobileNo, amount);
		depositAmount(targetMobileNo, amount);

		return customer;
	}

	@Override
	public Customer depositAmount(String mobileNo, BigDecimal amount) throws InvalidInputException {

		if(amount.compareTo(new BigDecimal(0)) <= 0) 
			throw new InvalidInputException("Enter valid amount");

		if(isValid(mobileNo)) {
			Customer customer = repo.findOne(mobileNo);
			Wallet wallet = customer.getWallet();

			wallet.setBalance(wallet.getBalance().add(amount));
			customer.setWallet(wallet);

			Transactions transactions = new Transactions();

			transactions.setMobileNo(mobileNo);
			transactions.setAmount(amount);
			transactions.setTransactionType("Deposit ");
			transactions.setTransactionStatus("Success ");
			Date date = new Date();
			transactions.setDateResult(date);

			transactionRepo.save(transactions);
			repo.save(customer);

			return customer;
		}
		else throw new InvalidInputException("Enter valid mobile number");
	}

	public boolean isValid(String mobileNo) {

		if(mobileNo.matches("[1-9][0-9]{9}")) {
			return true;
		} else 
			return false;
	}

	private boolean isValidName(String name) {
	
		if( name == null || name.trim().isEmpty() || !name.matches("^[a-zA-Z]{1,30}$"))
			return false;
		return true;
	}

	@Override
	public Customer withdrawAmount(String mobileNo, BigDecimal amount) throws InvalidInputException, InsufficientBalanceException {

		if(amount.compareTo(new BigDecimal(0)) <= 0) 
			throw new InvalidInputException("Enter valid amount");

		if(isValid(mobileNo)) {

			Customer customer = repo.findOne(mobileNo);
			Wallet wallet = customer.getWallet();

			if(amount.compareTo(wallet.getBalance()) > 0) 
				throw new InsufficientBalanceException("Amount is not sufficient in your account");

			wallet.setBalance(wallet.getBalance().subtract(amount));
			customer.setWallet(wallet);

			Transactions transactions = new Transactions();
			
			transactions.setMobileNo(mobileNo);
			transactions.setAmount(amount);
			transactions.setTransactionType("Withdraw ");
			transactions.setTransactionStatus("Success ");
			Date date = new Date();
			transactions.setDateResult(date);

			transactionRepo.save(transactions);
			repo.save(customer);

			return customer;
		}
		else throw new InvalidInputException("Enter valid mobile number");
	}

	@Override
	public List<Transactions> getAllTransactions(String mobileNo) throws InvalidInputException {

		if(!isValid(mobileNo))
			throw new InvalidInputException("Invalid mobile number");
		else {
			List<Transactions> transaction = transactionRepo.findByMobileNo(mobileNo);
			
			if( transaction != null)
				return transaction;
			
			else
				throw new InvalidInputException("Invalid input");
		}
	}

	@Override
	public List<Customer> getCustomers() throws InvalidInputException, InsufficientBalanceException {
		BigDecimal amount = new BigDecimal(1000);
		return repo.findCustomers(amount);
	}

	@Override
	public List<Customer> getAllCustomers() throws InvalidInputException, InsufficientBalanceException {
		
		return repo.findAll();
	}
}
