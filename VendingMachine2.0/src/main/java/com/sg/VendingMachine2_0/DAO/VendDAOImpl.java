package com.sg.VendingMachine2_0.DAO;

import com.sg.Vendingmachine2_0.DTO.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class VendDAOImpl implements VendDAO {
    
    private String INVFILE = "Resources/Inventory";
    public static final String DELIMITER = "::";
    private List<Item> raw = new ArrayList<Item>();
    
    public VendDAOImpl() {
        
    }
    public VendDAOImpl(String upINVFILE) {
        this.INVFILE = upINVFILE;
    }
    
    public List<Item> update() throws FileNotFoundException {
        Scanner read = new Scanner(new BufferedReader(new FileReader(INVFILE)));
        String temp;
        String hold[];
        int tempStock;
        while(read.hasNextLine()) {
            temp = read.nextLine();
            hold = temp.split(DELIMITER);
            tempStock = Integer.parseInt(hold[0]);
            //stock, name, price
            Item blank = new Item(tempStock, hold[1], hold[2]);
            raw.add(blank);
        }
        return raw;
    }
    
    public void writeOut() throws FileNotFoundException, IOException {
        PrintWriter write = new PrintWriter(new FileWriter(INVFILE));
        raw.stream()
            .forEach(i -> write.println(i.getStock() + DELIMITER + i.getName() + DELIMITER + i.getPrice()));
        
        //for(Item i : raw) {
        //   write.println(i.getStock() + DELIMITER + i.getName() + DELIMITER + i.getPrice());
        //}
        
        write.flush();
        write.close();

    }
    
    @Override
    public void writeOut(String output) throws FileNotFoundException, IOException {
        PrintWriter write = new PrintWriter(new FileWriter(INVFILE));
        write.println(output);
        
        write.flush();
        write.close();
    }
    
}
