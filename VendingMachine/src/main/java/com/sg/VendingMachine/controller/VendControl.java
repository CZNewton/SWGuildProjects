/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.VendingMachine.controller;

import com.sg.VendingMachine.DTO.Item;
import com.sg.VendingMachine.service.InvalidInputException;
import com.sg.VendingMachine.service.VendService;
import com.sg.VendingMachine.ui.VendView;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class VendControl {

    VendView prompt;
    VendService uData;

    public VendControl(VendView myView, VendService myService) {
        this.prompt = myView;
        this.uData = myService;
    }

    public void run() {
        boolean again = false;
        List<Item> interm = new ArrayList();
        interm = uData.loading();

        do {
            again = vend(interm);
        } while (again = true);

        uData.saving();

    }

    private boolean vend(List<Item> temp) {
        boolean again = false;
        boolean checkGood = true;
        int choice = -1;
        BigDecimal a = new BigDecimal("0");
        BigDecimal priceTemp = a.setScale(2, RoundingMode.HALF_DOWN);
        BigDecimal priceComp = a.setScale(2, RoundingMode.HALF_DOWN);
        BigDecimal money = a.setScale(2, RoundingMode.HALF_DOWN);
        BigDecimal moneyY = a.setScale(2, RoundingMode.HALF_DOWN);

        do {
            try {
                choice = prompt.displayMenu(temp);
            } catch (InvalidInputException e) {
                checkGood = false;
            }
        } while (checkGood == false);

        do {
            try {
                prompt.askMoney();
            } catch (InvalidInputException e) {
                checkGood = false;
            }
        } while (checkGood == false);

        priceTemp = temp.get(choice).getPrice();
        try {
            priceComp = uData.inputing(priceTemp);
        } catch (InvalidInputException e) {
            System.out.println("Invalid BigDecimal syntax");
        }

        if (moneyY.compareTo(priceComp) > 0) {
            moneyY = money.subtract(priceComp);
            int tempStock = temp.get(choice).getStock();
            temp.get(choice).setStock((tempStock - 1));
        } else {
            prompt.lessMoney();
        }

        again = prompt.againPrompt();

        return again;
    }

    private void dispenseChange(BigDecimal leftovers) {
        BigDecimal compareDollar = new BigDecimal("1");
        BigDecimal compareQuarter = new BigDecimal("0.25");
        BigDecimal compareDime = new BigDecimal("0.1");
        BigDecimal compareNickel = new BigDecimal("0.05");
        BigDecimal comparePenny = new BigDecimal("0.01");
        int[] coins = new int[5];
        if (leftovers.compareTo(compareDollar) > 0) {
            while (leftovers.compareTo(compareDollar) > 0) {
                leftovers.subtract(compareDollar);
                coins[0]++;
            }
        } else if (leftovers.compareTo(compareQuarter) > 0) {
            while (leftovers.compareTo(compareQuarter) > 0) {
                leftovers.subtract(compareQuarter);
                coins[1]++;
            }
        } else if (leftovers.compareTo(compareDime) > 0) {
            while (leftovers.compareTo(compareDime) > 0) {
                leftovers.subtract(compareDime);
                coins[2]++;
            }
        } else if (leftovers.compareTo(compareNickel) > 0) {
            while (leftovers.compareTo(compareNickel) > 0) {
                leftovers.subtract(compareNickel);
                coins[3]++;
            }
        } else if (leftovers.compareTo(comparePenny) > 0) {
            while (leftovers.compareTo(comparePenny) > 0) {
                leftovers.subtract(comparePenny);
                coins[4]++;
            }
        }
        prompt.dispenseChange(coins);
    }
}
