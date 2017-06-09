/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.Controller;


import com.sg.addressbook.ui.AddressBookView;

/**
 *
 * @author apprentice
 */
public class AddressBookController {
    
    public void execute() {
        int choice;
        boolean cont = true;
        AddressBookView base = new AddressBookView();
        
        do {
            choice = base.MainMenu();

            switch (choice) {
                //add
                case 0: ;
                        break;
                //delete
                case 1: ;
                        break;
                //find
                case 2: ;
                        break;
                //list count
                case 3: ;
                        break;
                //list all
                case 4: ;
                        break;
                //exit
                case 5: cont = false;
                        break;
                default: System.out.println("I didn't quite get that. Let's try again.");
                break;
            }
        } while(cont==true);
        System.out.println("Thank you for you patronage!");
    }
}
