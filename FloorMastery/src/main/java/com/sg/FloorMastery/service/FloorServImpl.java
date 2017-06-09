/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.FloorMastery.service;

import com.sg.FloorMastery.DAO.FloorDAO;
import com.sg.FloorMastery.DTO.Options;
import com.sg.FloorMastery.DTO.Order;
import com.sg.FloorMastery.DTO.Product;
import com.sg.FloorMastery.DTO.State;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public class FloorServImpl implements FloorServ {
    
    private FloorDAO dao;
    
    public FloorServImpl(FloorDAO uDAO) {
        this.dao = uDAO;
    }

    @Override
    public void initLoad() {
        try{
            dao.loadOrders();
        } catch (FileNotFoundException ex) {
            
        } catch(IOException ey) {
            
        } catch (ParseException ez) {
            
        }
        
        try {
            dao.loadOptions();
        } catch (FileNotFoundException ex) {
             
        } catch(IOException ey) {
            
        }
    }

    @Override
    public Options getOptions() {
        return dao.getOptions();
    }

    @Override
    public LinkedHashMap<String, List<Order>> arrangeDate() {
        LinkedHashMap<String, List<Order>> arranged = new LinkedHashMap<String, List<Order>>();
        SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");
        
        Map<String, List<Order>> raw = dao.getAllOrders();
        List<String> interm = new ArrayList(raw.keySet());
        Collections.sort(interm, (String d6, String d7) -> d6.compareTo(d7));
        
        for (int i = 0;i<interm.size();i++) {
            arranged.put(interm.get(i), raw.get(interm.get(i)));
        }
        
        return arranged;
    }

    @Override
    public void writeOrders() {
        dao.writeEnd();
    }

    @Override
    public List<Order> Search(String name, int searchParam) {
        List<Order> sResults = new ArrayList<Order>();
        switch(searchParam) {
            case 1: sResults = dao.searchDate(name);
                break;
            case 2: sResults = dao.searchName(name);
                break;
            case 3: sResults = dao.searchProduct(name);
                break;
            case 4: sResults = dao.searchState(name);
                break;
            default: break;
            
        }
        
        return sResults;
        
    }

    @Override
    public boolean addOrderValidate(Order check) {
        boolean good=true;
        Map all = dao.getAllOrders();
        if (all.containsKey(check.getDate())==false) {
            dao.newFile(check.getDate());
            try {
                dao.loadOrders();
            } catch (FileNotFoundException ex) {

            } catch(IOException ey) {

            } catch (ParseException ez) {

            }
        }
        Map<String, List<Order>> allAgain = dao.getAllOrders();
        //check.setOrderNum
        //run dto self-validation
        int tempIndex = allAgain.get(check.getDate()).size();
        double tempOrderNum=0;
        if (tempIndex>0) {
            tempOrderNum = allAgain.get(check.getDate()).get(tempIndex-1).getOrderNum();
        }     
        check.setOrderNum(tempOrderNum+1);
        Options blank = dao.getOptions();
        //get State tax based off of entered name 
        State tempState = blank.getStates().stream()
                .filter(x -> x.getName().equalsIgnoreCase(check.getState()) )
                .findFirst()
                .orElse(null);
        
        //get Product based off of entered name
        Product tempProd = blank.getProduct().stream()
                .filter(x -> x.getName().equalsIgnoreCase(check.getProduct()))
                .findFirst()
                .orElse(null);
        
        //populating values generated from dependent values
        check.calculate(tempState.getTaxRate(),tempProd.getPrice() ,tempProd.getLabor() );
        
        if(check.isClean()) {
            allAgain.get(check.getDate()).add(check);
        }
        else {
            good=false;
        }
        
        return good;
    }

    @Override
    public Map<String, List<Order>> getAll() {
        return dao.getAllOrders();
    }
    
}
