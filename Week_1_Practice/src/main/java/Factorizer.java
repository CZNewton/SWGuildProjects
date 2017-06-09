/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
import java.util.Scanner;

public class Factorizer {
    static Scanner input1 = new Scanner(System.in);
    public static void main(String[] args) {
        String inp;
        int number, mid, check, primeCheck;
        primeCheck=0;
        
        System.out.println("Number?");
        inp = input1.nextLine();
        
        number = Integer.parseInt(inp);
        //Check for perfect number, useed after for loop.
        check = Math.round(number);
        
        System.out.println("" + number + " is divisible by:");
        
        for (int i=1; i<number; i++) {
            mid = number % i;
            if (mid == 0) {
                System.out.println(i);
                primeCheck++;
            }
        }
        //Inclusive self-divisible output if needed.
        //System .out. println(number);
        
        //Perfect number decision
        if ((number-check) ==  0) { 
            System.out.println("" + number + " is a perfect number");
        }
        else {
            System.out.println("" + number + " is not a perfect number");
        }
        
        //Prime number decision
        if (primeCheck == 1) {
            System.out.println("" + number + " is a prime number");
        }
        else {
            System.out.println("" + number + " is not a prime number");
        }
        
    }
}
