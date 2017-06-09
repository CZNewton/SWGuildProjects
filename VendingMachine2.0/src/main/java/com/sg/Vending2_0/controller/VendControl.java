/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.Vending2_0.controller;

import com.sg.VendingMachine2_0.Service.InsuffecientFundException;
import com.sg.VendingMachine2_0.Service.InsuffecientSupplyException;
import com.sg.VendingMachine2_0.Service.VendServ;
import com.sg.VendingMachine2_0.View.VendView;
import com.sg.Vendingmachine2_0.DTO.Coins;
import com.sg.Vendingmachine2_0.DTO.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class VendControl {

    VendView prompt;
    VendServ uData;

    public VendControl(VendView myView, VendServ myService) {
        this.prompt = myView;
        this.uData = myService;
    }

    public void run() {
        boolean again = true;
        boolean clean = true;
        do {
            List<Item> trans = uData.update();
            BigDecimal money = new BigDecimal("0.00");
            BigDecimal money2 = new BigDecimal("0.00");
            money = prompt.askMoney();
            Coins changeOne = new Coins(money);
            Item choice = prompt.displayMenu(trans);
            try {
                money2 = uData.transaction(choice, money);
            } catch (InsuffecientSupplyException ex) {
                clean = false; 
                System.out.println("Out of stock");
            } catch (InsuffecientFundException ey) {
                clean = false;
                System.out.println("Not enough money");
            }
            Coins changeTwo = new Coins(money2);
            if (clean == true) {
                prompt.dispenseChange(changeTwo);
            } else {
                prompt.dispenseChange(changeOne);
            }
            again = prompt.redo();
        } while (again == true);
        prompt.exit();
        uData.writeOut();
    }
}
