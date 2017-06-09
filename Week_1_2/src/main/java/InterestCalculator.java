/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */

import java.util.Scanner;
public class InterestCalculator {
    public static void main(String[] args) {
        Scanner uInput = new Scanner(System.in);
        int years, leapY, i, x;
        double rate, aRate, principal, money, tInterest;
        String uPlaceholder;
        leapY=0;
        i=0;
        rate=0;
        tInterest = 0;
        
        
        System.out.println("Welcome to loadyou.com/totallynotshady!");
        System.out.println("What loan principal do you have today for your quote?");
        uPlaceholder = uInput.nextLine();
        principal = Double.parseDouble(uPlaceholder);
        money = principal;
        
        System.out.println("Fantastic! Now how long will this loan be (in years)?");
        uPlaceholder = uInput.nextLine();
        years = Integer.parseInt(uPlaceholder);
        
        System.out.println("Alright now just one more thing, what annual rate?");
        uPlaceholder = uInput.nextLine();
        aRate = Double.parseDouble(uPlaceholder);
        aRate /= 100;
        
        System.out.println("I lied. One mooooooooore thing. Now what update frequency would you like?\nDaily, Monthly, or Quarterly?");
        uPlaceholder = uInput.nextLine();
        uPlaceholder = uPlaceholder.toUpperCase();
        
        while (uPlaceholder.equals("DAILY")==false && uPlaceholder.equals("MONTHLY")==false && uPlaceholder.equals("QUARTERLY")==false) {
            System.out.println("I'm sorry I didn't quite get that. Let's try again.\n Daily, Monthly, or Quarterly?");
            uPlaceholder = uInput.nextLine();
            uPlaceholder = uPlaceholder.toUpperCase();
        }
        
        if (uPlaceholder.equals("DAILY")) {
            rate = aRate/365;
            
            for (x = 0; x<years; x++) {
                for (i = 0; i<365;i++) {
                    money *= (rate+1);
                    tInterest += money*rate;
                    if (leapY==4) {
                        i--;
                        leapY=0;
                    }
                }
                leapY++;
            }
        }
        
        else if (uPlaceholder.equals("MONTHLY")) {
            rate = aRate/12;
            
            for (x = 0; x<years; x++) {
                for(i = 0; i<12;i++) {
                    money*= (rate+1);
                    tInterest += money*rate;
                }
            }
        }
        
        else if (uPlaceholder.equals("QUARTERLY")) {
            rate = aRate/4;
            for (x = 0; x<years; x++) {
                for(i = 0; i<12;i++) {
                    money*= (rate+1);
                    tInterest += money*rate;
                }
            }
        }
        
        money = (double)Math.round(money*100d)/100;
        tInterest = (double)Math.round(tInterest*100d)/100;
        
        System.out.println("Your investment of $" + principal + " over " + years + " years will amount to " + money + "\nvia a total " + uPlaceholder + " interest of $" + tInterest);
        
    }
}
