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

public class Blackjack {

    static Scanner uInput = new Scanner(System.in);
    static int score, scoreDealer;
    static String uInterm;
    static boolean uCheck, stayDealer;
    static String[][] Deck = new String[0][0];

    public static void main(String[] args) {
        boolean gameState, roundState;
        int deckCount, wins, losses, draws, cards, bJacks;
        gameState = true;
        uCheck = false;
        roundState = true;
        wins = 0;
        losses = 0;
        draws = 0;
        bJacks = 0;

        deckCount = Intro();
        Deck = Build(deckCount);

        System.out.println("Welcome to Blackjack 20/20, where you can always see how much you lose!");
        while (gameState) {
            score = 0;
            scoreDealer = 0;
            cards = 0;
            uInterm = "blank";

            //Player draw and play
            while (roundState && cards < 5) {
                roundState = roundPlayer(deckCount);
                cards++;
            }
            cards = 0;
            //Check for blackjack metric
            if (score == 21) {
                bJacks++;
            } //Check for player busts. No need for dealer to do anything if player busted.
            else if (score > 21) {
                losses++;
                System.out.println("lose");
            } else {
                roundState = true;
            }
            //Dealer draw and play
            while (roundState) {
                roundState = roundDealer(deckCount);
            }
            //Score comparison at end game
            System.out.println("" + score + " vs. " + scoreDealer);
            //Case for dealer bust
            if (score < 21 && scoreDealer > 21) {
                wins++;
                System.out.println("Win! Too bad you don't actually get anything...");
            } //Case for dealer win
            else if (scoreDealer == 21 || scoreDealer >= score) {
                losses++;
                System.out.println("lose");
            } //Case for player win
            else if (score > scoreDealer && score < 21) {
                wins++;
                System.out.println("Win! Too bad you don't actually get anything...");
            }
            //Display of total win/loss. Includes Blackjack count.
            System.out.println("So far: " + wins + "/" + losses + " and " + bJacks + " Blackjacks");
            System.out.println("Keep going?");

            do {
                uInterm = uInput.nextLine();
                uInterm = uInterm.toUpperCase();
            } while (uInterm.matches("NO|N|Y|YES") == false);

            if (uInterm.matches("NO|N")) {
                gameState = false;
            } else if (uInterm.matches("Y|YES")) {
                gameState = true;
            }
        }//End of gameState loop
        System.out.println("Thanks for playing! \n*whispers* sucker");
    }

    //Deck-building method. Places appropriate srigns for associated spots in the array.
    public static String[][] Build(int deckCount) {
        String[][] preDeck = new String[10][52];
        String suit;
        int z;

        //for loop tier for number of decks
        for (int i = 0; i < deckCount; i++) {
            z = 0;
            //for loop tier for card suites
            for (int j = 0; j < 4; j++) {
                switch (j) {
                    case 0:
                        suit = "Hearts";
                        break;
                    case 1:
                        suit = "Clubs";
                        break;
                    case 2:
                        suit = "Spades";
                        break;
                    case 3:
                        suit = "Diamonds";
                        break;
                    default:
                        suit = "Error";
                }

                //for loop tier for individual cards. Writing happens here.
                for (int k = 0; k < 13; k++) {
                    switch (k) {
                        case 0:
                            //placement for writing is based of of 2nd dimension (deckCount i)
                            //
                            preDeck[i][k + z] = "Ace of " + suit;
                            break;
                        case 1:
                            preDeck[i][k + z] = "Two of " + suit;
                            break;
                        case 2:
                            preDeck[i][k + z] = "Three of " + suit;
                            break;
                        case 3:
                            preDeck[i][k + z] = "Four of " + suit;
                            break;
                        case 4:
                            preDeck[i][k + z] = "Five of " + suit;
                            break;
                        case 5:
                            preDeck[i][k + z] = "Six of " + suit;
                            break;
                        case 6:
                            preDeck[i][k + z] = "Seven of " + suit;
                            break;
                        case 7:
                            preDeck[i][k + z] = "Eight of " + suit;
                            break;
                        case 8:
                            preDeck[i][k + z] = "Nine of " + suit;
                            break;
                        case 9:
                            preDeck[i][k + z] = "Ten of " + suit;
                            break;
                        case 10:
                            preDeck[i][k + z] = "Jack of " + suit;
                            break;
                        case 11:
                            preDeck[i][k + z] = "Queen of " + suit;
                            break;
                        case 12:
                            preDeck[i][k + z] = "King of " + suit;
                            break;
                        default:
                            System.exit(1);
                    }
                }
                z += 13;
            }
        }
        return preDeck;
    }

    public static int Intro() {
        String inputBlank;
        int Count;
        System.out.println("How many decks would you like the play with? (up to 10)");
        inputBlank = uInput.nextLine();
        Count = Integer.parseInt(inputBlank);

        while (Count > 10 || Count < 0) {
            System.out.println("Sir/Madame, please, I would like an actual answer please.");
            inputBlank = uInput.nextLine();
            Count = Integer.parseInt(inputBlank);
        }

        return Count;
    }

    public static boolean roundPlayer(int deckCount) {
        int currentDeck, currentCard, draw;
        do {
            currentDeck = (int) (Math.random() * deckCount);
            currentCard = (int) (Math.random() * 52);
            draw = (currentCard % 13);
            System.out.println(Deck[currentDeck][currentCard]);
        } while (Deck[currentDeck][currentCard].matches("X"));

        switch (draw) {
            case 0:
                do {
                    System.out.println("How would you like to treat this Ace? High or Low?");
                    uInterm = uInput.nextLine();
                    uInterm = uInterm.toUpperCase();
                    if (uInterm.equals("HIGH") || uInterm.equals("H")) {
                        score += 11;
                        uCheck = true;
                    } else if (uInterm.equals("LOW") || uInterm.equals("L")) {
                        score += 1;
                        uCheck = true;
                    } else {
                        uCheck = false;
                    }
                } while (uCheck == false);
                break;
            case 1:
                score += 2;
                break;
            case 2:
                score += 3;
                break;
            case 3:
                score += 4;
                break;
            case 4:
                score += 5;
                break;
            case 5:
                score += 6;
                break;
            case 6:
                score += 7;
                break;
            case 7:
                score += 8;
                break;
            case 8:
                score += 9;
                break;
            case 9:
                score += 10;
                break;
            case 10:
                score += 10;
                break;
            case 11:
                score += 10;
                break;
            case 12:
                score += 10;
                break;
            default:
                System.out.println("Joker!");
                break;
        }

        System.out.println("Total: " + score);

        Deck[currentDeck][currentCard] = "X";

        if (score >= 21) {
            if (score == 21) {
                System.out.println("Blackjack! Lucky!");
            }
            return false;
        }

        System.out.println("Hit or Stay?");
        uInterm = uInput.nextLine();
        uInterm = uInterm.toUpperCase();

        while (uInterm.matches("HIT|H") == false && uInterm.matches("STAY|S") == false) {
            System.out.println("Let's try again. Hit or Stay?");
            uInterm = uInput.nextLine();
            uInterm = uInterm.toUpperCase();
        }

        if (uInterm.matches("STAY|S")) {
            return false;
        }

        return true;
    }

    public static boolean roundDealer(int deckCount) {
        int currentDeck, currentCard, draw;
        do {
            currentDeck = (int) (Math.random() * deckCount);
            currentCard = (int) (Math.random() * 52);
            draw = (currentCard % 13);
            System.out.println(Deck[currentDeck][currentCard]);
        } while (Deck[currentDeck][currentCard].matches("X"));

        switch (draw) {
            case 0:
                if (scoreDealer > 10) {
                    scoreDealer += 1;
                } else if (scoreDealer == 10) {
                    scoreDealer += 11;
                } else {
                    scoreDealer += 11;
                }
                break;
            case 1:
                scoreDealer += 2;
                break;
            case 2:
                scoreDealer += 3;
                break;
            case 3:
                scoreDealer += 4;
                break;
            case 4:
                scoreDealer += 5;
                break;
            case 5:
                scoreDealer += 6;
                break;
            case 6:
                scoreDealer += 7;
                break;
            case 7:
                scoreDealer += 8;
                break;
            case 8:
                scoreDealer += 9;
                break;
            case 9:
                scoreDealer += 10;
                break;
            case 10:
                scoreDealer += 10;
                break;
            case 11:
                scoreDealer += 10;
                break;
            case 12:
                scoreDealer += 10;
                break;
            default:
                System.out.println("Joker!");
                break;
        }

        System.out.println(scoreDealer);
        Deck[currentDeck][currentCard] = "X";

        if (scoreDealer >= 21) {
            if (scoreDealer == 21) {
                System.out.println("Blackjack! Sorry!");
            }
            return false;
        }

        if (scoreDealer >= 17) {
            return false;
        }
        return true;
    }
}
