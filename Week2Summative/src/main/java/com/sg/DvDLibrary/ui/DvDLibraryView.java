/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.DvDLibrary.ui;

import com.sg.DvDLibrary.dto.DvD;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class DvDLibraryView implements DvDLibraryInterface {
    
    Scanner temp;
    
    public DvDLibraryView(Scanner myScanner) {
        this.temp = myScanner;
    }

    @Override
    public int MainMenu() {
        String pHold;
        int uChoice = 6;

        System.out.println("Add|Remove|Edit|List|Search|Exit");
        pHold = temp.nextLine();
        pHold = pHold.toUpperCase();
        if (pHold.matches("ADD|A|1")) {
            uChoice = 0;
        } else if (pHold.matches("REMOVE|REM|-|DELETE|2")) {
            uChoice = 1;
        } else if (pHold.matches("EDIT|CHANGE|ALTER|UPDATE|3")) {
            uChoice = 2;
        } else if (pHold.matches("LIST|ALL|4")) {
            uChoice = 3;
        } else if (pHold.matches("SEARCH|FIND|5")) {
            uChoice = 4;
        } else if (pHold.matches("EXIT|LEAVE|STOP|6")) {
            uChoice = 5;
        } else {
            System.out.println("I'm sorry, I didn't quite get that.");
            uChoice = 6;
        }

        return uChoice;
    }

    public boolean Again() {
        String pHold;
        boolean again = true;
        do {
            System.out.println("Would you like to make another action?");
            pHold = temp.nextLine();
            pHold = pHold.toUpperCase();
        } while (pHold.matches("YES|Y|NO|N") == false);

        if (pHold.matches("NO|N")) {
            again = false;
        }

        return again;
    }

    public DvD userAdd() {
        String interm;
        DvD transfer = new DvD();

        System.out.println("Title?");
        transfer.setTitle(temp.nextLine());

        System.out.println("Release Date?");
        transfer.setrDate(temp.nextLine());

        do {
            System.out.println("Rating? (MPAA Scale)");
            interm = temp.nextLine();
            interm = interm.toUpperCase();
        } while (interm.matches("G|PG|PG-13|R|NC-17|X|XX|XXX") == false);
        transfer.setRating(interm);

        System.out.println("Director(s)?");
        transfer.setDirectorName(temp.nextLine());

        System.out.println("Studio(s)?");
        transfer.setStudioName(temp.nextLine());

        System.out.println("User Rating? (in %)");
        transfer.setUserRating(temp.nextLine());

        System.out.println("Additional Info:");
        transfer.setAddInfo(temp.nextLine());

        return transfer;
    }

    public int searchResults(ArrayList<DvD> resultList) {
        int chosen = -1;
        int track = 1;
        boolean round = true;
        String uInput;

        System.out.println("Here are the results (10):");
        for (DvD y : resultList) {
            System.out.print("Result " + track + ": ");
            System.out.println(y.getTitle());
            track++;
        }

        track = 0;

        do {
            System.out.println("==================");
            System.out.println("Please choose a result or exit");
            uInput = temp.nextLine();
            uInput = uInput.toUpperCase();

            if (uInput.matches("1|2|3|4|5|6|7|8|9|10")) {
                chosen = Integer.parseInt(uInput);
                chosen -= 1;
                round = false;
                System.out.println("==================");
                System.out.println("Title:           " + resultList.get(chosen).getTitle());
                System.out.println("Release Date:    " + resultList.get(chosen).getrDate());
                System.out.println("Rating:          " + resultList.get(chosen).getRating());
                System.out.println("Director(s):     " + resultList.get(chosen).getDirectorName());
                System.out.println("Studio(s):       " + resultList.get(chosen).getStudioName());
                System.out.println("User Rating:     " + resultList.get(chosen).getUserRating());
                System.out.println("Additional Info: " + resultList.get(chosen).getAddInfo());
            } else if (uInput.matches("EXIT|EX|LEAVE|0")) {
                round = false;
            }
        } while (round == true);

        return chosen;
    }

    public String search() {
        String input;
        System.out.println("What movie are you looking for? (by title)");
        input = temp.nextLine();

        return input;
    }

    public void listAll(ArrayList<DvD> All) {

        for (int i = 0; i < All.size(); i++) {
            System.out.println("==================");
            System.out.println("Title:           " + All.get(i).getTitle());
            System.out.println("Release Date:    " + All.get(i).getrDate());
            System.out.println("Rating:          " + All.get(i).getRating());
            System.out.println("Director(s):     " + All.get(i).getDirectorName());
            System.out.println("Studio(s):       " + All.get(i).getStudioName());
            System.out.println("User Rating:     " + All.get(i).getUserRating());
            System.out.println("Additional Info: " + All.get(i).getAddInfo());
        }

    }

    public boolean removeConfirm() {
        String uInput;
        boolean sure = true;

        do {
            System.out.println("Are you sure you would like to remove this DvD?");
            uInput = temp.nextLine();
            uInput = uInput.toUpperCase();
        } while (uInput.matches("YES|Y|NO|N") == false);

        if (uInput.matches("NO|N")) {
            sure = false;
        }
        return sure;
    }

    public int editSelect() {
        int choice = 7;
        String uInput;
        boolean again = true;

        System.out.println("What value do you wish to overwrite?");
        uInput = temp.nextLine();
        uInput = uInput.toUpperCase();

        if (uInput.matches("1|TITLE|NAME")) {
            choice = 0;
        } else if (uInput.matches("2|RELEASE|DATE|RELEASE DATE")) {
            choice = 1;
        } else if (uInput.matches("3|RATING")) {
            choice = 2;
        } else if (uInput.matches("4|DIRECTOR NAME|DIRECTOR|DIRECTORS")) {
            choice = 3;
        } else if (uInput.matches("5|STUDIO|STUDIO NAME|STUDIOS")) {
            choice = 4;
        } else if (uInput.matches("6|USER RATING|USR RATING|USER")) {
            choice = 5;
        } else if (uInput.matches("7|INFO|ADDITIONAL INFO|ADD INFO")) {
            choice = 6;
        } else {
            choice = 7;
        }

        return choice;
    }

    public boolean editConfirm() {
        String uInput;
        boolean sure = true;

        do {
            System.out.println("Is there information you would like to alter?");
            uInput = temp.nextLine();
            uInput = uInput.toUpperCase();
        } while (uInput.matches("YES|Y|NO|N") == false);

        if (uInput.matches("YES|Y")) {
            sure = false;
        }
        return sure;
    }
    
    public String editChange(int select) {
        String change;
        
        switch (select) {
            case 0: System.out.println("New title: ");
                    change = temp.nextLine();
                    break;
            case 1: System.out.println("New release date: ");
                    change = temp.nextLine();
                    break;
            case 2: System.out.println("New rating: ");
                    change = temp.nextLine();
                    break;
            case 3: System.out.println("New director name(s): ");
                    System.out.println("***Note, please seperate by comma if multiple***");
                    change = temp.nextLine();
                    break;
            case 4: System.out.println("New studio name(s): ");
                    System.out.println("***Note, please seperate by comma if multiple***");
                    change = temp.nextLine();
                    break;
            case 5: System.out.println("New user rating: ");
                    change = temp.nextLine();
                    break;
            case 6: System.out.println("New additional info: ");
                    change = temp.nextLine();
                    break;
            default:    change = "Numerical fail at editChange()";
                        break;
        }
        
        return change;
    }

    public void loadAction() {
        System.out.println("========================\nLoading....\n========================");
    }

    public void saveAction() {
        System.out.println("========================\nSaving....\n========================");
    }

    public void saveNoAction() {
        System.out.println("========================\nNo changes detected, closing....\n========================");
    }

}
