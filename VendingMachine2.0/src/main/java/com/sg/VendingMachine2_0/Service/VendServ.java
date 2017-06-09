/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.VendingMachine2_0.Service;

import com.sg.VendingMachine2_0.DAO.VendDAO;
import com.sg.VendingMachine2_0.DAO.VendDAOImpl;
import com.sg.Vendingmachine2_0.DTO.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface VendServ {
    public List<Item> update();
    public BigDecimal transaction(Item choice, BigDecimal moneyInput) throws
            InsuffecientSupplyException,
            InsuffecientFundException;
    public void writeOut();
}
