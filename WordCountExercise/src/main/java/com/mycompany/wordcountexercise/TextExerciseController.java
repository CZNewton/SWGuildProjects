/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wordcountexercise;

/**
 *
 * @author apprentice
 */
public class TextExerciseController {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WordCount counter = new WordCount();
        
        counter.initiateCount("../Resources/Alice.txt");
    }
    
}
