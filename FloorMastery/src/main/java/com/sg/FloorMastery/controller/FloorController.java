/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.FloorMastery.controller;

import com.sg.FloorMastery.DTO.Options;
import com.sg.FloorMastery.DTO.Order;
import com.sg.FloorMastery.Exceptions.InvalidInputException;
import com.sg.FloorMastery.service.FloorServ;
import com.sg.FloorMastery.view.FloorView;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author apprentice
 */

//currently needed:
//Write path
//end of editpath(change date case)

public class FloorController {
    
    private FloorServ service;
    private FloorView prompt;
    
    public FloorController(FloorServ uServ, FloorView uView) {
        this.service = uServ;
        this.prompt = uView;
    }
    
    public void run(){
        boolean again = true;
        int path = 0;
        service.initLoad();
        do {
            path = prompt.displayMenu();
            switch(path) {
                case 1: displayAll();
                    break;
                case 2: addOrder();
                    break;
                case 3: editOrder();
                    break;
                case 4: removeOrder();
                    break;
                case 5: saveWork();
                    break;
                case 6: again=false;
                    break;
                default: prompt.unknownCommand();
                        again=true;
                        break;    
            }
        } while(again==true);
    }
    
    private void displayAll(){
        LinkedHashMap temp = service.arrangeDate();
        prompt.displayAll(temp);
    }
    
    private void addOrder(){
        Options interm = service.getOptions();
        Order temp = prompt.addOrder(interm);
        boolean check = service.addOrderValidate(temp);
        prompt.addResult(check);
    }
    
    private void editOrder() {
        boolean check = false;
        //need to initialize object outside of try-catch
        Order select = new Order();
        do {
            try {
                select = search();
            } catch (InvalidInputException ez) {
                prompt.searchFailure();
                check = true;
            }
        }while(check==true);
        String move = prompt.editProcess(select);
        if (move.matches("na")==false){
            //not finished
            System.out.println("Edit,move,yes");
        }
    }
    
    private void removeOrder() {
        boolean check=false;
        Order select = new Order();
        do {
            try {
                select = search();
            } catch (InvalidInputException ez) {
                prompt.searchFailure();
                check = true;
            }
        }while(check==true);
        
        boolean confirm = prompt.removeConfirm(select);
        if (confirm==true){
            select.setClean(false);
        }
        //reasoning for not using .remove is that
        //this will still 'remove' the relevant order
        //at the time of writing, but it will still
        //be accessible during the program's life
        
    }
    
    private void saveWork() {
        service.writeOrders();
        prompt.saveBanner();
    }
    
    private Order search() throws InvalidInputException {
        Options blank = service.getOptions();
        //ask what search type (date, name, product, state)
        int searchParam = prompt.askSearchParam();
        //ask what of that term to search with
        String searchPrompt = prompt.askSearch(searchParam, blank);
        //actually search
        List<Order> sResults = service.Search(searchPrompt, searchParam);
        //display serach results and choose via user input
        Order selected = prompt.displaySearch(sResults, searchPrompt);
        
        return selected;
    }
}
