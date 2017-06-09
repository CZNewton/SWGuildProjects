/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.VendingMachine.service;

import com.sg.VendingMachine.DTO.Item;
import java.math.BigDecimal;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class VendServiceImplTest {
    
    public VendServiceImplTest() {
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
     * Test of loading method, of class VendServiceImpl.
     */
    @org.junit.Test
    public void testLoading() {
        System.out.println("loading");
        VendServiceImpl instance = new VendServiceImpl();
        List<Item> result = instance.update();
        assertTrue(result.size()>0);
        fail("Arranged list loaded empty");
    }

    /**
     * Test of inputing method, of class VendServiceImpl.
     */
    @org.junit.Test
    public void testInputing() {
        System.out.println("inputing");
        BigDecimal money = null;
        VendServiceImpl instance = new VendServiceImpl();
        BigDecimal expResult = null;
        BigDecimal result = instance.inputing(money);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saving method, of class VendServiceImpl.
     */
    @org.junit.Test
    public void testSaving() {
        System.out.println("saving");
        VendServiceImpl instance = new VendServiceImpl();
        instance.save();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
