/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class BruteForceSort {
    public static void main (String[] args) {
        int[] tobeSorted = {4,6,10,8,11,1,2,0,7,5,3,9};
        int[] havebeenSorted;
        int[] sortedup = new int[tobeSorted.length];
        int[] sorteddown = new int[tobeSorted.length];
        int[] sortedweird = new int[tobeSorted.length];
        int bubble=0;
        int track=0;
        int max = 0;
        int min = 0;
        boolean checked=false;
        int chosen = 11;
        
        for (int i=0; i<tobeSorted.length; i++) {
            if(tobeSorted[i]<min) {
                min = tobeSorted[i];
                i = 0;
            } else if (tobeSorted[i]==min) {
                checked=true;
            }
            
            if(i==tobeSorted.length-1&&checked==false) {
                min++;
                i=0;
            }
        }
        
        for (int x=min;x<max;x++) {
            for (int i=0; i<tobeSorted.length; i++) {
                System.out.println("Ascending");
                if (tobeSorted[i]==bubble) {
                    sortedup[track] = tobeSorted[i];
                    System.out.print(sortedup[track]);
                    track++;
                    bubble++;
                }
            }
        }
        System.out.println("");
        
        track=0;
        for (int x=min;x<max;x++) {
            for (int i=0; i<tobeSorted.length; i++) {
                System.out.println("Descending");
                if (tobeSorted[i]==bubble) {
                    sorteddown[track] = tobeSorted[i];
                    System.out.print(sorteddown[track]);
                    track++;
                    bubble--;
                }  
            }
        }
        
        track = 0;
        
        for (int x=min;x<max;x++) {
            for (int i=0; i<tobeSorted.length; i++) {
                System.out.println("Weird");
                if(i!=4) {
                    if(tobeSorted[i]==chosen) {
                        sortedweird[i]=chosen;
                    }if (tobeSorted[i]==bubble) {
                        sortedweird[track] = tobeSorted[i];
                        System.out.print(sortedweird[track]);
                        track++; 
                    }
                }
            }
        }
    }
}
