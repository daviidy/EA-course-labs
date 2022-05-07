package edu.miu.cs.cs544.exercise16_1.bank.dao;

import java.util.ArrayList;
import java.util.Collection;

import edu.miu.cs.cs544.exercise16_1.bank.domain.Account;
import org.hibernate.SessionFactory;

public class AccountDAOImpl implements AccountDAO {
	private SessionFactory sf = HibernateUtils.getSessionFactory();
	Collection<Account> accountlist = new ArrayList<Account>();

	public void saveAccount(Account account) {
		// System.out.println("AccountDAO: saving account with accountnr ="+account.getAccountnumber());
		//accountlist.add(account); // add the new
		sf.getCurrentSession().persist(account);
	}

	public void updateAccount(Account account) {
		// System.out.println("AccountDAO: update account with accountnr ="+account.getAccountnumber());
		//Account accountexist = loadAccount(account.getAccountNumber());
		//if (accountexist != null) {
			//accountlist.remove(accountexist); // remove the old
			//accountlist.add(account); // add the new
		//}

		sf.getCurrentSession().saveOrUpdate(account);

	}

	public Account loadAccount(long accountnumber) {
		// System.out.println("AccountDAO: loading account with accountnr ="+accountnumber);
		//for (Account account : accountlist) {
		//	if (account.getAccountNumber() == accountnumber) {
		//		return account;
		//	}
		//}

		return sf.getCurrentSession().get(Account.class, accountnumber);
	}

	public Collection<Account> getAccounts() {
		//return accountlist;
		return sf.getCurrentSession().createQuery("from Account").list();
	}

}
