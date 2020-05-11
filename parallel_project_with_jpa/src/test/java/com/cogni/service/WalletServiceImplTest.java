package com.cogni.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cogni.dao.WalletDao;
import com.cogni.dto.Account;

import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class WalletServiceImplTest {

	
	WalletServiceImpl walletServiceImpl;
	Account customer;
	Account customer1;
	ArrayList<String> a;
	@Mock
	WalletDao walletDao;
	
	
	@BeforeEach
	void setUp() throws Exception {
		walletServiceImpl=new WalletServiceImpl();
		customer=new Account("q","1","1234");
		walletServiceImpl.setDao(walletDao);
		
		
	}

	@Test
	void testCreateAccount() {
		customer=new Account("q","2","1234");
		boolean res=walletServiceImpl.createAccount(customer,"2");
	
		assertTrue(res);
		customer=new Account("q","2","1234");
		boolean res1=walletServiceImpl.createAccount(customer,"2");
		assertFalse(res1);
	
		 
	}

	@Test
	void testShowBalance() {
		customer=new Account("q","2","1234");
		boolean res=walletServiceImpl.createAccount(customer,"2");
		boolean res1=false;
		if(walletServiceImpl.showBalance(customer,"2")==0) {
			res1=true;
		}
		assertTrue(res1);
	}

	@Test
	void testDeposit() {
		customer=new Account("q","2","1234");
		boolean res=walletServiceImpl.createAccount(customer,"2");
		boolean res1=false;
		if(walletServiceImpl.deposit(customer,"2",1000)) {
			res1=true;
		}
		assertTrue(res1);
	}

	@Test
	void testWithdraw() {
		customer=new Account("q","2","1234");
		boolean res=walletServiceImpl.createAccount(customer,"2");
		boolean res1=false;
		walletServiceImpl.deposit(customer,"2",1000);
		if(walletServiceImpl.withdraw(customer,"2",500)) {
			res1=true;
		}
		assertTrue(res1);
	}

	@Test
	void testFundTransfer() {
		customer=new Account("q","2","1234");
		walletServiceImpl.createAccount(customer,"2");
		walletServiceImpl.deposit(customer,"2",1000);
		customer1=new Account("q","3","5678");
		walletServiceImpl.createAccount(customer1,"3");
		walletServiceImpl.deposit(customer1,"3",1000);
		boolean res=walletServiceImpl.fundTransfer(customer, "2", "3", 500);
		assertTrue(res);
		
	}

	@Test
	void testPrintTransaction() {
		customer=new Account("q","2","1234");
		 walletServiceImpl.createAccount(customer,"2");
		 
		walletServiceImpl.deposit(customer,"2",1000);
		walletServiceImpl.withdraw(customer,"2",500);
			 a=new ArrayList<>();
			 a=walletServiceImpl.printTransaction(customer, "2");
			 boolean res2 =false;
	 if(a!=null) {
		 res2=true;
	 }
	 assertTrue(res2);
		 
	}

}
