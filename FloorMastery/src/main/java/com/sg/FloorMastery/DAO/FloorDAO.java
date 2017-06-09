/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.FloorMastery.DAO;

import com.sg.FloorMastery.DTO.Options;
import com.sg.FloorMastery.DTO.Order;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface FloorDAO {
    public void loadOrders() throws FileNotFoundException, IOException, ParseException;
    public void loadOptions() throws FileNotFoundException, IOException;
    public void writeEnd();
    public Options getOptions();
    public Map<String, List<Order>> getAllOrders();
    public void newFile(String date);
    public List<Order> searchDate(String input);
    public List<Order> searchName(String input);
    public List<Order> searchProduct(String input);
    public List<Order> searchState(String input);
    
}
