/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.VendingMachine.service;

import com.sg.VendingMachine.DTO.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface VendService {
    public List<Item> loading();
    public BigDecimal inputing(BigDecimal money) throws InvalidInputException;
    public void saving();
}
