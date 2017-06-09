package com.sg.DvDLibrary.dao;

import com.sg.DvDLibrary.dto.DvD;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author apprentice
 */
public class DvDLibraryFNCTN implements DAODeclar {
    
    @Override
    public void load() throws Exception {
        Scanner read = new Scanner(new BufferedReader(new FileReader("Resources/Library.txt")));
        String currentLine;
        int r = 0;
        while (read.hasNextLine()) {
            currentLine = read.nextLine();
            library.add(currentLine);
        }

        //need to convert pre-existing library to objects
        for (int i = 0; i < library.size(); i += 7) {
            //Object creation cycle-in
            DvD Oldie = new DvD();
            shelf.add(Oldie);
            for (int j = 0; j < 7; j++) {
                switch (j) {
                    //Writing from library to shelf array
                    case 0:
                        Oldie.setTitle(library.get(r));
                        break;
                    case 1:
                        Oldie.setrDate(library.get(r));
                        break;
                    case 2:
                        Oldie.setRating(library.get(r));
                        break;
                    case 3:
                        Oldie.setDirectorName(library.get(r));
                        break;
                    case 4:
                        Oldie.setStudioName(library.get(r));
                        break;
                    case 5:
                        Oldie.setUserRating(library.get(r));
                        break;
                    case 6:
                        Oldie.setAddInfo(library.get(r));
                        break;
                    default:
                        break;
                }
                r++;
            }
        }
    }

    @Override
    public void save(int changeNumber) throws Exception {
        PrintWriter saveOut = new PrintWriter(new FileWriter("Resources/Library.txt"), false);
        PrintWriter recoverOut = new PrintWriter(new FileWriter("Resources/Recovery.txt"), false);

        //back-up file for any run-time accidents
        for (String s : library) {
            recoverOut.println(s);
        }
        recoverOut.flush();
        recoverOut.close();

        //total save
        for (int i = 0; i < shelf.size(); i++) {
            saveOut.println(shelf.get(i).getTitle());
            saveOut.println(shelf.get(i).getrDate());
            saveOut.println(shelf.get(i).getRating());
            saveOut.println(shelf.get(i).getDirectorName());
            saveOut.println(shelf.get(i).getStudioName());
            saveOut.println(shelf.get(i).getUserRating());
            saveOut.println(shelf.get(i).getAddInfo());
        }
        saveOut.flush();
        saveOut.close();
    }

    public void addDvD(DvD newbie) {       
        shelf.add(newbie);
    }

    public void remove(String tempName) {
        String tempGet;
        int track = 0;
        tempName = tempName.toUpperCase();
        for(DvD s : shelf) {
            tempGet = s.getTitle().toUpperCase();
            if(tempGet.equals(tempName)) {
                shelf.remove(track);
                break;
            }
            track++;
        }
        
    }

    public void edit(String tempName, String change, int select) {
        String tempGet;
        int track = 0;
        tempName = tempName.toUpperCase();
        for(DvD s : shelf) {
            tempGet = s.getTitle().toUpperCase();
            if(tempGet.equals(tempName)) {
                break;
            }
            track++;
        }
        
        switch (select) {
            case 0: shelf.get(track).setTitle(change);
                    break;
            case 1: shelf.get(track).setrDate(change);
                    break;
            case 2: shelf.get(track).setRating(change);
                    break;
            case 3: shelf.get(track).setDirectorName(change);
                    break;
            case 4: shelf.get(track).setStudioName(change);
                    break;
            case 5: shelf.get(track).setUserRating(change);
                    break;
            case 6: shelf.get(track).setAddInfo(change);
                    break;
            default: break;
        }
    }

    public ArrayList<DvD> search(String name) {
        ArrayList<DvD> result = new ArrayList<DvD>();

        for (DvD Hold : shelf) {
            if (name.contains(Hold.getTitle())) {
                result.add(Hold);                       //transfer overlay reference to result list
            }
        }

        return (result);
    }
    
    public ArrayList<DvD> all() { 
        return shelf;
    }

}
