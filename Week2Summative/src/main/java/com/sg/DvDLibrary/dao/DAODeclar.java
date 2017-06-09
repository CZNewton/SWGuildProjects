/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.DvDLibrary.dao;

import com.sg.DvDLibrary.dto.DvD;
import com.sg.DvDLibrary.ui.DvDLibraryView;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public interface DAODeclar {
    ArrayList<String> library = new ArrayList<>();
    ArrayList<DvD> shelf = new ArrayList<>();
    public void load() throws Exception;
    public void save(int changeNumber) throws Exception;
    public void addDvD(DvD newbie);
    public void remove(String tempName);
    public void edit(String tempName, String change, int select);
    public ArrayList<DvD> search(String name);
    public ArrayList<DvD> all();
}
