/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.SuperZerosAndOnes.DTO;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class Sighting {
    /*
    SightingID INT NOT NULL auto_increment,
    Address VARCHAR(50) NULL,
    LatitudeDMS DECIMAL(8,2) NOT NULL,
    LatitudeDir CHAR NOT NULL,
    LongitudeDMS DECIMAL(8,2) NOT NULL,
    LongitudeDir CHAR NOT NULL,
    SightDate DATE NOT NULL,
    SightTime TIME NOT NULL,
	PRIMARY KEY(SightingID));
    */
    private int sightingID;
    private int locationID;
    private String address;
    private BigDecimal latitudeDMS;
    private char latitudeDir;
    private BigDecimal longitudeDMS;
    private char longitudeDir;
    private Date dateSeen;
    private Time timeSeen;
    private List<Super> supers;
    
    public Sighting() {
        this.supers = new ArrayList<Super>();
        this.timeSeen = null;
    }

    /**
     * @return the sightingID
     */
    public int getSightingID() {
        return sightingID;
    }

    /**
     * @param sightingID the sightingID to set
     */
    public void setSightingID(int sightingID) {
        this.sightingID = sightingID;
    }
    
    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }
    
    public int getLocationID() {
        return locationID;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the latitudeDMS
     */
    public BigDecimal getLatitudeDMS() {
        return latitudeDMS;
    }

    /**
     * @param latitudeDMS the latitudeDMS to set
     */
    public void setLatitudeDMS(BigDecimal latitudeDMS) {
        this.latitudeDMS = latitudeDMS;
    }

    /**
     * @return the longitudeDMS
     */
    public BigDecimal getLongitudeDMS() {
        return longitudeDMS;
    }

    /**
     * @param longitudeDMS the longitudeDMS to set
     */
    public void setLongitudeDMS(BigDecimal longitudeDMS) {
        this.longitudeDMS = longitudeDMS;
    }

    /**
     * @return the latitudeDir
     */
    public char getLatitudeDir() {
        return latitudeDir;
    }

    /**
     * @param latitudeDir the latitudeDir to set
     */
    public void setLatitudeDir(char latitudeDir) {
        this.latitudeDir = latitudeDir;
    }

    /**
     * @return the longitudeDir
     */
    public char getLongitudeDir() {
        return longitudeDir;
    }

    /**
     * @param longitudeDir the longitudeDir to set
     */
    public void setLongitudeDir(char longitudeDir) {
        this.longitudeDir = longitudeDir;
    }

    /**
     * @return the dateSeen
     */
    public Date getDateSeen() {
        return dateSeen;
    }

    /**
     * @param dateSeen the dateSeen to set
     */
    public void setDateSeen(Date dateSeen) {
        this.dateSeen = dateSeen;
    }

    /**
     * @return the timeSeen
     */
    public Time getTimeSeen() {
        return timeSeen;
    }

    /**
     * @param timeSeen the timeSeen to set
     */
    public void setTimeSeen(Time timeSeen) {
        this.timeSeen = timeSeen;
    }

    /**
     * @return the supers
     */
    public List<Super> getSupers() {
        return supers;
    }

    /**
     * @param supers the supers to set
     */
    public void setSupers(List<Super> supers) {
        this.supers = supers;
    }
}
