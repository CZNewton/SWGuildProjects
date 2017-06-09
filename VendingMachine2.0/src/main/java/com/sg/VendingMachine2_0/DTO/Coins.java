/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.Vendingmachine2_0.DTO;

import java.math.BigDecimal;

/**
 *
 * @author apprentice
 */
public class Coins {
    
    private int dollars, quarters, dimes, nickels, pennies;
    private BigDecimal leftover;
    
    
    public Coins(BigDecimal money) {
        this.leftover = money;
        BigDecimal dollarCompare = new BigDecimal("1.00");
        dollars = 0;
        BigDecimal quarterCompare = new BigDecimal("0.25");
        quarters = 0;
        BigDecimal dimeCompare = new BigDecimal("0.10");
        dimes = 0;
        BigDecimal nickelCompare = new BigDecimal("0.05");
        nickels = 0;
        BigDecimal pennyCompare = new BigDecimal("0.01");
        pennies = 0;
        while (money.compareTo(dollarCompare)>=0) {
            money = money.subtract(dollarCompare);
            dollars++;
        }
        while (money.compareTo(quarterCompare)>=0) {
            money = money.subtract(quarterCompare);
            quarters++;
        }
        while (money.compareTo(dimeCompare)>=0) {
            money = money.subtract(dimeCompare);
            dimes++;
        }
        while (money.compareTo(nickelCompare)>=0) {
            money = money.subtract(nickelCompare);
            nickels++;
        }
        while (money.compareTo(pennyCompare)>=0) {
            money = money.subtract(pennyCompare);
            pennies++;
        }
        
    }
    
    public BigDecimal getLeftover() {
        return leftover;
    }
    public int getDollar() {
        return dollars;
    }
    public int getQuarter() {
        return quarters;
    }
    public int getDime() {
        return dimes;
    }
    public int getNickel() {
        return nickels;
    }
    public int getPenny() {
        return pennies;
    }
    
    
}
