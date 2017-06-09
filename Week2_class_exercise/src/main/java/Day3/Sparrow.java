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
public class Sparrow implements ICanFly {
    @Override
    public String FlapWings() {
        String message = "flapping!";
        return message;
    }
    @Override
    public String Fly() {
        String message = "flying!";
        return message;
    }
}
