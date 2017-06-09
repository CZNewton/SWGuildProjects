/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.VendingMachine2_0.DAO;

import com.sg.Vendingmachine2_0.DTO.Item;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface VendDAO {
    public List<Item> update() throws FileNotFoundException;
    public void writeOut() throws FileNotFoundException, IOException;
    public void writeOut(String output) throws FileNotFoundException, IOException;
}
