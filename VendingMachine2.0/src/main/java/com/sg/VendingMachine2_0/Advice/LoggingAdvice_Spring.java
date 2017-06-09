/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.VendingMachine2_0.Advice;

import com.sg.VendingMachine2_0.Service.InsuffecientFundException;
import com.sg.VendingMachine2_0.Service.InsuffecientSupplyException;
import com.sg.Vendingmachine2_0.DTO.Item;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author apprentice
 */
public class LoggingAdvice_Spring {
    
    public void exceptionLogFund(JoinPoint blank, InsuffecientFundException noFund) {
        DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy/MM/dd---HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        
        Object[] args = blank.getArgs();
        String begString = blank.getSignature().getName()
                + " : Insuffecient Funds : "
                + ((Item) args[0]).getName()
                + "---"
                + ((Item) args[0]).getPrice()
                + "---"
                + form.format(now);

        try {
            PrintWriter write = new PrintWriter(new FileWriter("Resources/ExceptionLog"), true);
            write.println(begString);
            write.flush();
            write.close();
        } catch (FileNotFoundException ey) {
            System.out.println("ExceptionLog not found");
        } catch (IOException ex) {
            System.out.println("IOException, whatever that means");
        }

    }

    public void exceptionLogStock(JoinPoint blank, InsuffecientSupplyException noStock) {
        DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy/MM/dd---HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        Object[] args = blank.getArgs();
        String begString = blank.getSignature().getName()
                + " : Insuffecient Stock :  "
                + ((Item) args[0]).getName()
                + "---"
                + ((Item) args[0]).getStock()
                + "---"
                + form.format(now);

        try {
            PrintWriter write = new PrintWriter(new FileWriter("Resources/ExceptionLog"), true);
            write.println(begString);
            write.flush();
            write.close();
        } catch (FileNotFoundException ey) {
            System.out.println("ExceptionLog not found");
        } catch (IOException ex) {
            System.out.println("IOException, whatever that means");
        }
    }
}
