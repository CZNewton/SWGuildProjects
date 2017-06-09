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
public class Organization {
    /*
    OrgName VARCHAR(50) NULL,
    Description TINYTEXT NULL,
    Alignment VARCHAR(15) NOT NULL,
    Mail VARCHAR(50) NULL,
    HQLocation TINYTEXT NULL,
    PRIMARY KEY(OrgID));
    */
    private int orgID;
    private String name;
    private String description;
    private String alignment;
    private String mailingAddress;
    private String hqLocation;
    private List<Super> members;
    
    public Organization() {
        this.members = new ArrayList<Super>();
    }

    /**
     * @return the orgID
     */
    public int getOrgID() {
        return orgID;
    }

    /**
     * @param orgID the orgID to set
     */
    public void setOrgID(int orgID) {
        this.orgID = orgID;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the alignment
     */
    public String getAlignment() {
        return alignment;
    }

    /**
     * @param alignment the alignment to set
     */
    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    /**
     * @return the malingAddress
     */
    public String getMailingAddress() {
        return mailingAddress;
    }

    /**
     * @param malingAddress the malingAddress to set
     */
    public void setMailingAddress(String malingAddress) {
        this.mailingAddress = malingAddress;
    }

    /**
     * @return the hqLocation
     */
    public String getHqLocation() {
        return hqLocation;
    }

    /**
     * @param hqLocation the hqLocation to set
     */
    public void setHqLocation(String hqLocation) {
        this.hqLocation = hqLocation;
    }

    /**
     * @return the members
     */
    public List<Super> getMembers() {
        return members;
    }

    /**
     * @param members the members to set
     */
    public void setMembers(List<Super> members) {
        this.members = members;
    }
}
