/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.FloorMastery.view;

import com.sg.FloorMastery.DTO.Options;
import com.sg.FloorMastery.DTO.Order;
import com.sg.FloorMastery.Exceptions.InvalidInputException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class FloorViewImpl implements FloorView{
    
    private final Scanner uInput;
    private final SimpleDateFormat sdf;
    
    public FloorViewImpl() {
        Scanner uRead = new Scanner(System.in);
        this.uInput = uRead;
        this.sdf = new SimpleDateFormat("MMddyyyy");
    }

    @Override
    public int displayMenu() {
        String temp = "";
        boolean uCheck=true;
        System.out.println("=================================");
        System.out.println("=    Please choose an action    =");
        System.out.println("=-------------------------------=");
        System.out.println("=1. Display All Orders          =");
        System.out.println("=2. Add an Order                =");
        System.out.println("=3. Edit an Order               =");
        System.out.println("=4. Remove an Order             =");
        System.out.println("=5. Save current work           =");
        System.out.println("=6. exit                        =");
        System.out.println("=================================");
        do{
            temp = uInput.nextLine();
            if (temp.matches("1|2|3|4|5|6")==false) {
                unknownCommand();
                uCheck=false;
            } else {
                uCheck=true;
            }
        }while(uCheck==false);
        
        int end = Integer.parseInt(temp);
        
        return end;
    }

    @Override
    public void displayAll(LinkedHashMap<String, List<Order>> readAll) {
        
        Set<String> arrangement = readAll.keySet();
        ArrayList<String> blank = new ArrayList<String>(arrangement);
        
        for (int j=0; j<blank.size();j++) {
            String cd = blank.get(j);
            
            System.out.println("Entries for: " + cd);
            System.out.println("======================");
            
            for (int i=0; i<readAll.get(cd).size() ;i++) {
                System.out.print("" + readAll.get(cd).get(i).getOrderNum());
                System.out.print(": " + readAll.get(cd).get(i).getCusName());
                System.out.print(", " + readAll.get(cd).get(i).getProduct());
                System.out.print(", " + readAll.get(cd).get(i).getArea() + "sqft.");
                System.out.print(", $" + readAll.get(cd).get(i).getTotal() + "\n");
            }
            
            System.out.println("======================");
            
            if (j==0) {
                System.out.println("Enter '>' for older entries.");
            } else if (j<arrangement.size()) {
                System.out.println("Enter '>' for earlier entries.");
                System.out.println("Enter '<' for more recent entries.");
            } else if (j==(arrangement.size()-1)) {
                System.out.println("Enter '<' for more recent entries.");
            }
            System.out.println("Otherwise hit any other button to exit");
            
            String uTemp = uInput.nextLine();
            
            if (uTemp.matches("<|>")==false) {
                break;
            } else if (uTemp.matches("<")) {
                if (j<=0) {
                    System.out.println("There are no more recent entries.");
                    j = -1;
                } else {
                    j-=2;
                }
            }
            
            if (uTemp.matches(">")&&j==(blank.size()-1)) {
                System.out.println("There are no more older entries.");
                j--;
            }
            
        }
        
        System.out.println("Exiting display");
        
    }

    @Override
    public Order displaySearch(List<Order> results, String param) throws InvalidInputException {
        //takes in and displays search results to allow for choosing
        //the appropriate reference
        
        int searchChoice = 0;
        
        System.out.println("Results of search for : " + param + "......");
        for (int i=0;i<results.size();i++) {
            System.out.print("" + (i+1) + ": ");
            System.out.print("Order: " + results.get(i).getOrderNum() + ", ");
            System.out.print("Customer : " + results.get(i).getCusName() + ", ");
            System.out.print("Product : " + results.get(i).getProduct() + ", ");
            System.out.print("Area : " + results.get(i).getArea() + ", ");
            System.out.print("State : " + results.get(i).getState() + ", \n");
        }
        
        System.out.println("\n=======================================================");
        System.out.println("Which result are you interested in?");
        
        do {
            searchChoice = uInput.nextInt();
        } while(searchChoice<=0||searchChoice>results.size());
        
        return results.get(searchChoice-1);
    }

    @Override
    public String askSearch(int param, Options choices) {
        String end = "null";
        int uTempint = 0;
        boolean check=true;
        
        switch(param) {
            case 1: System.out.println("What Date would you like to look for?");
                //take and validate user input (Date)
                do{ 
                    end = uInput.nextLine();
                    try {
                        check=true;
                        Date testDate = sdf.parse(end);
                } catch(ParseException ey) {check=false;} 
                } while(check=false);
                
                break;
                
            case 2: System.out.println("What Name would you like to look for? (Please enter more than 3 characters)");
                do {
                    check=true;
                    end = uInput.nextLine();
                    if(end.length()<4) {
                        check=false;
                    }
                } while(check==false);
                break;
                
            case 3: System.out.println("What Product Type would you like to look for?");
                uTempint=0;
                for (int i = 0; i<choices.getProduct().size();i++) {
                    System.out.println("" + i + ": " + choices.getProduct().get(i).getName());
                }
                do {
                    check=true;
                    uTempint=uInput.nextInt();
                    if(uTempint<0||uTempint>choices.getProduct().size()) {
                        check=false;
                    }
                } while(check==false);
                
                end = choices.getProduct().get(uTempint-1).getName();
                
                break;
                
            case 4: System.out.println("What State would like to look for?");
                uTempint=0;
                for (int i = 0; i<choices.getStates().size();i++) {
                    System.out.println("" + i + ": " + choices.getStates().get(i).getName());
                }
                do {
                    check=true;
                    uTempint=uInput.nextInt();
                    if(uTempint<0||uTempint>choices.getStates().size()) {
                        check=false;
                    }
                } while(check==false);
                
                end = choices.getStates().get(uTempint-1).getName();
                
                break;
                
            default: unknownCommand();
                break;
        }
        
        //takes in parameter of type int
        //1. Date - 2. Customer Name - 3. Product Type - 4. State
        //gives switch to ask the specific of the paramter type
        
        
        
        return end;
    }

    @Override
    public Order addOrder(Options choices) {
        Order newOrder = new Order();
        String uTemp;
        boolean parseCheck=true;
        List<String> compare = new ArrayList<String>();
        do {
            uTemp = userInput("Is this order for today?");
        } while(uTemp.matches("YES|Y|NO|N")==false);
        if (uTemp.matches("YES|Y")) {
            Date today = new Date();
            newOrder.setDate(today);
        } else if (uTemp.matches("NO|N")) {
            System.out.println("What date is this Order for? (MMDDYYYY)");
            parseCheck = true;
            do {
                try {
                    newOrder.setDate(uInput.nextLine());
                } catch (ParseException ey) {
                    parseCheck=false;
                    System.out.println("Improper format, pelase try again.");
                }  
            } while(parseCheck==false);
        }
        
        System.out.println("Name of customer?");
        newOrder.setCusName(uInput.nextLine());
        
        System.out.println("Please select the state for the order");
        for(int i=0;i<choices.getStates().size();i++) {
            String name = choices.getStates().get(i).getName();
            System.out.println(name);
            compare.add(name.toUpperCase());
        }
        do {
            uTemp=userInput("");
        } while(!compare.contains(uTemp));
        newOrder.setState(uTemp);
        
        compare.clear();
        
        System.out.println("Please select the avaliable product");
        for(int i=0;i<choices.getProduct().size();i++) {
            String name = choices.getProduct().get(i).getName();
            System.out.println(name);
            compare.add(name.toUpperCase());
        }
        do {
            uTemp=userInput("");
        } while(!compare.contains(uTemp));
        newOrder.setProduct(uTemp);
        
        System.out.println("How many square feet will this order cover?");
        do {
            //try {
                newOrder.setArea(new BigDecimal(uInput.nextLine()));
            //} catch (ParseException ey) {
            //    parseCheck=false;
            //}
        } while(parseCheck==false);
        
        return newOrder;
    }

    @Override
    public void addResult(boolean check) {
        if (check==true) {
            System.out.println("Order succesfully added!");
        }
        else if (check==false) {
            System.out.println("Order placement unsuccesful, please review your input.");
        }
    }

    @Override
    public void unknownCommand() {
        //called in an improper input case on the menu switch result
        System.out.println("\n==============\nUnknown command, try again\n==============\n");
    }

    @Override
    public String editProcess(Order select) {
        
        String move = "na";             //variable to hold date change should it be required. Otherwise defaults to "na"
                                        //with that value being checked for in a 'no-move' case
        int tempI;
        String tempS;
        boolean again=false;
        
        do {
            tempS="YES";
            System.out.println("1. Order Number: " + select.getOrderNum());
            System.out.println("2. Customer name: " + select.getCusName());
            System.out.println("3. State: " + select.getState());
            System.out.println("4. Product: " + select.getProduct());
            System.out.println("5. Area: " + select.getArea());
            System.out.println("6. Cost per Square Foot: " + select.getCostPerSqFt());
            System.out.println("--. Total Material Cost: " + select.getCostMaterial());
            System.out.println("7. Labor cost per Square Foot : " + select.getCostLaborperSqFt());
            System.out.println("--. Total labor Cost: " + select.getCostLabor());
            System.out.println("8. Tax Rate: " + select.getTaxRate());
            System.out.println("--. Total Tax: " + select.getTaxTotal());
            System.out.println("9. Date Ordered: " + select.getDate());

            do {
                System.out.println("=========================================================");                                        
                System.out.println("What value of this order would you like to alter?");
                tempI = uInput.nextInt();
                if(tempI == 1 || (tempI>=6 && tempI<=11)) {
                    tempS = userInput("This values is auto-generated from another value, are you sure?");
                }
            } while(tempS.matches("YES|Y|NO|N")==false);

            switch(tempI) {
                case 1: System.out.println("Modify Order Number:");
                System.out.print("Change: " + select.getOrderNum() + " -->to--> ");
                select.setOrderNum(uInput.nextDouble());
                    break;
                case 2: System.out.println("Modify Customer Name:");
                System.out.print("Change: " + select.getCusName() + " -->to--> ");
                select.setCusName(uInput.next());
                    break;
                case 3: System.out.println("Modify State:");
                System.out.print("Change: " + select.getState() + " -->to--> ");
                select.setState(uInput.next());
                    break;
                case 4: System.out.println("Modify Product:");
                System.out.print("Change: " + select.getProduct() + " -->to--> ");
                select.setProduct(uInput.next());
                    break;
                case 5: System.out.println("Modify Area:");
                System.out.print("Change: " + select.getArea() + " -->to--> ");
                select.setArea(new BigDecimal(uInput.next()));
                    break;
                case 6: System.out.println("Modify Cost per Square Foot:");
                System.out.print("Change: " + select.getCostPerSqFt() + " -->to--> ");
                select.setCostPerSqFt(new BigDecimal(uInput.next()));
                    break;
                case 7: System.out.println("Modify Labor Cost per Square Foot:");
                System.out.print("Change: " + select.getCostLaborperSqFt() + " -->to--> ");
                select.setCostLaborPerSqFt(new BigDecimal(uInput.next()));
                    break;
                case 8: System.out.println("Modify Tax Rate:");
                System.out.print("Change: " + select.getTaxRate() + " -->to--> ");
                select.setTaxRate(new BigDecimal(uInput.next()));
                    break;
                case 9: System.out.println("Modify Date:");
                    System.out.print("Change: " + sdf.format(select.getDate()) + " -->to--> ");
                    boolean parseCheck = true;
                    do {
                        try {
                            move=uInput.next();
                            select.setDate(move);
                        } catch (ParseException ey) {
                            parseCheck=false;
                        }  
                    } while(parseCheck==false);
                    break;
                default: break;
            }
            String stringAgain = userInput("Modify another value?");
            if (stringAgain.matches("Y|YES|N|NO")) {
                again=true;
            } else {
                again=false;
            }
        } while(again==true);
        
        select.reCalculate();
        
        return move;
    }

    @Override
    public int askSearchParam() {
        int end = -1;
        String uTemp;
        
        System.out.println("=== Search by....=========");
        System.out.println("=== 1. Date ==============");
        System.out.println("=== 2. Customer Name =====");
        System.out.println("=== 3. Product Type ======");
        System.out.println("=== 4. State =============");
        
        do {
            uTemp = uInput.nextLine();
        } while(uTemp.matches("1|2|3|4")==false);
        
        end = Integer.parseInt(uTemp);
        
        //ask what parameter to search with, return int with key of:
        //1. Date
        //2. Customer Name
        //3. Product Type
        //4. State
        
        return end;
    }

    @Override
    public void searchFailure() {
        System.out.println("Unsuccesful search, restarting prompts.");
    }

    @Override
    public boolean removeConfirm(Order toBeRemoved) {
        boolean confirm=true;
        String uTemp;
        
        do {
            uTemp = userInput("Are you sure you'd like to remove this order?"
                    + "\n" + toBeRemoved.getDate()
                    + ": " + toBeRemoved.getOrderNum()
                    + ", " + toBeRemoved.getCusName()
                    + ", " + toBeRemoved.getProduct()
                    + ", " + toBeRemoved.getArea() + "sqft"
                    + ", $" + toBeRemoved.getTotal());
        } while(!uTemp.matches("YES|Y|NO|N"));
        
        if (uTemp.matches("NO|N")) {
            confirm=false;
        }
        
        return confirm;
    }

    @Override
    public void saveBanner() {
        System.out.println("\n=====================\nWork Saved\n=====================\n");
    }
    
    private String userInput(String prompt) {
        String response;
        
        System.out.println(prompt);
        response = uInput.nextLine();
        response = response.toUpperCase();
        
        return response;
    }
    
}
