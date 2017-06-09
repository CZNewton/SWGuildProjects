/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.FloorMastery.DAO;

import com.sg.FloorMastery.DTO.Options;
import com.sg.FloorMastery.DTO.Order;
import com.sg.FloorMastery.DTO.Product;
import com.sg.FloorMastery.DTO.State;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
public class FloorDAOImplTest {

    private FloorDAO dao;
    private SimpleDateFormat sdf = new SimpleDateFormat("MMddyyy");
    
    public FloorDAOImplTest() {
        String ORDERDIR="Resources/TestData/TestOrders";
        String DATA="Resources/TestData";
        this.dao = new FloorDAOImpl(ORDERDIR, DATA);
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
     * Test of loadOrders method, of class FloorDAOImpl.
     */
    @Test
    public void testLoadOrders() throws Exception {    }

    /**
     * Test of loadOptions method, of class FloorDAOImpl.
     */
    @Test
    public void testLoadOptions() throws Exception {    }

    /**
     * Test of writeEnd method, of class FloorDAOImpl.
     */
    @Test
    public void testWriteEnd() {    }

    /**
     * Test of getOptions method, of class FloorDAOImpl.
     */
    @Test
    public void testGetOptions() {    }

    /**
     * Test of getAllOrders method, of class FloorDAOImpl.
     */
    @Test
    public void testGetAllOrders() {    }

    /**
     * Test of newFile method, of class FloorDAOImpl.
     */
    @Test
    public void testNewFile() {    }

    /**
     * Test of searchDate method, of class FloorDAOImpl.
     */
    @Test
    public void testSearchDate() {
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
        System.out.println("searchDate");
        String input = "12122012";
//        Set<Order> expResult = new HashSet<Order>();
//        Order object1 = new Order();
//        object1.setOrderNum(Double.parseDouble("1"));               //sets order number
//        object1.setCusName("Frank De'Beon");                        //sets customer name
//        object1.setState("FL");                                     //sets state    
//        object1.setTaxRate(new BigDecimal("0.10"));                 //sets tax rate
//        object1.setProduct("Glass");                                //sets product type        
//        object1.setArea(new BigDecimal("10"));                      //sets area
//        object1.setCostPerSqFt(new BigDecimal("1.00"));             //sets cost per sq ft
//        object1.setCostLaborPerSqFt(new BigDecimal("2.00"));        //sets labor cost per sq ft
//        object1.reCalculate();
//        try {
//            object1.setDate(sdf.parse("12122012"));                 //sets date confirm
//        } catch(ParseException ey) {}   
//        object1.setClean(true);                                     //sets clean=true;
//        expResult.add(object1);
//        Order object2 = new Order();
//        object2.setOrderNum(Double.parseDouble("2"));               //sets order number
//        object2.setCusName("Gershrif Halisun");                        //sets customer name
//        object2.setState("GA");                                     //sets state    
//        object2.setTaxRate(new BigDecimal("0.10"));                 //sets tax rate
//        object2.setProduct("Dreams");                                //sets product type        
//        object2.setArea(new BigDecimal("20"));                      //sets area
//        object2.setCostPerSqFt(new BigDecimal("3.00"));             //sets cost per sq ft
//        object2.setCostLaborPerSqFt(new BigDecimal("1.00"));        //sets labor cost per sq ft
//        object2.reCalculate();
//        try {
//            object2.setDate(sdf.parse("12122012"));                 //sets date confirm
//        } catch(ParseException ey) {}   
//        object2.setClean(true);
//        expResult.add(object2);
//        Order object3 = new Order();
//        object3.setOrderNum(Double.parseDouble("3"));               //sets order number
//        object3.setCusName("Terdy Sullihans");                        //sets customer name
//        object3.setState("NC");                                     //sets state    
//        object3.setTaxRate(new BigDecimal("0.10"));                 //sets tax rate
//        object3.setProduct("Stuff");                                //sets product type        
//        object3.setArea(new BigDecimal("50"));                      //sets area
//        object3.setCostPerSqFt(new BigDecimal("2.00"));             //sets cost per sq ft
//        object3.setCostLaborPerSqFt(new BigDecimal("6.00"));        //sets labor cost per sq ft
//        object3.reCalculate();
//        try {
//            object3.setDate(sdf.parse("12122012"));                 //sets date confirm
//        } catch(ParseException ey) {}   
//        object3.setClean(true);
//        expResult.add(object3);
        List<Order> result = dao.searchDate(input);  
        assertTrue(result.size()==3);
        assertTrue(result.get(0).getDate().equals("12122012"));
        assertTrue(result.get(1).getDate().equals("12122012"));
        assertTrue(result.get(2).getDate().equals("12122012"));
    }

    /**
     * Test of searchName method, of class FloorDAOImpl.
     */
    @Test
    public void testSearchName() {
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
        System.out.println("searchName");
        String input = "Franchiska De'Leon";
//        List<Order> expResult = new ArrayList<Order>();
//        Order object1 = new Order();
//        object1.setOrderNum(Double.parseDouble("1"));               //sets order number
//        object1.setCusName("Franchiska De'Leon");                        //sets customer name
//        object1.setState("FL");                                     //sets state    
//        object1.setTaxRate(new BigDecimal("0.10"));                 //sets tax rate
//        object1.setProduct("Glass");                                //sets product type        
//        object1.setArea(new BigDecimal("10"));                      //sets area
//        object1.setCostPerSqFt(new BigDecimal("1.00"));             //sets cost per sq ft
//        object1.setCostLaborPerSqFt(new BigDecimal("2.00"));        //sets labor cost per sq ft
//        object1.reCalculate();
//        try {
//            object1.setDate(sdf.parse("01061999"));                 //sets date confirm
//        } catch(ParseException ey) {}   
//        object1.setClean(true);
//        expResult.add(object1);
        List<Order> result = dao.searchName(input);
        assertTrue(result.size()==1);
        assertTrue(result.get(0).getCusName().equals("Franchiska De'Leon"));
    }

    /**
     * Test of searchProduct method, of class FloorDAOImpl.
     */
    @Test
    public void testSearchProduct() {
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
        System.out.println("searchProduct");
        String input = "Glass";
//        List<Order> expResult = new ArrayList<Order>();
//        Order object1 = new Order();
//        object1.setOrderNum(Double.parseDouble("1"));               //sets order number
//        object1.setCusName("Franchiska De'Leon");                        //sets customer name
//        object1.setState("FL");                                     //sets state    
//        object1.setTaxRate(new BigDecimal("0.10"));                 //sets tax rate
//        object1.setProduct("Glass");                                //sets product type        
//        object1.setArea(new BigDecimal("10"));                      //sets area
//        object1.setCostPerSqFt(new BigDecimal("1.00"));             //sets cost per sq ft
//        object1.setCostLaborPerSqFt(new BigDecimal("2.00"));        //sets labor cost per sq ft
//        object1.reCalculate();
//        try {
//            object1.setDate(sdf.parse("01061999"));                 //sets date confirm
//        } catch(ParseException ey) {}   
//        object1.setClean(true);
//        expResult.add(object1);
//        Order object2 = new Order();
//        object2.setOrderNum(Double.parseDouble("1"));               //sets order number
//        object2.setCusName("La-Dasha Fe'Leon");                        //sets customer name
//        object2.setState("FL");                                     //sets state    
//        object2.setTaxRate(new BigDecimal("0.10"));                 //sets tax rate
//        object2.setProduct("Glass");                                //sets product type        
//        object2.setArea(new BigDecimal("10"));                      //sets area
//        object2.setCostPerSqFt(new BigDecimal("1.00"));             //sets cost per sq ft
//        object2.setCostLaborPerSqFt(new BigDecimal("2.00"));        //sets labor cost per sq ft
//        object2.reCalculate();
//        try {
//            object1.setDate(sdf.parse("07172000"));                 //sets date confirm
//        } catch(ParseException ey) {}   
//        object1.setClean(true);
//        expResult.add(object2);
//        Order object3 = new Order();
//        object3.setOrderNum(Double.parseDouble("1"));               //sets order number
//        object3.setCusName("Frank De'Beon");                        //sets customer name
//        object3.setState("FL");                                     //sets state    
//        object3.setTaxRate(new BigDecimal("0.10"));                 //sets tax rate
//        object3.setProduct("Glass");                                //sets product type        
//        object3.setArea(new BigDecimal("10"));                      //sets area
//        object3.setCostPerSqFt(new BigDecimal("1.00"));             //sets cost per sq ft
//        object3.setCostLaborPerSqFt(new BigDecimal("2.00"));        //sets labor cost per sq ft
//        object3.reCalculate();
//        try {
//            object1.setDate(sdf.parse("12122012"));                 //sets date confirm
//        } catch(ParseException ey) {}   
//        object1.setClean(true);
//        expResult.add(object3);
        List<Order> result = dao.searchProduct(input);
        assertTrue(result.size()==3);
        assertTrue(result.get(0).getProduct().equals("Glass"));
        assertTrue(result.get(1).getProduct().equals("Glass"));
        assertTrue(result.get(2).getProduct().equals("Glass"));
    }

    /**
     * Test of searchState method, of class FloorDAOImpl.
     */
    @Test
    public void testSearchState() {
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
        System.out.println("searchState");
        String input = "FL";
//        List<Order> expResult = new ArrayList<Order>();
//        Order object1 = new Order();
//        object1.setOrderNum(Double.parseDouble("1"));               //sets order number
//        object1.setCusName("Franchiska De'Leon");                        //sets customer name
//        object1.setState("FL");                                     //sets state    
//        object1.setTaxRate(new BigDecimal("0.10"));                 //sets tax rate
//        object1.setProduct("Glass");                                //sets product type        
//        object1.setArea(new BigDecimal("10"));                      //sets area
//        object1.setCostPerSqFt(new BigDecimal("1.00"));             //sets cost per sq ft
//        object1.setCostLaborPerSqFt(new BigDecimal("2.00"));        //sets labor cost per sq ft
//        object1.reCalculate();
//        try {
//            object1.setDate(sdf.parse("01061999"));                 //sets date confirm
//        } catch(ParseException ey) {}   
//        object1.setClean(true);
//        expResult.add(object1);
//        Order object2 = new Order();
//        object2.setOrderNum(Double.parseDouble("1"));               //sets order number
//        object2.setCusName("La-Dasha Fe'Leon");                        //sets customer name
//        object2.setState("FL");                                     //sets state    
//        object2.setTaxRate(new BigDecimal("0.10"));                 //sets tax rate
//        object2.setProduct("Glass");                                //sets product type        
//        object2.setArea(new BigDecimal("10"));                      //sets area
//        object2.setCostPerSqFt(new BigDecimal("1.00"));             //sets cost per sq ft
//        object2.setCostLaborPerSqFt(new BigDecimal("2.00"));        //sets labor cost per sq ft
//        object2.reCalculate();
//        try {
//            object1.setDate(sdf.parse("07172000"));                 //sets date confirm
//        } catch(ParseException ey) {}   
//        object1.setClean(true);
//        expResult.add(object2);
//        Order object3 = new Order();
//        object3.setOrderNum(Double.parseDouble("1"));               //sets order number
//        object3.setCusName("Frank De'Beon");                        //sets customer name
//        object3.setState("FL");                                     //sets state    
//        object3.setTaxRate(new BigDecimal("0.10"));                 //sets tax rate
//        object3.setProduct("Glass");                                //sets product type        
//        object3.setArea(new BigDecimal("10"));                      //sets area
//        object3.setCostPerSqFt(new BigDecimal("1.00"));             //sets cost per sq ft
//        object3.setCostLaborPerSqFt(new BigDecimal("2.00"));        //sets labor cost per sq ft
//        object3.reCalculate();
//        try {
//            object1.setDate(sdf.parse("12122012"));                 //sets date confirm
//        } catch(ParseException ey) {}   
//        object1.setClean(true);
//        expResult.add(object3);
        List<Order> result = dao.searchState(input);
        assertTrue(result.size()==3);
        assertTrue(result.get(0).getState().equals("FL"));
        assertTrue(result.get(1).getState().equals("FL"));
        assertTrue(result.get(2).getState().equals("FL"));
    }
    
}
