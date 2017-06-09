/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.FloorMastery.main;

import com.sg.FloorMastery.Exceptions.InvalidInputException;
import com.sg.FloorMastery.controller.FloorController;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class FloorApp {
    
    public static void main(String[] args) throws 
            FileNotFoundException,
            InvalidInputException
    {
        Scanner read = new Scanner(new BufferedReader(new FileReader("src/main/resources/Config-Mode")));
        String mode = read.nextLine();
        mode = mode.toUpperCase();
        mode = mode.substring(7);
        read.close();
        ApplicationContext xkd = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        if (mode.matches("PRACTICE")) {
            xkd = new ClassPathXmlApplicationContext("applicationContextPractice.xml");
        }
        else if(mode.matches("PROD")==false) {
            throw new InvalidInputException("Invalid config syntax");
        }
        
        FloorController start = xkd.getBean("Controller", FloorController.class);
        start.run();
        
    }
}
