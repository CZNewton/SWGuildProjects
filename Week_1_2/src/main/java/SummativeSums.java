/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class SummativeSums {

    public static void main(String[] args) {
        int sum_mary = 0;
        int array1[] = {1, 90, -33, 055, 67, -16, 28, -55, 15};
        int array2[] = {999, -60, -77, 14, 160, 301};
        int array3[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, -99};

        sum_mary = sum_moning(array1);
        System.out.println(sum_mary);

        sum_mary = sum_moning(array2);
        System.out.println(sum_mary);

        sum_mary = sum_moning(array3);
        System.out.println(sum_mary);

        //I refuse to apologize for sum of these puns
    }

    public static int sum_moning(int one[]) {
        int sum, i, arrayLength;
        sum = 0;

        arrayLength = one.length;
        for (i = 0; i < arrayLength; i++) {
            sum += one[i];
        }

        return sum;
    }
}
