package com.cogni.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.cogni.dto.Account;
 

public class WalletDaoImpl implements WalletDao {
	
private static EntityManagerFactory emf;
    
    @PersistenceContext 
    private static EntityManager em;
	public WalletDaoImpl() {
		emf=Persistence.createEntityManagerFactory("PU");
		em=emf.createEntityManager();
		
	
	
	}
	 
	 
	@Override
	public boolean createAccount(Account customer,String number) {
		 
	 em.persist(customer);
			 
		  
		
		 return true;
	
	 
	}

	@Override
	public Double readAccount(Account customer,String st) {
		// TODO Auto-generated method stub
		Account s=em.find(Account.class,st);
		return s.getBalance();
	}
	

	@Override
	public boolean updateAccount(Account customer,String st, double bal) {
		Account s=em.find(Account.class,st);
		s.setBalance(s.addBalance(bal));
	
		 
		 s.getTransaction().add(bal+"Deposited");
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean updateAccount2(Account customer,String st, double bal) {
		// TODO Auto-generated method stub
		Account s=em.find(Account.class,st);
		s.setBalance(s.subBalance(bal));
	
		 s.getTransaction().add(bal+"Widthdrawn");	
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean deleteAccount(Account customer,String st, double balance) {
		// TODO Auto-generated method stub
		em.remove(customer);
		return true;
	}

	@Override
	public ArrayList<String> returntransaction(Account customer,String st) {
		  
			Account s=em.find(Account.class,customer.getNumber());
			 
				 
					 return s.getTransaction();
		 
		 
// TODO Auto-generated method stub

 
}
	 
	public void beginTransaction() {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
	}

	 
	public void commitTransaction() {
		// TODO Auto-generated method stub
		em.getTransaction().commit();
		
	}
}
