/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.FloorMastery.service;

import com.sg.FloorMastery.DAO.FloorDAO;
import com.sg.FloorMastery.DAO.FloorDAOImpl;
import com.sg.FloorMastery.DTO.Options;
import com.sg.FloorMastery.DTO.Order;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class FloorServImplTest {
    
    private FloorDAO dao;
    private FloorServ service;
    
    public FloorServImplTest() {
        String ORDERDIR="Resources/TestData/TestOrders";
        String DATA="Resources/TestData";
        this.dao = new FloorDAOImpl(ORDERDIR, DATA);
        this.service = new FloorServImpl(dao);
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
     * Test of initLoad method, of class FloorServImpl.
     */
    @Test
    public void testInitLoad() {    }

    /**
     * Test of getOptions method, of class FloorServImpl.
     */
    @Test
    public void testGetOptions() {    }

    /**
     * Test of arrangeDate method, of class FloorServImpl.
     */
    @Test
    public void testArrangeDate() {
        try{
            dao.loadOrders();
        } catch (FileNotFoundException ex) {
            
        } catch(IOException ey) {
            
        } catch (ParseException ez) {
            
        }
        
        try {
            dao.loadOptions();
        } catch (FileNotFoundException ex) {
             
        } catch(IOException ey) {
            
        }
        System.out.println("arrangeDate");
        List<String> expResult = new ArrayList<>();
        expResult.add("12122012");
        expResult.add("07172000");
        expResult.add("01061999");
        Collections.sort(expResult, (String d6, String d7) -> d6.compareTo(d7));
        LinkedHashMap<String, List<Order>> resultMap = service.arrangeDate();
        List<String> result = new ArrayList<>(resultMap.keySet());
        assertEquals(result.get(0), expResult.get(0));
        assertEquals(result.get(1), expResult.get(1));
        assertEquals(result.get(2), expResult.get(2));
    }

    /**
     * Test of writeOrders method, of class FloorServImpl.
     */
    @Test
    public void testWriteOrders() {    }

    /**
     * Test of Search method, of class FloorServImpl.
     */
    @Test
    public void testSearch() {    }

    /**
     * Test of addOrderValidate method, of class FloorServImpl.
     */
    @Test
    public void testAddOrderValidate() {
        try{
            dao.loadOrders();
        } catch (FileNotFoundException ex) {
            
        } catch(IOException ey) {
            
        } catch (ParseException ez) {
            
        }
        try {
            dao.loadOptions();
        } catch (FileNotFoundException ex) {
             
        } catch(IOException ey) {
            
        }
        System.out.println("addOrderValidate");
        Order check = new Order();
        check.setCusName("Frank De'Beon");                        //sets customer name
        check.setState("FL");                                     //sets state    
        check.setProduct("Glass");                                //sets product type        
        check.setArea(new BigDecimal("10"));                      //sets area
        try {
            check.setDate("12122012");
        } catch (ParseException ex) {
            Logger.getLogger(FloorServImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean result = service.addOrderValidate(check);
        if (!result) {
            fail("Test case for addOrderValidate failure");
        }
    }

    /**
     * Test of getAll method, of class FloorServImpl.
     */
    @Test
    public void testGetAll() {    }
    
}
