 package com.cogni.ui;

import java.util.Scanner;

import com.cogni.dto.Account;
import com.cogni.service.WalletServiceImpl;

public class Main {
public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	WalletServiceImpl wallet=new WalletServiceImpl();
	System.out.println("Payment Wallet");
 while(true) {
	 System.out.println("1.Create Account");
	 System.out.println("2.Show Balance");
	 System.out.println("3.Deposit");
	 System.out.println("4.Withdraw");
	 System.out.println("5.Fund Transfer");
	 System.out.println("6.Print Transaction");
	 System.out.println("7.Exit");
	 System.out.println("Select an option: ");
	 int ch =sc.nextInt();
	 
	 switch(ch){
	 case 1: {
		System.out.println("Enter name: ");
		String name=sc.next();
		System.out.println("Enter Customer Number: ");
		String number=sc.next();
		System.out.println("Enter your Password: ");
		String pass=sc.next();
		System.out.println("Enter Bank Name");
		String bank=sc.next();
		System.out.println("Enter IFSC code");
		String ifsc=sc.next();
		System.out.println("Enter account number: ");
		String accno=sc.next();
		if(wallet.createAccount(new Account(name,number,pass,bank,ifsc,accno),number)) {
			System.out.println("Account created successfully");
		}
		else {
			System.out.println("Account not created");
		}
		break;
		 
	 }
	 case 2:
	 {
		 System.out.println("Enter name: ");
			String name=sc.next();
			System.out.println("Enter Customer Number: ");
			String number=sc.next();
			System.out.println("Enter your Password: ");
			String pass=sc.next();
			 
				System.out.println(wallet.showBalance(new Account(name,number,pass),number));
			 
			break;
	 }
	 case 3:{
		 System.out.println("Enter name: ");
			String name=sc.next();
			System.out.println("Enter Customer Number: ");
			String number=sc.next();
			System.out.println("Enter your Password: ");
			String pass=sc.next();
			System.out.println("Enter amount to Deposit: ");
			double deposit=sc.nextDouble();
			if(wallet.deposit(new Account(name, number,pass),number,deposit)){
				System.out.println("Amount has been successfully deposited ");
				
			}
			else {
				System.out.println("Amount could not be deposited ");
				
			}
			break;
		 
		 
		 
	 }
	 case 4:{
		 System.out.println("Enter name: ");
			String name=sc.next();
			System.out.println("Enter Customer Number: ");
			String number=sc.next();
			System.out.println("Enter your Password: ");
			String pass=sc.next();
			System.out.println("Enter amount to Withdraw: ");
			double deposit=sc.nextDouble();
			if(wallet.withdraw(new Account(name, number,pass),number,deposit)){
				System.out.println("Transaction is successful ");
				
			}
			else {
				System.out.println("Transaction failed ");
				
			}
			break;
		 
		 
		 
	 }
	 case 5:
	 {
		 
		 System.out.println("Enter name: ");
			String name=sc.next();
			System.out.println("Enter Customer Number: ");
			String number=sc.next();
			System.out.println("Enter your Password: ");
			String pass=sc.next();
			System.out.println("Enter amount to transfer: ");
			double money=sc.nextDouble();
			System.out.println("Transfer from: ");
			String from=sc.next();
			System.out.println("Transfer to: ");
			String to=sc.next();
			if(wallet.fundTransfer(new Account(name,number,pass),from,to,money)){
				System.out.println("Transaction is successful ");
				
			}
			else {
				System.out.println("Transaction failed ");
				
			}
			break;		 
	 }
	 case 6: { System.out.println("Enter name: ");
		String name=sc.next();
		System.out.println("Enter Customer Number: ");
		String number=sc.next();
		System.out.println("Enter your Password: ");
		String pass=sc.next();
		if(wallet.printTransaction(new Account(name, number,pass),number)!=null) {
		for(String i:wallet.printTransaction(new Account(name, number,pass),number)){
			System.out.println(i);
			
		}
		}
		 break;
	 }
	 case 7:
		 System.exit(0);
	 }
 }
	}
}
