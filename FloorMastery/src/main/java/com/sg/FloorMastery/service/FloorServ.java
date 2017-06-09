/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.FloorMastery.service;

import com.sg.FloorMastery.DTO.Options;
import com.sg.FloorMastery.DTO.Order;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface FloorServ {
    public void initLoad();
    public Map<String, List<Order>> getAll();
    public Options getOptions();;
    public LinkedHashMap<String, List<Order>> arrangeDate();
    public void writeOrders();
    public List<Order> Search(String name, int searchParam);
    public boolean addOrderValidate(Order check);
}
