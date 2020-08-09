package com.au.hibernate.service;
import org.hibernate.Transaction;

import java.io.File;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.au.hibernate.entity.Account;
import com.au.hibernate.entity.Audit;
import com.au.hibernate.entity.User;

public class Service {

    private SessionFactory sf;

    // Build session factory
    public Service() {
        Configuration config = new Configuration().configure(new File("/home/rajdeep/IdeaProjects/hibernate/src/main/java/hibernate.cfg.xml")).addAnnotatedClass(User.class).addAnnotatedClass(Account.class).addAnnotatedClass(Audit.class);
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
            if(sender.withdraw((int) amount))
            {
                session.saveOrUpdate(sender);
                // deposit in reciever account
                if(reciever.deposit((int) amount))
                {
                    session.saveOrUpdate(reciever);

                    // transaction will successfull after deposit successfull
                }
                else
                {
                    // when deposit failed
                    transaction.rollback();

                }
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