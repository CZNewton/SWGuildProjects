/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.VendingMachine.DAO;

import com.sg.VendingMachine.DTO.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class VendingFuncDAOImpl implements DAO {
    
    public static final String INVFILE = "Resources/Inventory.txt";
    public static final String DELIMITER = "::";
    private List<Item> arranged = new ArrayList();

    @Override
    public List<Item> load() throws FileNotFoundException {
        List<Item> tempArranged = new ArrayList();
        String temp;
        int tempStock = 0;
        String[] hold;
        Scanner read = new Scanner(new BufferedReader(new FileReader(INVFILE)));
        
        while(read.hasNextLine()) {
            temp = read.nextLine();
            hold = temp.split(DELIMITER);
            tempStock = Integer.parseInt(hold[0]);
            Item blank = new Item(hold[1], hold[2], tempStock);
            tempArranged.add(blank);
        }
        
        arranged = 
                tempArranged.stream()
                    .filter(x -> x.getStock() != 0)
                    .collect(Collectors.toList());
        
        
        return arranged;
    }

    @Override
    public BigDecimal search(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save() throws FileNotFoundException, IOException {
        PrintWriter write = new PrintWriter(new FileWriter(INVFILE));
        
        arranged.stream()
                .forEach(i -> write.print(i.getStock() + DELIMITER + i.getName() + DELIMITER + i.getPrice()));
    }
}
