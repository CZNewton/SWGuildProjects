package com.sg.DvDLibrary.controller;


import com.sg.DvDLibrary.dao.DAODeclar;
import com.sg.DvDLibrary.dto.DvD;
import com.sg.DvDLibrary.ui.DvDLibraryInterface;
import java.util.ArrayList;

/**
 *
 * @author apprentice
 */
public class DvDLibraryMain {
    
    DAODeclar dvdDOA;
    DvDLibraryInterface prompt;
    
    public DvDLibraryMain(DAODeclar myDAO, DvDLibraryInterface myView) {
        this.dvdDOA = myDAO;
        this.prompt = myView;
    }
    
    
    
    public void exe() throws Exception {
        int choice = 5;
        boolean again = true;
        int change = 0;
        
        prompt.loadAction();
        dvdDOA.load();
        
        choice = prompt.MainMenu();
        do {
            switch (choice) {
                case 0: adding();
                        change++;
                        break;
                case 1: removing();
                        change++;
                        break;
                case 2: editing();
                        change++;
                        break;
                case 3: listAll();
                        break;
                case 4: listing();
                        break;
                case 5: again = false;
                        break;
                default: break;
                
            }
            if (choice<5) {
                again = prompt.Again();
            }
        } while(again);
        
        dvdDOA.save(change);
        
        
    }
    
    private void adding() {
        DvD transfer = new DvD();
        transfer = prompt.userAdd();
        dvdDOA.addDvD(transfer);
    }
    
    private void removing() {
        String title;
        boolean confirm;
        confirm = prompt.removeConfirm();
        
        if (confirm == true) {
            title = listing();
            dvdDOA.remove(title);
        }
    }
    
    private void editing() {
        String title, change;
        boolean confirm;
        int select = 7;
        title = listing();
        confirm = prompt.editConfirm();
        select = prompt.editSelect();
        change = prompt.editChange(select);
        
        if (confirm == true) {
            dvdDOA.edit(title, change, select);
        }
    }
    
    private String listing() {
        int uConfirm=-1;
        String compare;
        ArrayList<DvD> searchRange = new ArrayList<>();
        searchRange = searching();
        do {
            uConfirm = prompt.searchResults(searchRange);
        } while(uConfirm == -1);
        
        compare = searchRange.get(uConfirm).getTitle();
        return compare;
    }
    
    private ArrayList<DvD> searching() {
        String response;
        ArrayList<DvD> sResult = new ArrayList<DvD>();
        response = prompt.search();
        sResult = dvdDOA.search(response);
        
        return sResult;
    }
    
    private void listAll(){
        ArrayList<DvD> all = new ArrayList<DvD>();
        all = dvdDOA.all();
        prompt.listAll(all);
    }
    
}
