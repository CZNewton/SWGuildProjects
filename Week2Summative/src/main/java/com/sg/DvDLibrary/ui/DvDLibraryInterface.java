/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.DvDLibrary.ui;

import com.sg.DvDLibrary.dto.DvD;
import java.util.ArrayList;

/**
 *
 * @author apprentice
 */
public interface DvDLibraryInterface {
    public int MainMenu();
    public boolean Again();
    public DvD userAdd();
    public int searchResults(ArrayList<DvD> resultList);
    public String search();
    public void listAll(ArrayList<DvD> All);
    public boolean removeConfirm();
    public int editSelect();
    public boolean editConfirm();
    public String editChange(int select);
    public void loadAction();
    public void saveAction();
    public void saveNoAction();
}
