/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class SortTest  {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");
        List<Date> test = new ArrayList<Date>();
        
        String d1 = "01021999";
        Date date1 = sdf.parse(d1);
        String d2 = "03051999";
        Date date2 = sdf.parse(d2);
        String d3 = "05121999";
        Date date3 = sdf.parse(d3);
        String d4 = "07101999";
        Date date4 = sdf.parse(d4);
        String d5 = "12251999";
        Date date5 = sdf.parse(d5);
        
        test.add(date1);
        test.add(date2);
        test.add(date3);
        test.add(date4);
        test.add(date5);
        
        Collections.sort(test, (Date d6, Date d7) -> d6.compareTo(d7));
        
        for(int i = 0; i<test.size(); i++) {
            System.out.println(sdf.format(test.get(i)));
        }
        
    }
}
