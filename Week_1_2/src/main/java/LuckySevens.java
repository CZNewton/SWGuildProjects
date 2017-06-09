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

public class LuckySevens {
    static Scanner uInput = new Scanner(System.in);
    public static void main(String[] args) {
        boolean gameState = true;
        String uPlaceholder;
        int roll, rounds;
        double bet, money, high;
        rounds = 0;
        money = 0;
        high = 0;
        
        
        System.out.println("How much money would like to los...I mean bet?");
        uPlaceholder =  uInput.nextLine();
        bet = Double.parseDouble(uPlaceholder);
        money = bet;
        
        while (gameState) {
            while (money>=0) {
                roll = Dice();
                
                //On the off-chance we come back to this exercise with different effects needed
                switch (roll) {
                    case 7: money +=4;
                            break;
                    case 1: money -=1;
                            break;
                    case 2: money -=1;
                            break;
                    case 3: money -=1;
                            break;
                    case 4: money -=1;
                            break;
                    case 5: money -=1;
                            break;
                    case 6: money -=1;
                            break;
                    case 8: money -=1;
                            break;
                    case 9: money -=1;
                            break;
                    case 10: money -=1;
                            break;
                    case 11: money -=1;
                            break;
                    case 12: money -=1;
                            break;
                    default: System.out.println("error at Switch");
                            return;
                }
                if (money>high) {
                    high = (double)Math.round(money*100d)/100;
                }
                
                System.out.print(" " + roll);
                if (roll==7) {
                    System.out.println(" Lucky Lucky! You're at $" + money);
                }
                rounds++;
            }
            
            System.out.println("\nHighest money: $" + high);
            System.out.println("Rounds lasted: " + rounds);
            System.out.println("Profit you COULD have had: $" + (high-bet));
            
            System.out.println("\n\nPlay Again?");
            uPlaceholder = uInput.nextLine();
            uPlaceholder = uPlaceholder.toUpperCase();
            if (uPlaceholder.equals("YES") || uPlaceholder.equals("Y")) {
                gameState=true;
                money = 0;
                high = 0;
                rounds = 0;
                money = bet;
            }
            else {
                gameState=false;
            }
        }
        
    }
    
    public static int Dice() {
        int sum, x, y;
        
        x = (int)(Math.random()*6)+1;
        y = (int)(Math.random()*6)+1;
        
        sum = x+y;
        return sum;
    }
}
