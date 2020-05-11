 package com.cogni.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.cogni.dto.Account;
 
 
public interface WalletDao {

	boolean createAccount(Account customer,String number);
 
	boolean updateAccount(Account customer,String st,double balance);
	boolean deleteAccount(Account customer,String st, double balance);
	Double readAccount(Account customer, String st);

	boolean updateAccount2(Account customer, String st, double bal);
 ArrayList<String>returntransaction(Account customer,String st);
}
