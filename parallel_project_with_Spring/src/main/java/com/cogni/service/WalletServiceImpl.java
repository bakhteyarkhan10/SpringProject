 package com.cogni.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogni.dao.WalletDao;
import com.cogni.dao.WalletDaoImpl;
import com.cogni.model.Account;
@Service
public class WalletServiceImpl implements WalletService {
	@Autowired
	private WalletDao dao;
	@Override
	public boolean createAccount(Account Account, String number) {
		
 dao.createAccount(Account,number);
 return true;
 
	}

	@Override
	public double showBalance(String st) {
		//dao.beginTransaction();
		
		//dao.commitTransaction();
		return  dao.readAccount(st);
		
		 
	}

	@Override
	public boolean deposit(Account Account, String st, double amount) {
		// TODO Auto-generated method stub
	//double amt=(Account.getBalance())+amount;
	//	dao.beginTransaction();
		dao.updateAccount(Account, st, amount);
		//dao.commitTransaction();
		 
		return true;
	}
	
	@Override
	public boolean withdraw(Account Account, String st, double amount) {
		// TODO Auto-generated method stub
		//double amt= Account.getBalance()-amount;
		//dao.beginTransaction();
		dao.updateAccount2(Account, st, amount);
		//dao.commitTransaction();
		return true;
	}

	@Override
	public boolean fundTransfer(Account Account, String st, String st1,double amt) {
		// TODO Auto-generated method stub
	 
		if( dao.updateAccount2(Account, st, amt))
		{
		 
			if(dao.updateAccount(Account, st1, amt)) {
			return true;
		}
		 
	}
		return false;
	}

	@Override
	public ArrayList<String> printTransaction( String st) {
		// TODO Auto-generated method stub
		
		return dao.returntransaction(st);
	}

	public void setDao(WalletDao walletDao) {
		// TODO Auto-generated method stub
		
	}

 
 
}
