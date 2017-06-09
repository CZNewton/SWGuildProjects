/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.service;

import com.sg.classroster.dao.ClassRosterAuditDAO;
import com.sg.classroster.dao.ClassRosterAuditDAOFileImpl;
import com.sg.classroster.dao.ClassRosterDAO;
import com.sg.classroster.dao.ClassRosterDAOimplen;
import com.sg.classroster.dto.Student;
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
public class ClassRosterServiceImplTest {
    
    private ClassRosterDAO dao = new ClassRosterDAOimplen();
    private ClassRosterAuditDAO auditDao = new ClassRosterAuditDAOFileImpl();
    
    public ClassRosterServiceImplTest() {
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
     * Test of addStudent method, of class ClassRosterServiceImpl.
     */
    @Test
    public void testAddStudent() throws Exception {
        System.out.println("addStudent");
        Student student = null;
        ClassRosterServiceLayer instance = new ClassRosterServiceImpl(dao, auditDao);
        instance.addStudent(student);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllStudents method, of class ClassRosterServiceImpl.
     */
    @Test
    public void testGetAllStudents() throws Exception {
        System.out.println("getAllStudents");
        ClassRosterServiceImpl instance = new ClassRosterServiceImpl(dao, auditDao);
        List<Student> expResult = null;
        List<Student> result = instance.getAllStudents();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStudent method, of class ClassRosterServiceImpl.
     */
    @Test
    public void testGetStudent() throws Exception {
        System.out.println("getStudent");
        String studentId = "";
        ClassRosterServiceImpl instance = new ClassRosterServiceImpl(dao, auditDao);
        Student expResult = null;
        Student result = instance.getStudent(studentId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeStudent method, of class ClassRosterServiceImpl.
     */
    @Test
    public void testRemoveStudent() throws Exception {
        System.out.println("removeStudent");
        String studentId = "";
        ClassRosterServiceImpl instance = new ClassRosterServiceImpl(dao, auditDao);
        Student expResult = null;
        Student result = instance.removeStudent(studentId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
