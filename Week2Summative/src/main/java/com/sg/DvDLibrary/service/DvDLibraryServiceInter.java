/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.DvDLibrary.service;

import com.sg.DvDLibrary.dto.DvD;
import java.util.ArrayList;

/**
 *
 * @author apprentice
 */
public interface DvDLibraryServiceInter {
    public void loadCheck();
    public void saveCheck();
    public void addCheck();
    public ArrayList<DvD> searchCheck();
    public ArrayList<DvD> allClear();
    public void sweep();
}
