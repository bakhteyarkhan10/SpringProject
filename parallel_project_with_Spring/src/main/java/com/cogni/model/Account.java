package com.cogni.model;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="springp")
public class Account {
@Id
@Column(name="number1")
private String number;
private String customerName;
private String password;
private String bankName;
private String ifsc;

private String accountNumber;
private double balance;
 public ArrayList<String> transaction=new ArrayList<>();
public ArrayList<String> getTransaction() {
	return this.transaction;
}

public void addtransaction(String st) {
	this.transaction.add(st);
	
}
public void setTransaction(ArrayList<String> transaction) {
	this.transaction = transaction;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getBankName() {
	return bankName;
}
public void setBankName(String bankName) {
	this.bankName = bankName;
}
public String getIfsc() {
	return ifsc;
}
public void setIfsc(String ifsc) {
	this.ifsc = ifsc;
}
public String getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
}
@Override
public String toString() {
	return "Account [customerName=" + customerName + ", number=" + number + ", password=" + password + ", bankName="
			+ bankName + ", ifsc=" + ifsc + ", accountNumber=" + accountNumber + ", balance=" + balance + "]";
}
 
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public double subBalance(double bal) {
	this.balance=this.balance-bal;
	return this.balance;
	// TODO Auto-generated method stub
	
}
public double addBalance(double bal) {
	this.balance=this.balance+bal;
	return this.balance;
	// TODO Auto-generated method stub
	
} 

	
}
