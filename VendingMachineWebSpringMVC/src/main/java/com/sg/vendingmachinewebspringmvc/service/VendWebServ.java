/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinewebspringmvc.service;

import com.sg.vendingmachinewebspringmvc.dto.Coins;
import com.sg.vendingmachinewebspringmvc.dto.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface VendWebServ {

    void addMoney(String coinType);

    Coins dispenseChange();

    List<Item> getAll();

    void loadItems();

    void transaction(String name) throws InsuffecientFunds, InsuffecientStock;

    BigDecimal updateMoney();
    
}
