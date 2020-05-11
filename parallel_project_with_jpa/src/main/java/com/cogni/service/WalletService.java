 package com.cogni.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.cogni.dto.Account;

public interface WalletService {

	boolean createAccount(Account customer,String number);
	double showBalance(Account customer,String st);
	boolean deposit(Account customer, String st, double amount);
	boolean withdraw(Account customer,  String st, double amount);
	boolean fundTransfer(Account customer,String st, String st1,double amt);
ArrayList<String> printTransaction(Account customer,String st);
}
