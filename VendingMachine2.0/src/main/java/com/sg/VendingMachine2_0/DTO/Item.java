/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.Vendingmachine2_0.DTO;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author apprentice
 */
public class Item {
    private int stock;
    private String name;
    private BigDecimal price;
    
    public Item(int uStock, String uName, String uPrice) {
        this.stock = uStock;
        this.name = uName;
        BigDecimal blank = new BigDecimal(uPrice);
        this.price = blank.setScale(2, RoundingMode.DOWN);
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }
    
}
