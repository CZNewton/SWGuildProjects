/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.VendingMachine.DTO;

import java.math.BigDecimal;

/**
 *
 * @author apprentice
 */
public class Item {
    private String name;
    private BigDecimal price;
    private int stock;
    
    public Item(String iName, String readPrice, int iStock) {
        this.name = iName;
        this.stock = iStock;
        BigDecimal iPrice = new BigDecimal(readPrice);
        this.price = iPrice;
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
}
