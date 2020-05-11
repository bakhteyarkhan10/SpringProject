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

import org.springframework.stereotype.Repository;

import com.capgemini.model.Account;
 
@Repository
public class WalletDaoImpl implements WalletDao {
	
private static EntityManagerFactory emf;

 
    private static EntityManager em;
	public WalletDaoImpl() {
		emf=Persistence.createEntityManagerFactory("PU");
		em=emf.createEntityManager();
		
	
	}
	
	 
	 
	@Override
	public boolean createAccount(Account customer,String number) {
	em.getTransaction().begin();	 
	 em.persist(customer);
	em.getTransaction().commit();		 
		  
		
		 return true;
	
	 
	}

	@Override
	public Double readAccount(String st) {
		// TODO Auto-generated method stub
		Account s=em.find(Account.class,st);
		return s.getBalance();
	}
	

	@Override
	public boolean updateAccount(Account customer,String st, double bal) {
		em.getTransaction().begin();	
		Account s=em.find(Account.class,st);
		s.setBalance(s.addBalance(bal));
		
		 
		 s.getTransaction().add(bal+"Deposited");
		 em.getTransaction().commit();

		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean updateAccount2(Account customer,String st, double bal) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();	
		Account s=em.find(Account.class,st);
		s.setBalance(s.subBalance(bal));
	
		 s.getTransaction().add(bal+"Widthdrawn");	
		// TODO Auto-generated method stub
		em.getTransaction().commit();
		return true;
	}


	 
	@Override
	public ArrayList<String> returntransaction(String st) {
		  
			Account s=em.find(Account.class,st);
			 
				 
					 return s.getTransaction();
		 
		 
// TODO Auto-generated method stub

 
}
	 
}
