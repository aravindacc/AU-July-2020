package com.hybernate;

import java.util.List;

import com.hybernate.bankservice.BankService;
import com.hybernate.entity.Account;
import com.hybernate.entity.Audit;
import com.hybernate.entity.User;

public class MainClass {
	public static void main(String []args) {
		/// this is main method
		// Bank service class use to add user, account and perform transaction
		BankService bank = new BankService();

		///user1
		User user1 = new User();
		user1.setFirstName("Mukesh");
		user1.setLastName("Suthar");
		user1.setCity("Nallasopara");
		bank.addUser(user1);

		/// user2
		User user2 = new User();
		user2.setFirstName("Ramesh");
		user2.setLastName("Kumar");
		user2.setCity("vasai");
		bank.addUser(user2);
		
		// account 1
		Account account1 = new Account();
		account1.setUserid(user1);
		account1.setAccountNumber(12345678);
		account1.setAmount(5000);
		bank.addAccount(account1);

		// account 2
		Account account2 = new Account();
		account2.setUserid(user1);
		account2.setAccountNumber(12345679);
		account2.setAmount(2000);
		bank.addAccount(account2);

		// account 3
		Account account3 = new Account();
		account3.setUserid(user2);
		account3.setAccountNumber(12345680);
		account3.setAmount(500);
		bank.addAccount(account3);

		
		
		/// successfull trasaction
		// account 1 => 5000 ---> withdraw(3000) --> 2000
		// account 2 => 2000 ---> deposit(3000) --> 5000
		bank.makeTrasaction(account1, account2, 3000);

		/// successfull trasaction
		// account 2 => 5000 ---> withdraw(4000) --> 1000
		// account 3 => 500 ---> deposit(4000) --> 4500		
		bank.makeTrasaction(account2, account3, 4000);

		/// failed trasaction (will rollback)
		// account 2 => 1000 ---> withdra(1500) --> 1000
		// account 1 => 2000 ---> deposit(1500) --> 2000	
		bank.makeTrasaction(account2, account1, 1500);
		
		
		
		/// list of user2 audit 
		List<Object[]> tuples  = bank.viewAudit(user2);
		
		
		
		System.out.println("------------------------------------------------------------------");
		System.out.println("ID\tAmount\tStatus\tSender A/c\tReciever A/c\tName");
		System.out.println("------------------------------------------------------------------");
		for (Object[] objects : tuples) {
		
			Audit audit = (Audit)objects[0];
			Account account = (Account)objects[1];
			
			System.out.print(audit.getId()+"\t");
			System.out.print(audit.getAmount()+"\t");
			System.out.print(audit.getStatus()+"\t");
			System.out.print(audit.getSender().getAccountNumber()+"\t");
			System.out.print(audit.getReciever().getAccountNumber()+"\t");
			System.out.print(account.getUserid().getFirstName()+"\t");
			System.out.println();
		}
		
	}
}
