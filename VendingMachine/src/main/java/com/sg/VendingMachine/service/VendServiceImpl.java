/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.VendingMachine.service;

import com.sg.VendingMachine.DAO.DAO;
import com.sg.VendingMachine.DAO.VendingFuncDAOImpl;
import com.sg.VendingMachine.DTO.Item;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class VendServiceImpl implements VendService {

    private DAO lefty = new VendingFuncDAOImpl();
    
    @Override
    public List<Item> loading() {
        List<Item> tosser = new ArrayList();
        try{
            tosser = lefty.load();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return tosser;
    }

    @Override
    public BigDecimal inputing(BigDecimal priceComp) throws InvalidInputException {
        BigDecimal a = new BigDecimal("0");
        priceComp = a.setScale(2, RoundingMode.HALF_DOWN);
        return priceComp;
    }
    
    @Override
    public void saving() {
        try{
            lefty.save();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IO error");
        }
    }
    
}
