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
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class FloorDAOImpl implements FloorDAO {

    private Map<String, List<Order>> raw;
    private Options set;
    private String ORDERDIR = "Resources/Data/Orders";
    private String RECFILE = "Resources/Recovery/Orders";
    private String DATA = "Resources/Data";
    private SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");
    private String DELIMITER = ",";

    public FloorDAOImpl(String uORDERDIR, String uDATA) {
        this.raw = new HashMap<String, List<Order>>();
        this.ORDERDIR = uORDERDIR;
        this.DATA = uDATA;
    }

    public FloorDAOImpl() {
        this.raw = new HashMap<String, List<Order>>();
    }

    @Override
    public void loadOrders() throws
            FileNotFoundException,
            IOException,
            ParseException {
        File f = new File(ORDERDIR);    //this point to your Order DIRECTORY NOT AN INDIVIDUAL FILE
        //You need multiple files, so you store them in a File Object array, this allows a basic for loop to iterate through via index number
        File[] OrderFiles = f.listFiles((File dir, String name) -> name.startsWith("Order_"));  //check for proper file name
        
        //e.g. OrderFile[0] will rturn the file of the FIRST file in the directory File f
        
        
        for (int i = 0; i < OrderFiles.length; i++) {
            Scanner read = new Scanner(new BufferedReader(new FileReader(OrderFiles[i])));      //making a new filereader every iteration, this allows you to draw from a different file each time
            List<Order> temp = new ArrayList<Order>();

            //first example line
            read.nextLine();

            //assemble current list<Order>
            while (read.hasNextLine()) {
                Order blank = new Order();                                  //making a new order object every iteration to make sure it's blank!
                String begString = read.nextLine();                         //making a new string every iteration is an easy way to wipe the variable
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
            
            
            String fileDate = OrderFiles[i].getName().substring(6);         //this takes the file name (e.g.Order_12345678) and the substring takes the 7th character onwards as the string
            raw.put(fileDate, temp);                                        //puts list from current file iteration into map with date as key
            read.close();                                                   //always close reader when you're done!
        }

        //will implement when confirmed to be safe
        //writeRec();        
    }

    private void writeRec() throws IOException {

        File OrderRecovery = new File(ORDERDIR);
        new File(RECFILE).delete();
        OrderRecovery.renameTo(new File(RECFILE));

    }

    @Override
    public void loadOptions() throws
            FileNotFoundException,
            IOException {
        //create Options object conatining two lists with stated information within data/projects

        Scanner readProd = new Scanner(new BufferedReader(new FileReader(DATA + "/Products.txt")));
        List<Product> tempProd = new ArrayList<Product>();

        //skips first example line
        readProd.nextLine();

        while (readProd.hasNextLine()) {
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

        while (readTax.hasNextLine()) {
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
        Set<String> dateSet = raw.keySet();                             //.keySet returns a SET of keys from a map. Sets are not easy to interact with, so we need to translate it to a List
        List<String> dateList = new ArrayList<String>(dateSet);         //This is where we translate it to a List
        
        dateList.stream()
                .forEach(x -> {         //this lambda is just an enhanced for loop: (Order x : myBigHashmap.getKey(iterationNumber))
                    try {
                    PrintWriter write = new PrintWriter(new FileWriter("Resources/Data/Orders/Order_" + x));
                    List<Order> currentWrite = raw.get(x);
                    for (int i = 0; i<currentWrite.size(); i++) {
                            if(i==0) {
                                write.println("Order Number,Customer Name,State,Tax Rate,Material,Area,costPerSqFt,LaborPerSqFt,MaterialTotalCost,LaborTotalCost,TaxTotal,Total,Date");
                            }
                            Order y = currentWrite.get(i);
                                if (y.isClean()) {
                                    String writeOutput = "" + y.getOrderNum() + DELIMITER
                                            + y.getCusName() + DELIMITER
                                            + y.getState() + DELIMITER
                                            + y.getTaxRate() + DELIMITER
                                            + y.getProduct() + DELIMITER
                                            + y.getArea() + DELIMITER
                                            + y.getCostPerSqFt() + DELIMITER
                                            + y.getCostLaborperSqFt() + DELIMITER
                                            + y.getCostMaterial() + DELIMITER
                                            + y.getCostLabor() + DELIMITER
                                            + y.getTaxTotal() + DELIMITER
                                            + y.getTotal() + DELIMITER
                                            + y.getDate();
                                    
                                    write.println(writeOutput);
                                }
                                
                                
                            }
                        write.flush();
                        write.close();
                    } catch(IOException ey) {}
                });
    }

    @Override
    public Options getOptions() {
        return set;
    }

    public Map<String, List<Order>> getAllOrders() {
        return raw;
    }

    @Override
    public void newFile(String date) {
        new File(ORDERDIR + "Order_" + date);
        List<Order> tempEmpty = new ArrayList<Order>();
        raw.put(date, tempEmpty);
    }

    @Override
    public List<Order> searchDate(String input) {
        //receive String of searched date, return List<Order> of said date
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

}
