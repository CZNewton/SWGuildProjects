/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.VendingMachine.ui;

import com.sg.VendingMachine.DTO.Item;
import com.sg.VendingMachine.service.InvalidInputException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class VendViewImpl implements VendView {
    Scanner uInput;
    
    public VendViewImpl(Scanner scan) {
        this.uInput = scan;
    }

    @Override
    public int displayMenu(List<Item> interm) throws InvalidInputException {
        String uPlaceholder;
        int y = 10;
        int remain = interm.size();
        int end = 0;
        int page = 0;
        
        do {
            page++;
            if (remain<y) {
                y = remain;
            }
            else {
                y = 10;
            }
            
            System.out.println("Please select an item.");
            System.out.println("========================================");

            for (int i = 0; i<y; i++) {
                System.out.println("" + i + ": " + interm.get(i).getName() + " $" + interm.get(i).getPrice() );
            }
            
            System.out.println("Enter next or '>' for next page");

            do {
                uPlaceholder = uInput.nextLine();
            } while(uPlaceholder.matches("1|2|3|4|5|6|7|8|9|10|next|Next|NEXT|>")==false);
            
            try {
               end = Integer.parseInt(uPlaceholder); 
            } catch(NumberFormatException e) {
                throw new InvalidInputException("Invalid input");
            }
            
            remain-= y;
            
        } while(remain>0);
        
        end = ((end+(10*page))-1);
        
        return(end);
        
    }

    @Override
    public boolean againPrompt() {
        String s;
        System.out.println("Would you like to make another selection?");
        do {
            s = uInput.nextLine();
        } while(s.matches("YES|Y|yes|y|NO|N|n|no")==false);
        
        if(s.matches("Y|YES|y|yes")) {
            return true;
        }
        else {
            return false;
        }
        
    }
    
    @Override
    public void lessMoney() {
        System.out.println("Not enough money for item");
    }

    @Override
    public void clearScreen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BigDecimal askMoney() throws InvalidInputException {
        System.out.println("Please enter the amount of money you'd like to add. (X.XX)");
        String temp;
        temp = uInput.nextLine();
        BigDecimal mInput = new BigDecimal(temp);
        BigDecimal endMoney = mInput.setScale(2, RoundingMode.DOWN);
        return endMoney;
    }
    
    public void dispenseChange(int[] coins) {
        System.out.println("Change dispensing....");
        System.out.println("***clattering***");
        System.out.println("Dollars: " + coins[0]);
        System.out.println("Quarters: " + coins[1]);
        System.out.println("Dimes: " + coins[2]);
        System.out.println("Nickels: " + coins[3]);
        System.out.println("Pennies: " + coins[4]);
    }
}
