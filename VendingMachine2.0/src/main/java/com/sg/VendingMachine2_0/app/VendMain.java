/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.VendingMachine2_0.app;

import com.sg.Vending2_0.controller.VendControl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class VendMain {

    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        VendView uView = new VendViewImpl(scanner);
        VendDAO uDAO = new VendDAOImpl();
        VendServ uService = new VendServImpl(uDAO);
        VendControl Start = new VendControl(uView, uService);
        Start.run();*/
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        VendControl start = ctx.getBean("start", VendControl.class);
        start.run();
        
    }
    
}
