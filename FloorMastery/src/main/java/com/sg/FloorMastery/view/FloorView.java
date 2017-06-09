/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.FloorMastery.view;

import com.sg.FloorMastery.DTO.Options;
import com.sg.FloorMastery.DTO.Order;
import com.sg.FloorMastery.Exceptions.InvalidInputException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface FloorView {
    public int displayMenu();
    public void displayAll(LinkedHashMap<String, List<Order>> readAll);
    public Order displaySearch(List<Order> results, String param) throws InvalidInputException;
    public String askSearch(int param, Options choices);
    public Order addOrder(Options choices);
    public void addResult(boolean check);
    public void unknownCommand();
    public String editProcess(Order select);
    public int askSearchParam();
    public void searchFailure();
    public boolean removeConfirm(Order tobeRemoved);
    public void saveBanner();
}
