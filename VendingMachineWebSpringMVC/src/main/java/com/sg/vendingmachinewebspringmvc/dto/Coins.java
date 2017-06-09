/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinewebspringmvc.dto;

import java.math.BigDecimal;

/**
 *
 * @author apprentice
 */
public class Coins {
    private int quarters = 0;
    private int dimes = 0;
    private int nickels = 0;
    private int pennies = 0;
    
    public Coins (BigDecimal cMoney) {
        
        BigDecimal quarterValue = new BigDecimal("0.25");
        BigDecimal dimeValue = new BigDecimal("0.10");
        BigDecimal nickelValue = new BigDecimal("0.05");
        BigDecimal pConvert = new BigDecimal("100");
        
        while(cMoney.compareTo(quarterValue)>=0) {
            cMoney = cMoney.subtract(quarterValue);
            quarters++;
        }
        while(cMoney.compareTo(dimeValue)>=0) {
            cMoney = cMoney.subtract(dimeValue);
            dimes++;
        }
        while(cMoney.compareTo(nickelValue)>=0) {
            cMoney = cMoney.subtract(nickelValue);
            nickels++;
        }
        this.pennies = (cMoney.multiply(pConvert)).intValueExact();
    }

    /**
     * @return the quarters
     */
    public int getQuarters() {
        return quarters;
    }

    /**
     * @param quarters the quarters to set
     */
    public void setQuarters(int quarters) {
        this.quarters = quarters;
    }

    /**
     * @return the dimes
     */
    public int getDimes() {
        return dimes;
    }

    /**
     * @param dimes the dimes to set
     */
    public void setDimes(int dimes) {
        this.dimes = dimes;
    }

    /**
     * @return the nickels
     */
    public int getNickels() {
        return nickels;
    }

    /**
     * @param nickels the nickels to set
     */
    public void setNickels(int nickels) {
        this.nickels = nickels;
    }

    /**
     * @return the pennies
     */
    public int getPennies() {
        return pennies;
    }

    /**
     * @param pennies the pennies to set
     */
    public void setPennies(int pennies) {
        this.pennies = pennies;
    }
}
