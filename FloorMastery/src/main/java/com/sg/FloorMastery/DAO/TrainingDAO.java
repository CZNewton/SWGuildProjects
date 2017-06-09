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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class TrainingDAO implements FloorDAO {
    
    private Map<String, List<Order>> raw;
    private Options set;
    private String ORDERDIR = "Resources/TestData/TestOrders";
    private String DATA = "Resources/TestData";
    private SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");
    private String DELIMITER = ",";
    
    public TrainingDAO (String uORDERDIR, String uDATA) {
        this.ORDERDIR = uORDERDIR;
        this.DATA = uDATA;
    }
    
    public TrainingDAO() {
        
    }
    
    private void testSuccess(String modifier){
        System.out.println(modifier + ": SUCESS");
    }
    @Override
    public void loadOrders() throws FileNotFoundException, IOException, ParseException {
        File f = new File(ORDERDIR);
        File[] OrderFiles = f.listFiles((File dir, String name) -> name.startsWith("Order_"));  //check for proper file name
        
        for (int i=0;i<OrderFiles.length;i++) {
            Scanner read = new Scanner(new BufferedReader(new FileReader(OrderFiles[i])));
            List<Order> temp = new ArrayList<Order>();
            
            //skips first example line
            read.nextLine();
            
            //assemble current list<Order>
            while(read.hasNextLine()) {
                Order blank = new Order();
                String begString = read.nextLine();
                String[] conString = begString.split(DELIMITER);
                blank.setOrderNum(Double.parseDouble(conString[0]));        //sets order number
                blank.setCusName(conString[1]);                             //sets customer name
                blank.setState(conString[2]);                               //sets state  
                blank.setProduct(conString[4]);                             //sets product type        
                blank.setArea(new BigDecimal(conString[5]));                //sets area
                blank.calculate(new BigDecimal(conString[3]), new BigDecimal(conString[6]), new BigDecimal(conString[7]));
                blank.setDate(sdf.parse(conString[12]));                    //sets date confirm
                blank.setClean(true);                                       //sets clean=true
                temp.add(blank);
            }
            String fileDate = OrderFiles[i].getName().substring(6);
            raw.put(fileDate, temp);
            read.close();
        }
        
        //will implement when confirmed to be safe
        //writeRec();
    }

    @Override
    public void loadOptions() throws FileNotFoundException, IOException {
        //create Options object conatining two lists with stated information within data/projects
        
        Scanner readProd = new Scanner(new BufferedReader(new FileReader(DATA + "/Products.txt")));
        List<Product> tempProd = new ArrayList<Product>();
        
        //skips first example line
        readProd.nextLine();
        
        while(readProd.hasNextLine()) {
            Product blank = new Product();
            String begString = readProd.nextLine();
            String[] conString = begString.split(DELIMITER);
            blank.setName(conString[0]);
            blank.setPrice(new BigDecimal(conString[1]));
            blank.setLabor(new BigDecimal(conString[2]));
            tempProd.add(blank);
        }
        readProd.close();
        
        Scanner readTax = new Scanner(new BufferedReader(new FileReader(DATA + "/Taxes.txt")));
        List<State> tempState = new ArrayList<State>();
        
        //skips first example line
        readTax.nextLine();
        
        while(readTax.hasNextLine()) {
            State blank = new State();
            String begString = readTax.nextLine();
            String[] conString = begString.split(DELIMITER);
            blank.setName(conString[0]);
            blank.setTaxRate(new BigDecimal(conString[1]));
            tempState.add(blank);
        }
        
        set = new Options(tempState, tempProd);
    }

    @Override
    public void writeEnd() {
        testSuccess("Method writeEnd started");
    }

    @Override
    public Options getOptions() {
        return set;
    }

    @Override
    public Map<String, List<Order>> getAllOrders() {
        return raw;
    }

    @Override
    public List<Order> searchDate(String input) {
        List<Order> endList = raw.get(input);
        return endList;
    }

    @Override
    public List<Order> searchName(String input) {
        List<Order> result = new ArrayList<Order>();

        Set<String> dateSet = raw.keySet();
        List<String> dateList = new ArrayList<String>(dateSet);

        //this could probably be a lambda
        for (int i = 0; i < raw.size(); i++) {
            for (int j = 0; j < raw.get(dateList.get(i)).size(); j++) {
                Order currentOrder = raw.get(dateList.get(i)).get(j);
                //search raw >> list of date dateList[i] >> Order [j] >> customer name of Order [j]
                if (currentOrder.getCusName().contains(input)) {
                    result.add(currentOrder);
                }
            }
        }

        return result;
    }

    @Override
    public List<Order> searchProduct(String input) {
        List<Order> result = new ArrayList<Order>();

        Set<String> dateSet = raw.keySet();
        List<String> dateList = new ArrayList<String>(dateSet);

        //this could probably be a lambda
        for (int i = 0; i < raw.size(); i++) {
            for (int j = 0; j < raw.get(dateList.get(i)).size(); j++) {
                Order currentOrder = raw.get(dateList.get(i)).get(j);
                //search raw >> list of date dateList[i] >> Order [j] >> product of Order [j]
                if (currentOrder.getProduct().equalsIgnoreCase(input)) {
                    result.add(currentOrder);
                }
            }
        }

        return result;
    }

    @Override
    public List<Order> searchState(String input) {
        List<Order> result = new ArrayList<Order>();

        Set<String> dateSet = raw.keySet();
        List<String> dateList = new ArrayList<String>(dateSet);

        //this could probably be a lambda
        for (int i = 0; i < raw.size(); i++) {
            for (int j = 0; j < raw.get(dateList.get(i)).size(); j++) {
                Order currentOrder = raw.get(dateList.get(i)).get(j);
                //search raw >> list of date dateList[i] >> Order [j] >> state of Order [j]
                if (currentOrder.getState().equalsIgnoreCase(input)) {
                    result.add(currentOrder);
                }
            }
        }

        return result;
    }

    @Override
    public void newFile(String date) {
        testSuccess("Method newFile started");
    }
    
}
