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

public class DogGenetics {

    static Scanner Input1 = new Scanner(System.in);

    public static void main(String[] args) {
        String dogName;
        int range, variety, increment, i, breedType;
        range = 80;
        variety = 5;
        int[] Breakdown = new int[variety];
        String[] BreedsSmall = {"Cocker Spaniel", "Corgi", "Shitzu", "Chihuahua", "Toy Poodle", "Mini Australian-Shepard"};
        String[] BreedsMedium = {"Water Spaniel", "Black Lab", "Boiqin Spaniel", "Border Collie", "Poodle", "Pit Bull", "Labrador"};
        String[] BreedsLarge = {"Tibetan Mastiff", "Great Dane", "St.Bernard", "Newfoundland", "Great Pyreness", "Dogue de Bordeaux", "Black Terrier"};

        breedType = (int) (Math.random() * 3) + 1;

        for (i = 0; i < (variety - 1); i++) {
            do {
                increment = (int) (Math.random() * range) + 5;
            } while (increment > 50);
            range = (range+5) - increment;
            Breakdown[i] = increment;
        }
        Breakdown[variety - 1] = range;
        
        //Intro prompt, humor
        System.out.println("Dog's name?");
        dogName = Input1.nextLine();
        System.out.println("DNA Results? I think I have them around here somewhere......\n *****CRASH*******\nDon't worry I'm fine!");
        System.out.println("*****LOUD SCREECHING****");
        System.out.println("Dave you stupid bird, let that go!\n\nOkay here's the results, ignore the claw marks.....\nand the stains.\n");
        System.out.println(dogName + " is:");
        
        //Logic to garuntee similar breeds in the breakdown list
        switch (breedType) {
            case 1:
                for (i = 0; i < variety; i++) {
                    System.out.println(BreedsSmall[i] + ": " + Breakdown[i] + "%");
                }
                break;

            case 2:
                for (i = 0; i < variety; i++) {
                    System.out.println(BreedsMedium[i] + ": " + Breakdown[i] + "%");
                }
                break;

            default:
                for (i = 0; i < variety; i++) {
                    System.out.println(BreedsLarge[i] + ": " + Breakdown[i] + "%");
                }
                break;
        }
    }
}
