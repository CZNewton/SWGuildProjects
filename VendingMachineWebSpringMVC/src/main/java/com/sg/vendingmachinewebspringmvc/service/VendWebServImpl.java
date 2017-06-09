/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinewebspringmvc.service;

import com.sg.vendingmachinewebspringmvc.dao.VendingMachineInMemDAO;
import com.sg.vendingmachinewebspringmvc.dto.Coins;
import com.sg.vendingmachinewebspringmvc.dto.Item;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/**
 *
 * @author apprentice
 */
public class VendWebServImpl implements VendWebServ {
    
    private VendingMachineInMemDAO dao;
    
    @Inject
    public VendWebServImpl(VendingMachineInMemDAO uDAO) {
        this.dao = uDAO;
    }
    
    @Override
    public void loadItems() {
        dao.loadItems();
    }
    
    @Override
    public void addMoney(String coinType) {
        if(coinType.equalsIgnoreCase("dollar")) {
            dao.addMoney(new BigDecimal("1.00"));
        } else if(coinType.equalsIgnoreCase("quarter")) {
            dao.addMoney(new BigDecimal("0.25"));
        } else if(coinType.equalsIgnoreCase("dime")) {
            dao.addMoney(new BigDecimal("0.10"));
        } else if(coinType.equalsIgnoreCase("nickel")) {
            dao.addMoney(new BigDecimal("0.05"));
        }
    }
    
    @Override
    public BigDecimal updateMoney() {
        return dao.getMoney();
    }
    
    @Override
    public void transaction(String name) throws 
            InsuffecientFunds,
            InsuffecientStock
    {
        BigDecimal money = dao.getMoney();
        Item blank = dao.getSpecific(name);
        if(blank.getQuantity()<=0) {
            throw new InsuffecientStock("Item is out of stock");
        } else if(blank.getPrice().compareTo(money)>0) {
            throw new InsuffecientFunds("Please insert more money");
        } else {
          dao.buyItem(blank);  
        }
    }
    
    @Override
    public Coins dispenseChange() {
        Coins result = new Coins(dao.getMoney());
        dao.resetMoney();
        return result;
    }
    
    @Override
    public List<Item> getAll() {
        return dao.getAll();
    }
}
