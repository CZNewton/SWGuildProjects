/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day3;

/**
 *
 * @author apprentice
 */
public class WingsMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String returned;
        Penguin Doof = new Penguin();
        Sparrow Boof = new Sparrow();
        
        returned = Doof.FlapWings();
        System.out.println(returned);
        returned = Boof.FlapWings();
        System.out.println(returned);
        returned = Boof.Fly();
        System.out.println(returned);
    }
    
}
