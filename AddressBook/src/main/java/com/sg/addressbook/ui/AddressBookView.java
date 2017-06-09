/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.ui;

import com.sg.addressbook.dto.AddressBook;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class AddressBookView implements AddressBookInterface {
    Scanner uInput = new Scanner(System.in);
    public int MainMenu() {
        int end = 6;
        String response;
        System.out.print("\n==========================");
        System.out.print("\nHello and welcome to ZZZ Pages.\n Please select an action:");
        System.out.print("\n1. Add an Address");
        System.out.print("\n2. Remove an Address");
        System.out.print("\n3. Find an Address");
        System.out.print("\n4. List Address Count");
        System.out.print("\n5. List all Addresses");
        System.out.print("\n6. Exit");
        System.out.print("\n==========================");
        
        response = uInput.nextLine();
        response = response.toUpperCase();
        
        if (response.matches("1|ADD|A|+")) {
            end = 0;
        }
        else if (response.matches("2|REMOVE|REM|-|DELETE")) {
            end = 1;
        }
        else if (response.matches("3|FIND|SEARCH")) {
            end = 2;
        }
        else if (response.matches("4|COUNT|TOTAL")) {
            end = 3;
        }
        else if (response.matches("5|LIST|ALL")) {
            end = 4;
        }
        else if (response.matches("6|EXIT|LEAVE|STOP")) {
            end = 5;
        }
        else {
            end = 6;
        }
        return end;
    }
    
    public void displayAll() {
        
    }
    
    public void displayOne() {
        
    }
    
    public void addSuccess() {
        
    }
    
    public void deleteSuccess() {
        
    }
}
