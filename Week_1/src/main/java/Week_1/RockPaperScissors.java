/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Week_1;

/**
 *
 * @author apprentice
 */
import java.util.Scanner;

public class RockPaperScissors {

    static Scanner inputR = new Scanner(System.in);
    static String errorBlank;

    public static void main(String[] args) {
        boolean gameState;
        String P1Input, compResult, answer;
        int P1Choice, Result, compChoice, win, loss, draw, round;
        win = 0;
        loss = 0;
        draw = 0;
        gameState = true;

        round = Intro();
        //While loop container to allow for playing again
        while (gameState) {
            do {
                //Math.random statement for range of 1-3
                compChoice = (int) (Math.random() * 3) + 1;
                //Reminder: Switch statements will continue through all cases after the
                //matching case without breaks!
                switch (compChoice) {
                    case 1:
                        compResult = "ROCK";
                        break;
                    case 2:
                        compResult = "PAPER";
                        break;
                    case 3:
                        compResult = "SCISSORS";
                        break;
                    default:
                        compResult = "Null";
                }

                //Do while statement to poke user again on invalid input
                do {
                    System.out.println("Player 1, what weapon do you choose?");
                    P1Input = inputR.nextLine();
                    P1Input = P1Input.toUpperCase();
                    P1Choice = PlayerInput(P1Input);
                } while (P1Choice == 4);
                
                System.out.print(" vs. \n" + compResult + "\n");

                Result = Fight(P1Choice, compChoice);
                switch (Result) {
                    case 0:
                        draw++;
                        System.out.println("Draw!");
                        break;
                    case 1:
                        win++;
                        System.out.println("Win!");
                        break;
                    case 2:
                        loss++;
                        System.out.println("Loss!");
                        break;
                }

                //To ensure the correct number of rounds are given
                round--;

            } while (round > 0);
            
            System.out.println("And that's game!");
            if (win > loss) {
                System.out.println("Player wins with a win/loss of " + win + "/" + draw + "/" + loss);
            } else if (loss > win) {
                System.out.println("Player loses with a win/loss of " + win + "/" + draw + "/" + loss);
            } else if (win == loss) {
                System.out.println("Beleive it or not it's a tie! At " + win + "/" + draw + "/" + loss + " for the player!");
            } else {
                debug(3);
            }

            //Play again prompt
            System.out.println("Play Again?");
            answer = inputR.nextLine();
            answer = answer.toUpperCase();
            if (answer.equals("NO") == true || answer.equals("N") == true) {
                gameState = false;
            } else if (answer.equals("YES") == false || answer.equals("Y") == false) {
                debug(4);
            }

        } //exit from gameState loop
        System.out.println("Thanks for playing!");
        return;
    }

    public static int PlayerInput(String P1) {
        String errorBlank;
        if (P1.equals("ROCK") == true || P1.equals("R") == true) {
            return 1;
        } else if (P1.equals("PAPER") == true || P1.equals("P") == true) {
            return 2;
        } else if (P1.equals("SCISSORS") == true || P1.equals("S") == true) {
            return 3;
        }
        System.out.println("Invalid input!");
        return 4;
    }

    public static int Fight(int Player, int Computer) {
        int Difference = Player - Computer;
        //0 return is draw
        //1 return is player win
        //2 return is computer win
        switch (Difference) {
            case 0:
                return 0;
            case 1:
                return 1;
            case -1:
                return 2;
            case 2:
                return 2;
            case -2:
                return 1;
            default:
                return 0;
        }
    }

    public static int Intro() {
        String roundString;
        int roundNumber;
        System.out.println("Rock Paper Scissors! Get ready!");
        System.out.println("How many rounds woiuld you like to play?");
        roundString = inputR.nextLine();
        roundNumber = Integer.parseInt(roundString);
        if (roundNumber < 1 || roundNumber > 10) {
            debug(1);
        }
        return roundNumber;
    }

    //Method takes a different value input based on where the call happened
    //called in dead end events
    public static void debug(int type) {
        System.out.println("Error " + type + ". Enter any value to exit.");
        errorBlank = inputR.nextLine();
        System.exit(type);
    }
}
