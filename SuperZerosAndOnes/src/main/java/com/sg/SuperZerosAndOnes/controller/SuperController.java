/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.SuperZerosAndOnes.controller;

import com.sg.SuperZerosAndOnes.DTO.Organization;
import com.sg.SuperZerosAndOnes.DTO.Sighting;
import com.sg.SuperZerosAndOnes.DTO.Super;
import com.sg.SuperZerosAndOnes.service.SuperServiceImpl;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class SuperController {
    
    @Inject
    private SuperServiceImpl service;
    
    @RequestMapping(value={"/", "About"})
    public String initial(Model model) {
        
        //initial calls
        List<Sighting> latestList = new ArrayList<Sighting>();
        try {
            latestList = service.searchSight("all", null);
        } catch (FileNotFoundException ey) {}
        model.addAttribute("latestList", latestList);

        return "About";
    }
    
    @RequestMapping(value="/NavOrg")
    public String NavigateNewOrg() {
        return "NewOrg";
    }
    
    @RequestMapping(value="/NavSup")
    public String NavigateNewSup() {
        return "NewSuper";
    }
    
    @RequestMapping(value="/NavSight")
    public String NavigateNewSight(Model model) {
        List<Super> optionsSuper = new ArrayList<Super>();
        List<Sighting> latestList = new ArrayList<Sighting>();
        try{
            latestList = service.searchSight("all", null);
            optionsSuper = service.searchSuper("all", null);
        } catch (FileNotFoundException ey) {}
        model.addAttribute("latestList", latestList);
        model.addAttribute("optionsSuper", optionsSuper);
        return "NewSight";
    }
    
    
    @RequestMapping(value="/newOrg", method=RequestMethod.GET)
    public String newOrg(Model model, HttpServletRequest request) {
        int valid = service.newOrg(request.getParameter("name"),
                request.getParameter("Descrip"),
                "" + request.getParameter("AlignPre") + request.getParameter("AlignAff"),
                request.getParameter("Address"),
                request.getParameter("HQ"));
        model.addAttribute("NewOrgVal", valid);
        System.out.println(valid);
        return "About";
    }
    
    @RequestMapping(value="/newSight", method=RequestMethod.GET)
    public String newSight(Model model, HttpServletRequest request) {
        int valid = service.newSight(request.getParameter("Address"),
                request.getParameter("LatitudeDMS"),
                request.getParameter("LatitudeDir"),
                request.getParameter("LongitudeDMS"),
                request.getParameter("LongitudeDir"),
                request.getParameter("sightDate"),
                request.getParameter("sightTime"));
        System.out.println(valid);
        return "About";
                }
    
    @RequestMapping(value="/newSuper", method=RequestMethod.GET)
    public String newSup(Model model, HttpServletRequest request) {
        List<Organization> optionsOrg = new ArrayList<Organization>();
        try{
        optionsOrg = service.searchOrg("all", null);
        } catch (FileNotFoundException ey) {}
        model.addAttribute("optionsOrg", optionsOrg);

        double weight = Double.parseDouble(request.getParameter("weight"));
        if (request.getParameter("weightUnit").equalsIgnoreCase("pounds")) {
            weight*=0.453592;
        }
        int valid = service.newSup(request.getParameter("isHero"),
                request.getParameter("name"),
                request.getParameter("height"),
                weight,
                request.getParameter("power"),
                request.getParameter("PL"));
        System.out.println(valid);
        return "About";
    }
    
    @RequestMapping(value="/SearchDir", method=RequestMethod.GET)
    public String searchDirect(Model model, HttpServletRequest request) {
        String val = request.getParameter("searchParam");
        String direct = "" + val + "List";
        List<Sighting> latestList = new ArrayList<Sighting>();
        try{
            latestList = service.searchSight("all", null);
        } catch (FileNotFoundException ey) {}
        model.addAttribute("latestList", latestList);
        return direct;
    }
    
    @RequestMapping(value="/SearchOrg", method=RequestMethod.GET)
    public String searchOrgList(Model model, HttpServletRequest request) {
        List<Sighting> latestList = new ArrayList<Sighting>();
        try{
            latestList = service.searchSight("all", null);
        } catch (FileNotFoundException ey) {}
        model.addAttribute("latestList", latestList);
        try {
            model.addAttribute("OrgList", service.searchOrg(request.getParameter("searchParam"), request.getParameter("searchValue")));
        } catch (FileNotFoundException ex) {
            return "Error";
        }
        
        return "OrganizationsList";
    }
    
    @RequestMapping(value="/SearchSuper", method=RequestMethod.GET)
    public String searchSuperList(Model model, HttpServletRequest request) {
        List<Sighting> latestList = new ArrayList<Sighting>();
        try{
            latestList = service.searchSight("all", null);
        } catch (FileNotFoundException ey) {}
        model.addAttribute("latestList", latestList);
        try {
            model.addAttribute("SuperList", service.searchSuper(request.getParameter("searchParam"), request.getParameter("searchValue")));
        } catch (FileNotFoundException ex) {
            return "Error";
        }
        
        return "SuperList";
    }
    
    @RequestMapping(value="/SearchSight", method=RequestMethod.GET)
    public String searchSightList(Model model, HttpServletRequest request) {
        List<Sighting> latestList = new ArrayList<Sighting>();
        try{
            latestList = service.searchSight("all", null);
        } catch (FileNotFoundException ey) {}
        model.addAttribute("latestList", latestList);
        try {
            model.addAttribute("SightList", service.searchSight(request.getParameter("searchParam"), request.getParameter("searchValue")));
        } catch (FileNotFoundException ex) {
            return "Error";
        }
        
        return "SightingsList";
    } 
    
    @RequestMapping(value="/editOrg", method=RequestMethod.GET)
    public String editOrg(Model model, HttpServletRequest request) {
        Organization target = new Organization();
        target = service.getOrg(Integer.parseInt(request.getParameter("ID")));
        
        model.addAttribute("editTargetOrg", target);
        service.removeOrg(Integer.parseInt(request.getParameter("ID")));
        
        return "OrgEdit";
    }
    
    @RequestMapping(value="/removeOrg", method=RequestMethod.POST)
    public String removeOrg(Model model, HttpServletRequest request) {
        service.removeOrg(Integer.parseInt(request.getParameter("ID")));
        
        List<Sighting> latestList = new ArrayList<Sighting>();
        try{
            latestList = service.searchSight("all", null);
        } catch (FileNotFoundException ey) {}
        
        return "OrganizationsList";
    }
    
    @RequestMapping(value="/editSuper", method=RequestMethod.GET)
    public String editSuper(Model model, HttpServletRequest request) {
        Super target = new Super();
        target = service.getSuper(Integer.parseInt(request.getParameter("ID")));

        
        model.addAttribute("editTargetSuper", target);
        service.removeSuper(Integer.parseInt(request.getParameter("ID")));
        
        return "SuperEdit";
    }
    
    @RequestMapping(value="/removeSuper", method=RequestMethod.POST)
    public String removeSuper(Model model, HttpServletRequest request) {
        service.removeSuper(Integer.parseInt(request.getParameter("ID")));
        
        return "SuperList";
    }
    
    @RequestMapping(value="/editSight", method=RequestMethod.GET)
    public String editSight(Model model, HttpServletRequest request) {
        List<Super> optionsSuper = new ArrayList<Super>();
        Sighting target = new Sighting();
        target = service.getSighting(Integer.parseInt(request.getParameter("ID")));
        
        try{
            optionsSuper = service.searchSuper("all", null);
        } catch (FileNotFoundException ey) {}
        
        model.addAttribute("optionsSuper", optionsSuper);
        model.addAttribute("editTargetSight", target);
        service.removeSighting(Integer.parseInt(request.getParameter("ID")));
        
        return "SightEdit";
    }
    
    @RequestMapping(value="/removeSight", method=RequestMethod.POST)
    public String removeSight(Model model, HttpServletRequest request) {
        service.removeSighting(Integer.parseInt(request.getParameter("ID")));
        
        return "SightingsList";
    }
}
