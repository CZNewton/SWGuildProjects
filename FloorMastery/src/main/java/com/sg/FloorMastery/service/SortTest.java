/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.FloorMastery.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class SortTest  {
    public void Test() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MMDDYYYY");
        List<Date> test = new ArrayList<Date>();
        
        String d1 = "01021999";
        Date date1 = sdf.parse(d1);
        String d2 = "03051981";
        Date date2 = sdf.parse(d2);
        String d3 = "05122003";
        Date date3 = sdf.parse(d3);
        String d4 = "07102008";
        Date date4 = sdf.parse(d4);
        String d5 = "12252010";
        Date date5 = sdf.parse(d5);
        
        test.add(date1);
        test.add(date2);
        test.add(date3);
        test.add(date4);
        test.add(date5);
        
        Collections.sort(test, (Date d6, Date d7) -> d6.compareTo(d7));
        
        for(int i = 0; i<test.size(); i++) {
            System.out.println(test.get(i));
        }
        
    }
}
