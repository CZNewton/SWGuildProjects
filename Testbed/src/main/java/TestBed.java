/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class TestBed {
    public static void main(String[] args) {
        int y = 5;
        int[] x = new int[y];
        int[][] z = new int[y][10];
        
        Print1D(x);
        Print2D(z);
    }
    
    public static void Print1D(int[]blah) {
        for (int i = 0; i<blah.length;i++) {
            blah[i] = (int)(Math.random()*101);
            System.out.println(blah[i]);
        }
    }
    
    public static void Print2D(int[][]blah) {
        for (int i = 0; i<blah.length;i++) {
            blah[i][0] = (int)(Math.random()*101);
            System.out.println(blah[i][0]);
            for (int j = 1; j<blah[2].length; j++) {
                blah[i][j] = j;
                System.out.println(blah[i][j]);
            }
        }
    }
}
