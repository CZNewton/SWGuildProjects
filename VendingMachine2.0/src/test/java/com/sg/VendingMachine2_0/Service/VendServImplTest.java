/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.VendingMachine2_0.Service;

import com.sg.Vendingmachine2_0.DTO.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class VendServImplTest {
    
    private ApplicationContext xml;
    
    public VendServImplTest() {
        ApplicationContext ctxTest = new ClassPathXmlApplicationContext("TestApplicationContext.xml");
        this.xml = ctxTest;
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
     * Test of transaction method, of class VendServImpl.
     */
    @Test
    public void testTransaction() throws Exception {
        System.out.println("transaction");
        
        Item choice = new Item(5, "test", "0.50");
        
        BigDecimal moneyInput = new BigDecimal("2.00");
        
        VendServ instance = xml.getBean("testService", VendServ.class);
        
        BigDecimal expResult = new BigDecimal("1.50");
        
        BigDecimal result = new BigDecimal("-1.00");
        try {result = instance.transaction(choice, moneyInput);}
        catch (InsuffecientFundException ey) {}
        catch (InsuffecientSupplyException ex) {}
        
        assertEquals(expResult, result);
    }

    /**
     * Test of save method, of class VendServImpl.
     */
    @Test
    public void testSave() {

    }

    /**
     * Test of update method, of class VendServImpl.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        VendServ instance = xml.getBean("testService", VendServ.class);
        Item one = new Item(3, "SodaOne", "4.50");
        Item two = new Item(2, "SodaTwo", "2.75");
        Item three = new Item(5, "SodaThree", "1.50");
        List<Item> expResult = new ArrayList<Item>();
        expResult.add(one);
        expResult.add(two);
        expResult.add(three);
        List<Item> result = instance.update();
        assertEquals(expResult.get(0).getName(), result.get(0).getName());
        assertEquals(expResult.get(1).getPrice(), result.get(1).getPrice());
        assertEquals(expResult.get(2).getStock(), result.get(2).getStock());
    }
    
}
