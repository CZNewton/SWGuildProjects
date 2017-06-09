/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day3;

import ui.UserIO;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class UserIO1 implements UserIO {
    private Scanner uInput = new Scanner(System.in);
    private String uInputString;
    

    public void print(String message) {
        System.out.println(message);
    }
    public double readDouble(String prompt){
        double end = 0;
        System.out.println(prompt);
        end = uInput.nextDouble();
        return end;
    }
    public double readDouble(String prompt, double min, double max){
        double end = 0;
        do{
            System.out.println(prompt);
            end = uInput.nextDouble();
        } while(end<=max && end>=min);
        return end;
    }
    public float readFloat(String prompt){
        float end = 0;
        System.out.println(prompt);
        end = uInput.nextFloat();
        return end;
    }
    public float readFloat(String prompt, float min, float max){
        float end = 0;
        do {
            System.out.println(prompt);
            end = uInput.nextFloat();
        } while(end>=min && end <=max);
        return end;
    }
    public int readInt(String prompt){
        int end = 0;
        System.out.println(prompt);
        end = uInput.nextInt();
        return end;
    }
    public int readInt(String prompt, int min, int max){
        int end = 0;
        do {
            System.out.println(prompt);
            end = uInput.nextInt();
        } while (end>=min && end<=max);
        return end;
    }
    public long readLong(String prompt){
        long end = 0;
        System.out.println(prompt);
        end = uInput.nextLong();
        return end;
    }
    public long readLong(String prompt, long min, long max){
        long end = 0;
        do {
            System.out.println(prompt);
            end = uInput.nextLong();
        } while (end>=min && end <=max);
        return end;
    }
    public String readString(String prompt){
        System.out.println(prompt);
        uInputString = uInput.nextLine();
        return uInputString;
    }
    
}
