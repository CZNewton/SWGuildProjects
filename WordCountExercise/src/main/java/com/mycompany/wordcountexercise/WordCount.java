/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wordcountexercise;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public class WordCount {
    private Map<String, Integer> count = new HashMap<String, Integer>();
    
    public Map returnCount() {
        return count;
    }
    
    public void initiateCount(String relevantFile) throws 
        IOException {
        String[] streamer;
        InputStream inp = new FileInputStream(relevantFile);
        InputStreamReader inread = new InputStreamReader(inp, Charset.forName("UTF-8"));
        BufferedReader br = new BufferedReader(inread);
        
        while ((br.readLine()) != null) {
            streamer = br.readLine().trim().split("\\s+");
            
            for(String word : streamer) {
                if(count.containsKey(word)==false) {
                    count.put(word, 1);
                } else {
                    count.put(word, (count.get(word) + 1));
                }
            }
            
        }
        
    }
}
