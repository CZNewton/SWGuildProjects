/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.VendingMachine2_0.View;

import com.sg.Vendingmachine2_0.DTO.Coins;
import com.sg.Vendingmachine2_0.DTO.Item;
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
    
    public VendViewImpl() {
        Scanner blank = new Scanner(System.in);
        this.uInput = blank;
    }

    public BigDecimal askMoney() {
        System.out.println("Please enter the amount of money you'd like to add. (X.XX)");
        String temp;
        boolean checkGood=true;
        BigDecimal endMoney = new BigDecimal("0");
        do {
            try {
                temp = uInput.nextLine();
                BigDecimal mInput = new BigDecimal(temp);
                endMoney = mInput.setScale(2, RoundingMode.DOWN);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                checkGood=false;
            }
            checkGood=true;
        } while (checkGood==false);
        return endMoney;
    }

    public Item displayMenu(List<Item> inven) {
        String uPlaceholder;
        int y = 10;
        int remain = inven.size();
        int doubleback = remain;
        int end = 0;
        int page = 0;

        do {
            page++;
            if (remain < y) {
                y = remain;
            } else {
                y = 10;
            }

            System.out.println("Please select an item.");
            System.out.println("========================================");

            for (int i = 0; i < y; i++) {
                 System.out.println("" + i + ": " + inven.get(i).getName() + " $" + inven.get(i).getPrice());
            }

            System.out.println("Enter next or '>' for next page");

            do {
                uPlaceholder = uInput.nextLine();
            } while (uPlaceholder.matches("1|2|3|4|5|6|7|8|9|10|next|Next|NEXT|>") == false);

            if (uPlaceholder.matches("1|2|3|4|5|6|7|8|9|10")) {
                try {
                    end = Integer.parseInt(uPlaceholder);
                } catch (NumberFormatException e) {
                    System.out.println("Format Error at menu conversion");
                    page--;
                    continue;
                }
                break;
            } else if (remain<y) {
               remain = doubleback; 
            } else {
               remain -= y;
            }
            

        } while (remain > 0);

        end = ((end + (10 * (page-1))));

        return inven.get(end);
    }

    public void dispenseChange(Coins change) {
        System.out.println("Change dispensing....");
        System.out.println("***clattering***");
        System.out.println("Dollars: " + change.getDollar());
        System.out.println("Quarters: " + change.getQuarter());
        System.out.println("Dimes: " + change.getDime());
        System.out.println("Nickels: " + change.getNickel());
        System.out.println("Pennies: " + change.getPenny());
        System.out.println("--------------------------------");
        System.out.println("Total of $" + change.getLeftover());
    }

    public boolean redo() {
        String s;
        System.out.println("Would you like to make another selection?");
        do {
            s = uInput.nextLine();
        } while (s.matches("YES|Y|yes|y|NO|N|n|no") == false);

        if (s.matches("Y|YES|y|yes")) {
            return true;
        } else {
            return false;
        }
    }

    public void exit() {
        System.out.println("Transaction complete, thank you. Please come again");
    }
}
