package com.example.exercise13_2;


import com.example.exercise13_2.service.AccountService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collection;

public class Exercise132Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context=new ClassPathXmlApplicationContext("springConfig.xml");
        AccountService accountService = context.getBean("accountServiceImpl",AccountService.class);
        // create 2 accounts;
        accountService.createAccount(1263862, "Frank Brown");
        accountService.createAccount(4253892, "John Doe");
        //use account 1;
        accountService.deposit(1263862, 240);
        accountService.deposit(1263862, 529);
        accountService.withdrawEuros(1263862, 230);
        //use account 2;
        accountService.deposit(4253892, 12450);
        accountService.depositEuros(4253892, 200);
        accountService.transferFunds(4253892, 1263862, 100, "payment of invoice 10232");
        // show balances

        accountService.printAccountStatements();
    }

}
