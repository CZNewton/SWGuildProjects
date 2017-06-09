/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinewebspringmvc.service;

import com.sg.vendingmachinewebspringmvc.dao.VendingMachineInMemDAO;
import com.sg.vendingmachinewebspringmvc.dto.Coins;
import com.sg.vendingmachinewebspringmvc.dto.Item;
import java.math.BigDecimal;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class VendWebServImplTest {
    
    public VendWebServImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of loadItems method, of class VendWebServImpl.
     */
    @Test
    public void testLoadItems() {    }

    /**
     * Test of addMoney method, of class VendWebServImpl.
     */
    @Test
    public void testAddMoney() {
        VendingMachineInMemDAO uDAO = new VendingMachineInMemDAO();
        VendWebServ instance = new VendWebServImpl(uDAO);
        instance.addMoney("dollar");
        BigDecimal testMoney = uDAO.getMoney();
        BigDecimal testMoneyExp = new BigDecimal("1.00");
        assertTrue((testMoney.compareTo(testMoneyExp))==0);
    }

    /**
     * Test of updateMoney method, of class VendWebServImpl.
     */
    @Test
    public void testUpdateMoney() {    }

    /**
     * Test of transaction method, of class VendWebServImpl.
     */
    @Test
    public void testTransaction() throws Exception {
        System.out.println("transaction");
        String name = "Whoppers";
        VendingMachineInMemDAO uDAO = new VendingMachineInMemDAO();
        uDAO.loadItems();
        VendWebServ instance = new VendWebServImpl(uDAO);
        uDAO.addMoney(new BigDecimal("1.25"));
        instance.transaction(name);
        assertTrue((uDAO.getSpecific("Whoppers").getQuantity())==2);
    }

    /**
     * Test of dispenseChange method, of class VendWebServImpl.
     */
    @Test
    public void testDispenseChange() {
        System.out.println("dispenseChange");
        VendingMachineInMemDAO uDAO = new VendingMachineInMemDAO();
        VendWebServ instance = new VendWebServImpl(uDAO);
        uDAO.addMoney(new BigDecimal("1.30"));
        Coins result = instance.dispenseChange();
        assertEquals(result.getQuarters(), 5);
        assertEquals(result.getNickels(), 1);
    }

    /**
     * Test of getAll method, of class VendWebServImpl.
     */
    @Test
    public void testGetAll() {    }
    
}
