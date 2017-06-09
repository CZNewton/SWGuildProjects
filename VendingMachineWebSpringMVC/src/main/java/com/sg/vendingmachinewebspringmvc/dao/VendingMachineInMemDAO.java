/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinewebspringmvc.dao;

import com.sg.vendingmachinewebspringmvc.dto.Coins;
import com.sg.vendingmachinewebspringmvc.dto.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public class VendingMachineInMemDAO {
    
    private List<Item> inventory;
    private BigDecimal currentMoney;
    
    public VendingMachineInMemDAO() {
        this.inventory = new ArrayList<Item>();
        this.currentMoney = new BigDecimal("0.00");
    }
    
    public void loadItems() {
        
        //examples for demonstarting DAO effectiveness without calling a foreign database
        String[] nameEx = {"Snickers", "M&M's", "Whoppers", "Sugar Bombs", "WillWheaties"};
        BigDecimal[] priceEx = {new BigDecimal("3.00"), new BigDecimal("4.50"), new BigDecimal("1.25"), new BigDecimal("5.00"), new BigDecimal("75.75")};
        int[] quantEx = {5, 6, 3, 2, 7};
        
        for (int i=inventory.size();i<nameEx.length;i++){
            Item currentItem = new Item();
            currentItem.setName(nameEx[i]);
            currentItem.setPrice(priceEx[i]);
            currentItem.setQuantity(quantEx[i]);
            inventory.add(currentItem);
        }
        
    }
    
    public void addMoney(BigDecimal addition) {
        currentMoney = currentMoney.add(addition);
    }
    
    public BigDecimal getMoney() {
        return currentMoney;
    }
    
    public Coins returnMoney() {
        return new Coins(currentMoney);
    }
    
    public List<Item> getAll() {
        return inventory;
    }
    
    public void resetMoney() {
        currentMoney = currentMoney.subtract(currentMoney);
    }
    
    public Item getSpecific(String name) {
        for (Item current : inventory) {
            if (current.getName().matches(name)) {
                return current;
            }
        }
        return null;
    }
    
    public int askMoney(Item relevant) {
        return (relevant.getPrice().compareTo(currentMoney));
    }
    
    public void buyItem(Item current) {
        current.setQuantity(current.getQuantity()-1);
        currentMoney = currentMoney.subtract(current.getPrice());
    }
}
