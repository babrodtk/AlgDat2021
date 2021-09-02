package no.oslomet.cs.algdat;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] values = {1, 7, 8, 2, 4, 6, 9, 5};

        //Outer loop: counts the number of cards we have sorted so far
        for (int i=0; i<values.length-1; ++i) {
            //Print out values
            System.out.println("Skal finne kort på plass " + i);
            System.out.println("Array før vi starter: " + Arrays.toString(values));
            //Inner loop: loops from end of the deck and forward through the
            //unsorted cards, and bubbles up
            for (int j=values.length-1; j>i; --j) {
                //Swap the cards if they are out of order
                if (values[j] > values[j-1]) {
                    int temp = values[j];
                    values[j] = values[j-1];
                    values[j-1] = temp;
                    System.out.println("Bytter " + values[j] + " med " + values[j-1] + ": " + Arrays.toString(values));
                }
            }
        }

        //Print out final sorted
        System.out.println("Ferdig sortert array:");
        System.out.println(Arrays.toString(values));
    }
}
