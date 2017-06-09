/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.FloorMastery.DTO;

import java.util.List;

/**
 *
 * @author apprentice
 */
public class Options {
    private List<State> states;
    private List<Product> product;
    
    public Options(List<State> uStates, List<Product> uProducts) {
        this.product = uProducts;
        this.states =uStates;
    }

    /**
     * @return the states
     */
    public List<State> getStates() {
        return states;
    }

    /**
     * @param states the states to set
     */
    public void setState(State iState, int index) {
        this.states.get(index).setName(iState.getName());
        this.states.get(index).setTaxRate(iState.getTaxRate());
    }
    
    public void addState(State iState) {
        states.add(iState);
    }

    /**
     * @return the product
     */
    public List<Product> getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product iProduct, int index) {
        this.product.get(index).setName(iProduct.getName());
        this.product.get(index).setPrice(iProduct.getPrice());
        this.product.get(index).setLabor(iProduct.getLabor());
    }
}
