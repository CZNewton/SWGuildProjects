/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.SuperZerosAndOnes.DTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class Super {
    /*
    SuperID INT NOT NULL auto_increment,
    Hero BOOL NOT NULL,
    SuperName VARCHAR(20) NULL,
    Height INT NULL,
    WeightKilos INT NULL,
    WeightPounds INT NULL,
    Power TINYTEXT NULL,
    PowerLevel INT NOT NULL DEFAULT 00000,
    PRIMARY KEY(SuperID));
    */
    
    private int superID;
    private boolean isHero;
    private String name;
    private int heightMeters;
    private double weightkilos;
    private String power;
    private int powerLevel;
    private List<Organization> affiliations;
    private List<Sighting> sightings;
    
    public Super() {
        this.affiliations = new ArrayList<Organization>();
        this.sightings = new ArrayList<Sighting>();
    }

    /**
     * @return the superID
     */
    public int getSuperID() {
        return superID;
    }

    /**
     * @param superID the superID to set
     */
    public void setSuperID(int superID) {
        this.superID = superID;
    }

    /**
     * @return the isHero
     */
    public boolean isHero() {
        return isHero;
    }

    /**
     * @param isHero the isHero to set
     */
    public void setIsHero(boolean isHero) {
        this.isHero = isHero;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the heightMeters
     */
    public int getHeightMeters() {
        return heightMeters;
    }

    /**
     * @param heightMeters the heightMeters to set
     */
    public void setHeightMeters(int heightMeters) {
        this.heightMeters = heightMeters;
    }

    /**
     * @return the weightkilos
     */
    public double getWeightkilos() {
        return weightkilos;
    }

    /**
     * @param weightkilos the weightkilos to set
     */
    public void setWeightkilos(double weightkilos) {
        this.weightkilos = weightkilos;
    }

    /**
     * @return the weightpounds
     */
    public double getWeightpounds() {
        return weightkilos/0.453592;
    }

    /**
     * @param weightpounds the weightpounds to set
     */
    public void setWeightpounds(double weightpounds) {
        this.weightkilos = weightpounds*0.453592;
    }

    /**
     * @return the power
     */
    public String getPower() {
        return power;
    }

    /**
     * @param power the power to set
     */
    public void setPower(String power) {
        this.power = power;
    }

    /**
     * @return the powerLevel
     */
    public int getPowerLevel() {
        return powerLevel;
    }

    /**
     * @param powerLevel the powerLevel to set
     */
    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }

    /**
     * @return the affiliations
     */
    public List<Organization> getAffiliations() {
        return affiliations;
    }

    /**
     * @param affiliations the affiliations to set
     */
    public void setAffiliations(List<Organization> affiliations) {
        this.affiliations = affiliations;
    }

    /**
     * @return the sightings
     */
    public List<Sighting> getSightings() {
        return sightings;
    }

    /**
     * @param sightings the sightings to set
     */
    public void setSightings(List<Sighting> sightings) {
        this.sightings = sightings;
    }
    
}
