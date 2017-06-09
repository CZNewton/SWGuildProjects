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

public class HealthyHearts {
    static Scanner input1 = new Scanner(System.in);
    
    public static void main(String[] args) {
        String inputS;
        int inputI, hRate;
        hRate = 1;
        System.out.println("What is your age?");
        do  {
            inputS = input1.nextLine();
            inputI = Integer.parseInt(inputS);
            hRate = 220-inputI;
            if (hRate<1 || hRate>=220) {
                System.out.println("You're not dead, try again.\n What is your age?");
            }
        } while (hRate<1  || hRate>=220);
        System.out.println("Your maximum heart rate should be " + (hRate) + " beats per minutes");
        System.out.println("Your target HR zone is " + (hRate/2) + " - " + (hRate*0.85) + " beats per minute");
    }
}
