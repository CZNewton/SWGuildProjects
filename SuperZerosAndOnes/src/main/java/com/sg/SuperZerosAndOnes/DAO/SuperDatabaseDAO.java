/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.SuperZerosAndOnes.DAO;

import com.sg.SuperZerosAndOnes.DTO.Organization;
import com.sg.SuperZerosAndOnes.DTO.Sighting;
import com.sg.SuperZerosAndOnes.DTO.Super;
import java.io.FileNotFoundException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author apprentice
 */
public interface SuperDatabaseDAO {
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate);
    public Super getSuper(int ID);
    public Organization getOrganization(int ID);
    public Sighting getSighting(int ID);
    public List<Organization> searchOrganization(int searchParam, String value) throws FileNotFoundException;
    public List<Sighting> searchSighting(int searchParam, String value) throws FileNotFoundException;
    public List<Super> searchSuper(int searchParam, String value) throws FileNotFoundException;
    public void removeOrganization(int OrgID);
    public void removeSighting(int SightingID);
    public void removeSuper(int SuperID);
    public void updateOrganization(Organization org);
    public void updateSighting(Sighting sight);
    public void updateSuper(Super sup);
    public int newOrganization(Organization org);
    public int newSighting(Sighting sight);
    public int newSuper(Super sup);
}
