/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.DvDLibrary.app;

import com.sg.DvDLibrary.controller.DvDLibraryMain;
import com.sg.DvDLibrary.dao.DAODeclar;
import com.sg.DvDLibrary.dao.DvDLibraryFNCTN;
import com.sg.DvDLibrary.ui.DvDLibraryInterface;
import com.sg.DvDLibrary.ui.DvDLibraryView;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class DvDLibraryApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner myScanner = new Scanner(System.in);
        DvDLibraryInterface myView = new DvDLibraryView(myScanner);
        DAODeclar myDAO = new DvDLibraryFNCTN();
        DvDLibraryMain Start = new DvDLibraryMain(myDAO, myView);
        Start.exe();
    }
    
}
