 package com.cogni.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.cogni.model.Account;
 
 
public interface WalletDao {

	boolean createAccount(Account customer,String number);
 
	boolean updateAccount(Account customer,String st,double balance);
	//boolean deleteAccount(Account customer,String st, double balance);
	Double readAccount(String st);

	boolean updateAccount2(Account customer, String st, double bal);
 ArrayList<String>returntransaction(String st);
}
