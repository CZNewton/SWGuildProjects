/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.VendingMachine2_0.Service;

import com.sg.VendingMachine2_0.DAO.VendDAO;
import com.sg.Vendingmachine2_0.DTO.Item;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class VendServImpl implements VendServ {
    
    private VendDAO dao;
    
    public VendServImpl() {
        
    }

    public VendServImpl(VendDAO myDAO) {
        this.dao = myDAO;
    }
    
    @Override
    public List<Item> update() {
        List<Item> raw = new ArrayList<Item>();
        List<Item> filtered = new ArrayList<Item>();
        try {
            raw = dao.update();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found. 411 is 404 fyi.");
        }
        filtered = 
                raw.stream()
                    .filter(x -> x.getStock() != 0)
                    .collect(Collectors.toList());
        return filtered;
    }
    
    @Override
    public BigDecimal transaction(Item choice, BigDecimal moneyInput) throws 
            InsuffecientFundException, 
            InsuffecientSupplyException {
        
        InsuffecientSupplyException ex = new InsuffecientSupplyException("Not enough Supply");
        InsuffecientFundException ey = new InsuffecientFundException("Not enough money");
        
        if (choice.getStock()==0) {
            throw ex;
        }
        
        BigDecimal a = new BigDecimal("0");
        BigDecimal compareZero = a.setScale(2, RoundingMode.DOWN);
        BigDecimal middleMan = a.setScale(2, RoundingMode.DOWN);
        middleMan = moneyInput.subtract(choice.getPrice());
        
        if (middleMan.compareTo(compareZero)<0) {
            throw ey;
        }
        else  {
            choice.setStock(choice.getStock()-1);
            return middleMan;
        }
    }
    
    @Override
    public void writeOut() {
        try {
            dao.writeOut();
        } catch (FileNotFoundException e) {
            System.out.println("Save Error - File Not Found");
        } catch (IOException y) {
            System.out.println("Save Error - Input/Output Error");
        }
    }
}
