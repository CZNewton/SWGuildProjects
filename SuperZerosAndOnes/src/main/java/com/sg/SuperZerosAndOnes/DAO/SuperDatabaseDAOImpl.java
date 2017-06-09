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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class SuperDatabaseDAOImpl implements SuperDatabaseDAO {
    
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    
    //Super anchor table edit
    public static final String newSuper = "insert into Supers (Hero, SuperName,"
            + " Height, WeightKilos, Power, PowerLevel) values (?,?,?,?,?,?)";
    public static final String removeSuper = "delete from Supers where SuperID = ?";
    public static final String getAllSuper = "select * from Supers";
    public static final String updateSuper = "update Supers set Hero = ?, SuperName = ?,"
            + " Height = ?, WeightKilos = ?, Power = ?, PowerLevel = ? where SuperID = ?";
    
    //Sighting anchor table edit
    public static final String newLoc = "insert into Location (Address, LatitudeDMS, LatitudeDir,"
            + " LongitudeDMS, LongitudeDir) values (?,?,?,?,?)";
    public static final String newSight = "insert into Sighting (LocationID, SightDate, "
            + " SightTime) values (?,?,?)";
    public static final String removeSight = "delete from Sighting where SightingID = ?";
    public static final String getAllSight = "select * from Sighting join Location using (LocationID)";
    public static final String updateLoc = "update Location set Address = ?, LatitudeDMS = ?, LatitudeDir = ?, LongitudeDMS = ?, LongitudeDir = ? where LocationID = ?";
    public static final String updateSight = "update Sighting set LocationID = ?, SightDate = ?, SightTime = ? where SightingID = ?";  
    
    //organization anchor table edit
    public static final String newOrg = "insert into Organization (OrgName, Description,"
            + " Alignment, Mail, HQLocation) values (?,?,?,?,?)";
    public static final String removeOrg = "delete from Organization where OrgID = ?";
    public static final String getAllOrg = "select * from Organization";
    public static final String updateOrg = "update Organization set OrgName = ?, Description = ?,"
            + " Alignment = ?, Mail = ?, HQLocation = ? where OrgID = ?";
    
    //bridge table selects
    public static final String superbysight = "select s.Hero, s.SuperName, s.Height, s.WeightKilos,"
            + " s.Power, s.PowerLevel from Supers s join Super_x_Sighting ss"
            + " on SightingID where s.SuperID = ss.SuperID and ss.SightingID = ?";
    public static final String superbyorg = "select s.Hero, s.SuperName, s.Height, s.WeightKilos,"
            + " s.Power, s.PowerLevel from Supers s join Super_x_Organization so"
            + " on OrgID where s.SuperID = so.SuperID and so.OrgID = ?";
    public static final String orgbysuper = "select o.OrgName, o.Description, o.Alignment, o.Mail,"
            + " o.HQLocation from Organization o join Super_x_Organization so using (SuperID) where"
            + " so.OrgID = ?";
    public static final String sightbysuper = "select sl.Address, sl.LatitudeDMS, sl.latitudeDir,"
            + " sl.LongitudeDMS, sl.LongitudeDir, st.SightDate, st.SightTime from Sighting st"
            + " join Location sl using (LocationID) join Super_x_Sighting sst using (SightingID)"
            + " where sst.SuperID = ?";
    
    //bridge table edits
    public static final String removeSuper_Org = "delete from Super_x_Organization where OrgID = ?";
    public static final String removeOrg_Super = "delete from Super_x_Organization where SuperID = ?"; 
    public static final String removeSuper_Sight = "delete from Super_x_Sighting where SightingID = ?";
    public static final String removeSight_Super = "delete from Super_x_Sighting where SuperID = ?";
    public static final String addSuper_Org = "insert into Super_x_Organization (SuperID, OrgID) values (?,?)"; 
    public static final String addSuper_Sight = "insert into Super_x_Sighting (SuperID, SightingID) values (?,?)";
    
    //search statements
    public static final String searchSuperbyName = "select * from Supers where SuperName = ?";
    public static final String searchSuperbyPowerLevelAbove = "select * from Supers where PowerLevel>?";
    public static final String searchSuperbyPowerLevelBelow = "select * from Supers where PowerLevel<?";
    public static final String searchOrgbyName = "select * from Organization where OrgName = ?";
    public static final String searchOrgbyAlign = "select * from Organization where Alignment = ?";
    public static final String searchSightbyAddress = "select * from Sighting st"
            + " join Location sl using (LocationID) where sl.Address = ?";
    public static final String searchSightbyDate = "select sl.Address, sl.LatitudeDMS, sl.LatitudeDir, "
            + " sl.LongitudeDMS, sl.LongitudeDir, st.SightDate, st.SightTime from Sighting st"
            + " join Location sl using (LocationID) where st.SightDate = ?";
    
    //when joining with mirrored names, use 'using' NOT on. and 'using' requires parenthses
    
    
    
    //Getters
    @Override
    public Super getSuper(int ID) {
        return jdbcTemplate.query("select * from Supers where SuperID = ?", new SuperMapper(), ID).get(0);
    }
    
    @Override
    public Organization getOrganization(int ID) {
        return jdbcTemplate.query("select * from Organization where OrgID = ?", new OrgMapper(), ID).get(0);
    }
    
    @Override
    public Sighting getSighting(int ID) {
        return jdbcTemplate.query("select * from Sighting join Location using (LocationID) where SightingID = ?", new SightingMapper(), ID).get(0);
    }
    
    
    //Search methods
    @Override
    public List<Organization> searchOrganization(int searchParam, String value) throws
            FileNotFoundException{
        //create switch statement that takes int
        
        //switch statement selects same select action, but different static strings presets
        //so as to search by differet constraints. Default will set to throwing "notfound" exception
        
        //Search by...
        switch (searchParam) {
            //...all
            case 0: return jdbcTemplate.query(getAllOrg, new OrgMapper());
            //...Organization name
            case 1: return jdbcTemplate.query(searchOrgbyName, new OrgMapper(), value);
            //...Organization alignment
            case 2: return jdbcTemplate.query(searchOrgbyAlign, new OrgMapper(), value);
            //...ID of member
            case 3: return jdbcTemplate.query(orgbysuper, new OrgMapper(), Integer.parseInt(value));
            //on the off-chance an invalid number in searchparam is given
            default: throw new FileNotFoundException();
        }
    }
    
    @Override
    public List<Sighting> searchSighting(int searchParam, String value) throws
            FileNotFoundException{
        //NOTE, MAY NEED FORMATTER FOR DATE AND TIME SEARCH PARAMTERS DEPENDING ON SQL INTERACTION
        //Search by...
        
        switch (searchParam) {
            //...all
            case 0: return jdbcTemplate.query(getAllSight, new SightingMapper());
            //...date seen
            case 1: try{
                    return jdbcTemplate.query(searchSightbyDate, new SightingMapper(), value);
                    } catch(IllegalArgumentException ey) {
                        return jdbcTemplate.query(getAllSight, new SightingMapper());
                    }
                 //add date
            //...address
            case 2: return jdbcTemplate.query(searchSightbyAddress, new SightingMapper(), value);
            //...super
            case 3: return jdbcTemplate.query(sightbysuper, new SightingMapper(), Integer.parseInt(value));
            //waterproofing
            default: throw new FileNotFoundException();
        }
    }
    
    @Override
    public List<Super> searchSuper(int searchParam, String value) throws
            FileNotFoundException{
        //Search by...
        switch(searchParam) {
            //...all
            case 0: return jdbcTemplate.query(getAllSuper, new SuperMapper());
            //...name
            case 1: return jdbcTemplate.query(searchSuperbyName, new SuperMapper(), value);
            //...PL above x
            case 2: return jdbcTemplate.query(searchSuperbyPowerLevelAbove, new SuperMapper(), Integer.parseInt(value));
            //...PL below x
            case 3: return jdbcTemplate.query(searchSuperbyPowerLevelBelow, new SuperMapper(), Integer.parseInt(value));
            default: throw new FileNotFoundException();
        }
    }
    
    
    //Removal methods
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public void removeOrganization(int orgID) {
        jdbcTemplate.update(removeSuper_Org, orgID);
        jdbcTemplate.update(removeOrg, orgID);
    }
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public void removeSighting(int sightID) {
        jdbcTemplate.update(removeSuper_Sight, sightID);
        jdbcTemplate.update(removeSight, sightID);
    }
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public void removeSuper(int supID) {
        jdbcTemplate.update(removeSight_Super, supID);
        jdbcTemplate.update(removeOrg_Super, supID);
        jdbcTemplate.update(removeSuper, supID);
    }
    
    
    //Update methods
    @Override
    public void updateOrganization(Organization org) {
        jdbcTemplate.update(newOrg,
                org.getName(),
                org.getDescription(),
                org.getAlignment(),
                org.getMailingAddress(),
                org.getHqLocation());
        
        jdbcTemplate.update(removeSuper_Org, org.getOrgID());
        
        insertSuper_Org(org);
    }
    
    @Override
    public void updateSighting(Sighting sight) {
        jdbcTemplate.update(newSight,
                sight.getAddress(),
                sight.getLatitudeDMS(),
                "" + sight.getLatitudeDir(),
                sight.getLongitudeDMS(),
                "" + sight.getLongitudeDir(),
                sight.getDateSeen(),
                sight.getTimeSeen());
        
        jdbcTemplate.update(removeSuper_Sight, sight.getSightingID());
        
        insertSuper_Sight(sight);
    }
    
    @Override
    public void updateSuper(Super sup) {
        jdbcTemplate.update(newSuper,
                sup.isHero(),
                sup.getName(),
                sup.getHeightMeters(),
                sup.getWeightkilos(),
                sup.getPower(),
                sup.getPowerLevel());
        
        jdbcTemplate.update(removeOrg_Super, sup.getSuperID());
        
        insertOrg_Super(sup);
    }
    
    //Insert methods
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public int newOrganization(Organization org) {
        jdbcTemplate.update(newOrg,
                org.getName(),
                org.getDescription(),
                org.getAlignment(),
                org.getMailingAddress(),
                org.getHqLocation());
        
        org.setOrgID(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));

        if(!org.getMembers().isEmpty()) {
            insertSuper_Org(org);
        }
        
        return org.getOrgID();
    }
    
    private void insertSuper_Org(Organization org) {
        List<Super> SupersinOrg = org.getMembers();
        
        //format for instance strings is (action, superID, orgID)
        SupersinOrg.stream().forEach(x -> jdbcTemplate.update(addSuper_Org, x.getSuperID(), org.getOrgID()));
    }
    
    @Override
    public int newSighting(Sighting sight) {
        jdbcTemplate.update(newLoc,
                sight.getAddress(),
                sight.getLatitudeDMS(),
                "" + sight.getLatitudeDir(),
                sight.getLongitudeDMS(),
                "" + sight.getLongitudeDir());
        
        sight.setLocationID(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
        
        jdbcTemplate.update(newSight,
                sight.getLocationID(),
                sight.getDateSeen(),
                sight.getTimeSeen());
        
        sight.setSightingID(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
        
        return sight.getSightingID();
    }
    
    private void insertSuper_Sight(Sighting sight) {
        List<Super> supersInSight = sight.getSupers();
        
        supersInSight.stream().forEach(x -> jdbcTemplate.update(addSuper_Sight, x.getSuperID(), sight.getSightingID()));
    }
    
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public int newSuper(Super sup) {
        jdbcTemplate.update(newSuper,
                sup.isHero(),
                sup.getName(),
                sup.getHeightMeters(),
                sup.getWeightkilos(),
                sup.getPower(),
                sup.getPowerLevel());
        
        sup.setSuperID(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
        
        insertOrg_Super(sup);
        
        return sup.getSuperID();
    }
    
    private void insertOrg_Super(Super sup) {
        List<Organization> orgsInSuper = sup.getAffiliations();
        int SuperID = sup.getSuperID();
        
        if(orgsInSuper!=null) {
            orgsInSuper.stream().forEach(x -> jdbcTemplate.update(addSuper_Sight, x.getOrgID(), sup.getSuperID()));
        }
    }
    
    //Mappers
    public static final class SuperMapper implements RowMapper<Super> {
        
        @Override
        public Super mapRow(ResultSet rs, int row) throws SQLException {
            Super s = new Super();
            //setters, all of the setters
            //remember to set the two collections via queries
            s.setSuperID(rs.getInt("SuperID"));
            s.setIsHero(rs.getBoolean("Hero"));
            s.setName(rs.getString("SuperName"));
            s.setHeightMeters(rs.getInt("Height"));
            s.setWeightkilos(rs.getDouble("WeightKilos"));
            s.setPower(rs.getString("Power"));
            s.setPowerLevel(rs.getInt("PowerLevel"));
            return s;
        }
        
    }
    
    public static final class SightingMapper implements RowMapper<Sighting> {
        
        @Override
        public Sighting mapRow(ResultSet rs, int row) throws SQLException {
            Sighting x = new Sighting();
            //setters, all of the setters
            x.setSightingID(rs.getInt("SightingID"));
            x.setLocationID(rs.getInt("LocationID"));
            x.setAddress(rs.getString("Address"));
            x.setLatitudeDMS(rs.getBigDecimal("LatitudeDMS"));
            x.setLatitudeDir((rs.getString("LatitudeDir")).charAt(0));
            x.setLongitudeDMS(rs.getBigDecimal("LongitudeDMS"));
            x.setLongitudeDir((rs.getString("LongitudeDir")).charAt(0));
            x.setTimeSeen(rs.getTime("SightTime"));
            x.setDateSeen(rs.getDate("SightDate"));
            return x;
            //MAKE SURE QUERY IS A JOIN TABLE BETWEEN LOCATION AND SIGHTING
        }
        
    }
    
    public static final class OrgMapper implements RowMapper<Organization> {
        
        @Override
        public Organization mapRow(ResultSet rs, int row) throws SQLException {
            Organization o = new Organization();
            //setters, all of the setters
            o.setOrgID(rs.getInt("OrgID"));
            o.setName(rs.getString("OrgName"));
            o.setDescription(rs.getString("Description"));
            o.setAlignment(rs.getString("Alignment"));
            o.setMailingAddress(rs.getString("Mail"));
            o.setHqLocation(rs.getString("HQLocation"));
            return o;
        }
        
    }
}
