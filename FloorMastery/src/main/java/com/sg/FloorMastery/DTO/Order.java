/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.FloorMastery.DTO;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author apprentice
 */
public class Order {
    private double orderNum;
    private String cusName,
            state,
            product;
    private BigDecimal costPerSqFt,
            costLabor,
            costMaterial,
            costLaborperSqFt,
            taxRate,
            taxTotal,
            total,
            area;
    private boolean clean=false;
    private Date date;
    
    @Override
    public boolean equals(Object o) {
        if(o==null) {
            return false;
        }
        if(!(o instanceof Order)) {
            return false;
        }
        Order blah = (Order)o;
        Field[] compare1 = blah.getClass().getFields();
        Field[] compare2 = this.getClass().getFields();
        List<Boolean> compareResults= new ArrayList<>();
        for (int i= 0;i<compare1.length;i++) {
            compareResults.add(compare1[i].equals(compare2[i]));
        }
        return compareResults.stream()
                .anyMatch(x -> x==false);
    }
    
    public void setClean(boolean override) {
        this.clean = override;
    }
    
    public void validate() {
        boolean check = false;
        //private calculation of values to assure a lack of null inputs

        check = Stream.of(this.getClass().getFields())
                .anyMatch(f -> {
            try {
                return f.get(this)==null;
            } catch (IllegalArgumentException ex) {
                return true;
            } catch (IllegalAccessException ex) {
                return true;
            }
        });
        
        
        if(check==false) {
            this.setClean(true);
        }
    }
    
    public double getOrderNum() {
        return orderNum;
    }
    
    public void setOrderNum(double uorderNum) {
        this.orderNum = uorderNum;
    }

    /**
     * @return the cusName
     */
    public String getCusName() {
        return cusName;
    }

    /**
     * @param cusName the cusName to set
     */
    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the product
     */
    public String getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(String product) {
        this.product = product;
    }

    /**
     * @return the date
     */
    public String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");
        return sdf.format(date);
    }

    /**
     * @param date the date to set
     */
    //setDate String constructor is here for validation,
    //if a string does not adhere to the simpledateformat
    //it will throw a parse exception and be reprompted
    public void setDate(String uDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");
        this.date = sdf.parse(uDate);
    }
    
    public void setDate(Date uDate) {
        this.date = uDate;
    }

    /**
     * @return the costPerSqFt
     */
    public BigDecimal getCostPerSqFt() {
        return costPerSqFt;
    }

    /**
     * @param costPerSqFt the costPerSqFt to set
     */
    public void setCostPerSqFt(BigDecimal costPerSqFt) {
        this.costPerSqFt = costPerSqFt;
    }

    /**
     * @return the costLabor
     */
    public BigDecimal getCostLabor() {
        return costLabor;
    }

    /**
     * @return the costMaterial
     */
    public BigDecimal getCostMaterial() {
        return costMaterial;
    }

    /**
     * @return the costLaborperSqFt
     */
    public BigDecimal getCostLaborperSqFt() {
        return costLaborperSqFt;
    }

    /**
     * @param costLaborperSqFt the costLaborperSqFt to set
     */
    public void setCostLaborPerSqFt(BigDecimal costLaborperSqFt) {
        this.costLaborperSqFt = costLaborperSqFt;
    }

    /**
     * @return the taxRate
     */
    public BigDecimal getTaxRate() {
        return taxRate;
    }

    /**
     * @param taxRate the taxRate to set
     */
    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    /**
     * @return the taxTotal
     */
    public BigDecimal getTaxTotal() {
        return taxTotal;
    }

    /**
     * @return the total
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * @return the area
     */
    public BigDecimal getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(BigDecimal area) {
        this.area = area;
    }

    /**
     * @return the clean
     */
    public boolean isClean() {
        return clean;
    }
    
    public void calculate(BigDecimal Tax, BigDecimal ProductCostR, BigDecimal LaborCostR){
        this.costLaborperSqFt=LaborCostR;
        this.costPerSqFt=ProductCostR;
        this.taxRate=Tax;
        
        this.costLabor=area.multiply(LaborCostR);
        
        this.costMaterial=area.multiply(ProductCostR);
        
        BigDecimal tempB =costLabor.add(costMaterial);
        
        this.taxTotal=tempB.multiply(Tax);
        
        this.total=tempB.add(taxTotal);
        validate();
    }
    
    public void reCalculate(){

        this.costLabor=area.multiply(this.costLaborperSqFt);
        
        this.costMaterial=area.multiply(this.costPerSqFt);
        
        BigDecimal tempB =costLabor.add(costMaterial);
        
        this.taxTotal=tempB.multiply(this.taxRate);
        
        this.total=tempB.add(taxTotal);
        validate();
    }
    
}
