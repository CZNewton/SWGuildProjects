/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class dogHotel {
    public static void main(String[] args) {
        boolean taken = true;
        Dog Boof = new Dog("Boof", "Tibetan Mastiff", 67, "Large");
        System.out.println(Boof.getName());
        
        for (int i = 0;i<25;i++) {
            Dog Blank = new Dog("Name " + i, "Breed " + i, (5+i), "Size: " + i);
            taken = Pound.add(Blank);
            System.out.println(Blank.getName() + " " +  taken);
        }
    }
}
