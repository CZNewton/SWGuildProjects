/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.FloorMastery.DTO;

import java.math.BigDecimal;

/**
 *
 * @author apprentice
 */
public class Product {
    
    private String name;
    private BigDecimal PricePerSqFt,
            LaborCostperSqFt;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the PricePerSqFt
     */
    public BigDecimal getPrice() {
        return PricePerSqFt;
    }

    /**
     * @param PricePerSqFt the PricePerSqFt to set
     */
    public void setPrice(BigDecimal PricePerSqFt) {
        this.PricePerSqFt = PricePerSqFt;
    }

    /**
     * @return the LaborCostperSqFt
     */
    public BigDecimal getLabor() {
        return LaborCostperSqFt;
    }

    /**
     * @param LaborCostperSqFt the LaborCostperSqFt to set
     */
    public void setLabor(BigDecimal LaborCostperSqFt) {
        this.LaborCostperSqFt = LaborCostperSqFt;
    }
    
}
