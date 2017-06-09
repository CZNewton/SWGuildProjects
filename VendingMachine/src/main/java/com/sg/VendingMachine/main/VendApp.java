/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.VendingMachine.main;

import com.sg.VendingMachine.controller.VendControl;
import com.sg.VendingMachine.ui.VendViewImpl;
import java.util.Scanner;
import com.sg.VendingMachine.service.VendService;
import com.sg.VendingMachine.service.VendServiceImpl;
import com.sg.VendingMachine.ui.VendView;

/**
 *
 * @author apprentice
 */
public class VendApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VendView uView = new VendViewImpl(scanner);
        VendService uService = new VendServiceImpl();
        VendControl Start = new VendControl(uView, uService);
        Start.run();
    }
}
