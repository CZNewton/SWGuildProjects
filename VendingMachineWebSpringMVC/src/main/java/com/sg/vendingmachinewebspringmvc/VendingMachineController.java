/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinewebspringmvc;

import com.sg.vendingmachinewebspringmvc.dto.Coins;
import com.sg.vendingmachinewebspringmvc.dto.Item;
import com.sg.vendingmachinewebspringmvc.service.InsuffecientFunds;
import com.sg.vendingmachinewebspringmvc.service.InsuffecientStock;
import com.sg.vendingmachinewebspringmvc.service.VendWebServImpl;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author totally zack, I swear. You can trust me I'm a computer
 */

/* Notes:::::
1. use 'Model' object (source in Spring) to access elements with index.jsp
2. use addAttribute on 'Model' object passed into controller (here) to set values that will be referenced internally throughout index.jsp
*/



@Controller
public class VendingMachineController {
    
    private final VendWebServImpl service;
    
    @Inject
    public VendingMachineController(VendWebServImpl uServ) {
        this.service = uServ;
    }
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String start(Model model) {
        service.loadItems();
        return displayMainMenu(model);
    }
    
    @RequestMapping(value="/MainMenu", method=RequestMethod.GET)
    private String displayMainMenu(Model model) {
        
        List<Item> all = service.getAll();
        
        model.addAttribute("inventory", all);
        return "index";
    }
    
    @RequestMapping(value="/buyItem", method=RequestMethod.GET)
    public String buyItem(@RequestParam String itemName, Model model) {
        String message = "THANK YOU";  
        try {
            service.transaction(itemName);
        } catch (InsuffecientFunds ex) {
            message = "INSERT MORE MONEY";
        } catch (InsuffecientStock ey) {
            message = "OUT OF STOCK";
        }
        model.addAttribute("message", message);
        return dispenseChange(model);
    }
    
    @RequestMapping(value="/addMuns", method=RequestMethod.POST)
    public String add$(Model model, HttpServletRequest request) {
        service.addMoney(request.getParameter("coin"));
        model.addAttribute("money", service.updateMoney());
        return displayMainMenu(model);
    }
    
    @RequestMapping(value="/dispenseChange", method=RequestMethod.GET)
    public String dispenseChange(Model model) {
        Coins returnChange = service.dispenseChange();
        model.addAttribute("change", returnChange);
        return displayMainMenu(model);
    }
    
}
