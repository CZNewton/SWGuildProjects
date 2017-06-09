/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.VendingMachine.ui;

import com.sg.VendingMachine.DTO.Item;
import com.sg.VendingMachine.service.InvalidInputException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface VendView {
    public int displayMenu(List<Item> interm) throws InvalidInputException;
    public boolean againPrompt();
    public void clearScreen();
    public BigDecimal askMoney() throws InvalidInputException;
    public void dispenseChange(int[] coins);
    public void lessMoney();
}
