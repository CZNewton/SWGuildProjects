/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.SuperZerosAndOnes.service;

import com.sg.SuperZerosAndOnes.DAO.SuperDatabaseDAO;
import com.sg.SuperZerosAndOnes.DAO.SuperDatabaseDAOImpl;
import com.sg.SuperZerosAndOnes.DTO.Organization;
import com.sg.SuperZerosAndOnes.DTO.Sighting;
import com.sg.SuperZerosAndOnes.DTO.Super;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author apprentice
 */
public class SuperServiceImpl {
    
    
    SuperDatabaseDAO Dao;
    
    @Inject
    public SuperServiceImpl(SuperDatabaseDAO uDao) {
        this.Dao = uDao;
    }
    
    public Super getSuper(int ID) {
        return Dao.getSuper(ID);
    }
    
    public Sighting getSighting(int ID) {
        return Dao.getSighting(ID);
    }
    
    public Organization getOrg(int ID) {
        return Dao.getOrganization(ID);
    }
    
    public int newOrg(String name, String description, String alignment, String mailingAddress, String HQlocation) {
        Organization current = new Organization();
        current.setName(name);
        current.setDescription(description);
        current.setAlignment(alignment);
        if(mailingAddress!=null) {
            current.setMailingAddress(mailingAddress);
        } else {
            current.setMailingAddress(null);
        }
        if(HQlocation!=null) {
            current.setHqLocation(HQlocation);
        } else {
            current.setHqLocation(null);
        }
        return Dao.newOrganization(current);
    }
    
    public int newSup(String isHero, String name, String height, double weight, String power, String PL) {
        Super current = new Super();
        if(isHero.equalsIgnoreCase("villain")) {
            current.setIsHero(false);
        } else {
            current.setIsHero(true);
        }
        current.setName(name);
        current.setHeightMeters(Integer.parseInt(height));
        current.setWeightkilos(weight);
        current.setPower(power);
        current.setPowerLevel(Integer.parseInt(PL));
        
        Dao.newSuper(current);
                
        return current.getSuperID();
    }
    
    public int newSight(String address, String latDMS, String latDir, String longDMS, String longDir, String date, String time) {
        Sighting current = new Sighting();
        current.setAddress(address);
        current.setLatitudeDMS(new BigDecimal(latDMS));
        current.setLatitudeDir(latDir.charAt(0));
        current.setLongitudeDMS(new BigDecimal(longDMS));
        current.setLongitudeDir(longDir.charAt(0));
        current.setDateSeen(java.sql.Date.valueOf(date));
//      current.setTimeSeen(java.sql.Time.valueOf(time));
        return Dao.newSighting(current);
    }
    
    public List<Sighting> searchSight(String searchParam, String searchValue) throws
            FileNotFoundException{
        int searchRange = -1;
        if (searchParam.equalsIgnoreCase("all")) {
            searchRange = 0;
        } else if (searchParam.equalsIgnoreCase("date")) {
            searchRange = 1;
        } else if (searchParam.equalsIgnoreCase("address")) {
            searchRange = 2;
        } else if (searchParam.equalsIgnoreCase("super")) {
            searchRange = 3;
        }
        

        return Dao.searchSighting(searchRange, searchValue);
    }
    
    public List<Organization> searchOrg(String searchParam, String searchValue) throws
            FileNotFoundException{
        int searchRange = -1;
        if (searchParam.equalsIgnoreCase("all")) {
            searchRange = 0;
        } else if (searchParam.equalsIgnoreCase("name")) {
            searchRange = 1;
        } else if (searchParam.equalsIgnoreCase("alignment")) {
            searchRange = 2;
        } else if (searchParam.equalsIgnoreCase("super")) {
            searchRange = 3;
        }
        

        return Dao.searchOrganization(searchRange, searchValue);
    }
    
    public List<Super> searchSuper(String searchParam, String searchValue) throws
            FileNotFoundException{
        int searchRange = -1;
        if (searchParam.equalsIgnoreCase("all")) {
            searchRange = 0;
        } else if (searchParam.equalsIgnoreCase("name")) {
            searchRange = 1;
        } else if (searchParam.equalsIgnoreCase("PLup")) {
            searchRange = 2;
        } else if (searchParam.equalsIgnoreCase("PLdown")) {
            searchRange = 3;
        }
        

        return Dao.searchSuper(searchRange, searchValue);
    }
    
    public void removeOrg(int orgID) {
        Dao.removeOrganization(orgID);
    }
    public void removeSuper(int SupID) {
        Dao.removeSuper(SupID);
    }
    public void removeSighting(int sightID) {
        Dao.removeSighting(sightID);
    }
}
