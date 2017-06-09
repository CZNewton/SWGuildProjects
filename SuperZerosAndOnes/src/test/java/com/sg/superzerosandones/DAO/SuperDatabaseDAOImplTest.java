/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superzerosandones.DAO;

import com.sg.SuperZerosAndOnes.DAO.SuperDatabaseDAO;
import com.sg.SuperZerosAndOnes.DTO.Organization;
import com.sg.SuperZerosAndOnes.DTO.Sighting;
import com.sg.SuperZerosAndOnes.DTO.Super;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author apprentice
 */
public class SuperDatabaseDAOImplTest {
    
    SuperDatabaseDAO instance;
    
    public SuperDatabaseDAOImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        
        instance = ctx.getBean("SuperDao", SuperDatabaseDAO.class);
        
        try {
            List<Super> allSupers = instance.searchSuper(0, null);
            allSupers.stream().forEach(x->instance.removeSuper(x.getSuperID()));
        
            List<Organization> allOrg = instance.searchOrganization(0, null);
            allOrg.stream().forEach(x->instance.removeOrganization(x.getOrgID()));
        
            List<Sighting> allSight = instance.searchSighting(0, null);
            allSight.stream().forEach(x->instance.removeSighting(x.getSightingID()));
        } catch (FileNotFoundException ey) {}
        
        //setting up test Supers
        Super firstS = new Super();
        firstS.setIsHero(true);
        firstS.setName("Superman");
        firstS.setHeightMeters(2);
        firstS.setWeightkilos(100);
        firstS.setPower("Everything");
        firstS.setPowerLevel(9001);
        instance.newSuper(firstS);
        
        Super secondS = new Super();
        secondS.setIsHero(false);
        secondS.setName("Ultron");
        secondS.setHeightMeters(2);
        secondS.setWeightkilos(550);
        secondS.setPower("Robotic Hivemind");
        secondS.setPowerLevel(7654);
        instance.newSuper(secondS);
        
        Super thirdS = new Super();
        thirdS.setIsHero(true);
        thirdS.setName("Batman");
        thirdS.setHeightMeters(2);
        thirdS.setWeightkilos(95);
        thirdS.setPower("Being clever");
        thirdS.setPowerLevel(0123);
        instance.newSuper(thirdS);
        
        
        //setting up test orgs
        Organization firstO = new Organization();
        firstO.setName("Justice League");
        firstO.setDescription("Crystal Base in the middle of Metropolis. Hurts to look at on a sunny day.");
        firstO.setAlignment("Lawful Good");
        firstO.setMailingAddress("71654 Incorruptable Ave, 71654 Metropolis");
        firstO.setHqLocation("Metropolis Plaza");
        List<Super> members = new ArrayList<Super>();
        members.add(firstS);
        firstO.setMembers(members);
        instance.newOrganization(firstO);
        
        Organization secondO = new Organization();
        secondO.setName("Avengers");
        secondO.setDescription("");
        secondO.setAlignment("Neutral Good");
        secondO.setMailingAddress("1265 Hubris Lane, 16342 New York City");
        secondO.setHqLocation("Stark Tower");
        secondO.setMembers(members);
        instance.newOrganization(secondO);
        
        Organization thirdO = new Organization();
        thirdO.setName("League of Evil");
        thirdO.setDescription("Flying base, prefers swamps");
        thirdO.setAlignment("Lawful Evil");
        thirdO.setMailingAddress(null);
        thirdO.setHqLocation(null);
        instance.newOrganization(thirdO);
        
        
        
        //setting up test Sightings
        Sighting firstST = new Sighting();
        firstST.setAddress("Low Orbit");
        firstST.setLatitudeDMS(new BigDecimal("4123.51"));
        firstST.setLatitudeDir('N');
        firstST.setLongitudeDMS(new BigDecimal("6245.98"));
        firstST.setLongitudeDir('E');
        firstST.setDateSeen(java.sql.Date.valueOf("2012-07-12"));
        firstST.setTimeSeen(java.sql.Time.valueOf("16:54:32"));
        instance.newSighting(firstST);
        
        Sighting secondST = new Sighting();
        secondST.setAddress("1208 Funkytown Ave, Gotham 33337");
        secondST.setLatitudeDMS(new BigDecimal("1234.21"));
        secondST.setLatitudeDir('N');
        secondST.setLongitudeDMS(new BigDecimal("3514.23"));
        secondST.setLongitudeDir('E');
        secondST.setDateSeen(java.sql.Date.valueOf("1999-10-15"));
        secondST.setTimeSeen(java.sql.Time.valueOf("12:32:01"));
        secondST.setSupers(members);
        instance.newSighting(secondST);
        
        Sighting thirdST = new Sighting();
        thirdST.setAddress("123 Neighbor's Lawn");
        thirdST.setLatitudeDMS(new BigDecimal("1123.45"));
        thirdST.setLatitudeDir('N');
        thirdST.setLongitudeDMS(new BigDecimal("6543.12"));
        thirdST.setLongitudeDir('E');
        thirdST.setDateSeen(java.sql.Date.valueOf("1992-01-02"));
        thirdST.setTimeSeen(java.sql.Time.valueOf("4:00:21"));
        instance.newSighting(thirdST);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of SuperJdbctemplate method, of class SuperDatabaseDAOImpl.
     */
    @Test
    public void testsetJdbctemplate() {    }

    /**
     * Test of getSuper method, of class SuperDatabaseDAOImpl.
     */
    @Test
    public void testGetSuper() {    }

    /**
     * Test of getOrganization method, of class SuperDatabaseDAOImpl.
     */
    @Test
    public void testGetOrganization() {    }

    /**
     * Test of getSighting method, of class SuperDatabaseDAOImpl.
     */
    @Test
    public void testGetSighting() {    }

    /**
     * Test of searchOrganization method, of class SuperDatabaseDAOImpl.
     */
    @Test
    public void testSearchOrganization() throws Exception {
        System.out.println("searchOrganization");
        int[] searchParam = {0, 1, 2, 3};
        String[] value = {"0", "Justice League", "Neutral Good", "0"};
        List<Organization> result1 = instance.searchOrganization(searchParam[0], value[0]);
        List<Organization> result2 = instance.searchOrganization(searchParam[1], value[1]);
        List<Organization> result3 = instance.searchOrganization(searchParam[2], value[2]);
        assertEquals("Justice League", result1.get(0).getName());
        assertEquals("Justice League", result2.get(0).getName());
        assertEquals("Avengers", result3.get(0).getName());
    }

    /**
     * Test of searchSighting method, of class SuperDatabaseDAOImpl.
     */
    @Test
    public void testSearchSighting() throws Exception {
        System.out.println("searchSighting");
        int[] searchParam = {0, 1, 2, 3};
        String[] value = {"0", "1992-01-02", "1208 Funkytown Ave, Gotham 33337", "0"};
        List<Sighting> result4 = instance.searchSighting(searchParam[2], value[2]);
//        assertEquals("1208 Funkytown Ave, Gotham 33337", result4.get(0).getAddress());
    }

    /**
     * Test of searchSuper method, of class SuperDatabaseDAOImpl.
     */
    @Test
    public void testSearchSuper() throws Exception {
        System.out.println("searchSuper");
        int[] searchParam = {0, 1, 2, 3};
        String[] value = {"0", "Superman", "9000", "1000"};
        List<Super> result1 = instance.searchSuper(searchParam[0], value[0]);
        List<Super> result2 = instance.searchSuper(searchParam[1], value[1]);
        List<Super> result3 = instance.searchSuper(searchParam[2], value[2]);
        List<Super> result4 = instance.searchSuper(searchParam[3], value[3]);
        assertEquals("Superman", result1.get(0).getName());
        assertEquals("Superman", result2.get(0).getName());
        assertEquals("Superman", result3.get(0).getName());
        assertEquals("Batman", result4.get(0).getName());
    }

    /**
     * Test of removeOrganization method, of class SuperDatabaseDAOImpl.
     */
    @Test
    public void testRemoveOrganization() {    }

    /**
     * Test of removeSighting method, of class SuperDatabaseDAOImpl.
     */
    @Test
    public void testRemoveSighting() {    }

    /**
     * Test of removeSuper method, of class SuperDatabaseDAOImpl.
     */
    @Test
    public void testRemoveSuper() {    }

    /**
     * Test of updateOrganization method, of class SuperDatabaseDAOImpl.
     */
    @Test
    public void testUpdateOrganization() {    }

    /**
     * Test of updateSighting method, of class SuperDatabaseDAOImpl.
     */
    @Test
    public void testUpdateSighting() {    }

    /**
     * Test of updateSuper method, of class SuperDatabaseDAOImpl.
     */
    @Test
    public void testUpdateSuper() {    }

    /**
     * Test of newOrganization method, of class SuperDatabaseDAOImpl.
     */
    @Test
    public void testNewOrganization() {    }

    /**
     * Test of newSighting method, of class SuperDatabaseDAOImpl.
     */
    @Test
    public void testNewSighting() {    }

    /**
     * Test of newSuper method, of class SuperDatabaseDAOImpl.
     */
    @Test
    public void testNewSuper() {    }
    
}
