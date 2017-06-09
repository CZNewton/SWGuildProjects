/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.VendingMachine2_0.View;

import com.sg.Vendingmachine2_0.DTO.Coins;
import com.sg.Vendingmachine2_0.DTO.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface VendView {
    public BigDecimal askMoney();
    public Item displayMenu(List<Item> inven);
    public void dispenseChange(Coins change);
    public boolean redo();
    public void exit();
}
