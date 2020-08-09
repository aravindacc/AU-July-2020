package com.au.hibernate;

import java.util.List;

import com.au.hibernate.entity.Account;
import com.au.hibernate.entity.Audit;
import com.au.hibernate.entity.User;
import com.au.hibernate.service.Service;
public class Main {

    public static void main(String args[]) throws Exception {


        Service bankservice = new Service();

        ///user1
        User user1 = new User();
        user1.setName("Rajdeep");
        bankservice.addUser(user1);

        /// user2
        User user2 = new User();
        user2.setName("Shubham");
        bankservice.addUser(user2);

        // account 1
        Account account1 = new Account();
        account1.setUserid(user1);
        account1.setAccountNumber(78989);
        account1.setAmount(5000);
        account1.setType("saving");
        bankservice.addAccount(account1);


        // account 2
        Account account2 = new Account();
        account2.setUserid(user1);
        account2.setAccountNumber(78928);
        account2.setAmount(5000);
        account2.setType("saving");
        bankservice.addAccount(account2);

        // account 3
        Account account3 = new Account();
        account3.setUserid(user2);
        account3.setAccountNumber(78916);
        account3.setAmount(1000);
        account1.setType("saving");
        bankservice.addAccount(account3);




        bankservice.makeTrasaction(account1, account2, 3000);//successfull transaction


        bankservice.makeTrasaction(account3, account2, 4000); //unsuccessfull transaction


        /// list of user2 audit
        List<Object[]> tuples  = bankservice.viewAudit(user2);
        for (Object[] objects : tuples) {

            Audit audit = (Audit)objects[0];
            Account account = (Account)objects[1];
            User user = (User)objects[2];

            System.out.print(user.getId()+"\t");
            System.out.print(user.getName()+"\t");

            System.out.print(account.getId()+"\t");
            System.out.print(account.getAmount()+"\t");
            System.out.print(account.getType()+"\t");


            System.out.print(audit.getId()+"\t");
            System.out.print(audit.getAmount()+"\t");
            System.out.print(audit.getStatus()+"\t");
            System.out.print(audit.getSender().getAccountNumber()+"\t");
            System.out.print(audit.getReciever().getAccountNumber()+"\t");
            System.out.print(account.getUserid().getName()+"\t");
            System.out.println();
        }

    }
}






