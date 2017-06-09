/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.VendingMachine.DAO;

import com.sg.VendingMachine.DTO.Item;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface DAO {
    public List<Item> load() throws FileNotFoundException;
    public BigDecimal search(String name);
    public void save() throws FileNotFoundException, IOException;
}
