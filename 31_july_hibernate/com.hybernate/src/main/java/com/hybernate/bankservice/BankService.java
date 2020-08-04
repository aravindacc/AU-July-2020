package com.hybernate.bankservice;

import org.hibernate.Transaction;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hybernate.entity.Account;
import com.hybernate.entity.Audit;
import com.hybernate.entity.User;

public class BankService {
	
	private SessionFactory sf;
	
	// Build session factory 
	public BankService() {
		Configuration config = new Configuration().configure().addAnnotatedClass(User.class).addAnnotatedClass(Account.class).addAnnotatedClass(Audit.class);
		this.sf = config.buildSessionFactory();		
	}
	
	// add new user in db
	public void addUser(User user)
	{
		if(user != null)
		{
			Session session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
			session.close();
		}
	}
	
	
	//add new account in db
	public void addAccount(Account account)
	{
		if(account != null) {
			Session session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(account);
			transaction.commit();
			session.close();
		}
	}
	
	
	// make transaction from one a/c to another
	public void makeTrasaction(Account sender, Account reciever, double amount)
	{
		if(sender != null && reciever != null)
		{
			
			Session session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			//transaction started .........
			Audit audit = new Audit();
			audit.setSender(sender);
			audit.setReciever(reciever);
			audit.setAmount(amount);
			
			// withdraw from sender account 
			if(sender.withdraw(amount))
			{
				session.saveOrUpdate(sender);
				// deposit in reciever account 
				if(reciever.deposit(amount))
				{
					session.saveOrUpdate(reciever);
					audit.setStatus("Success");
					// transaction will successfull after deposit successfull
				}
				else
				{
					// when deposit failed 
					transaction.rollback();
					audit.setStatus("Failed");
					
				}
			}else
			{
				audit.setStatus("Failed");
			}
			
			session.save(audit);
			transaction.commit();			
			session.close();
			
		}
	}
	
	public List<Object[]> viewAudit(User user)
	{	
		Session session = sf.openSession();
		/// return if user's account is sender or reviever 
		@SuppressWarnings("unchecked")
		List<Object[]> tuples = session.createNativeQuery("SELECT a.*,ac.* FROM bankAudit a JOIN bankAccount ac ON a.sender_id = ac.id OR a.reciever_id = ac.id where ac.userid_id = "+user.getId())
		.addEntity("Audit", Audit.class )
		.addJoin( "Account", "Audit.sender")
		.list();
		
		session.close();
		return tuples;

	}
}
