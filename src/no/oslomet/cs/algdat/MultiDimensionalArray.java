package no.oslomet.cs.algdat;

public class MultiDimensionalArray {
    public static void main(String[] args) {
        /**
         * Version 1: scattered in memory
         */
        //Først alloker et array med 5 pekere til int[]
        int[][] my_data = new int[5][];
        for (int i=0; i<my_data.length; ++i) {
            //Så, for hver peker, alloker et int-array med lengde 6
            my_data[i] = new int[6];
        }
        //Set element in position (3, 4) (i.e., number 22 below) to 9
        // [ [ 0  1  2  3  4  5] ;
        //   [ 6  7  8  9 10 11] ;
        //   [12 13 14 15 16 17] ;
        //   [18 19 20 21 22 23] ;
        //   [24 25 26 27 28 29] ];
        // Remember that each row is contiguous in memory, but that
        // element 5 and 6 are not contiguous in memory.
        my_data[3][4] = 9;

        /**
         * Version 2: Allocate contiguous memory (more efficient
         */
        int[] my_data2 = new int[5*6];
        //Set element in position (3, 4) to 9
        // [  0  1  2  3  4  5
        //    6  7  8  9 10 11
        //   12 13 14 15 16 17
        //   18 19 20 21 22 23
        //   24 25 26 27 28 29 ];
        // In this version, we still set element 22 to 9,
        // but the index is more complex. We use a single index
        // calculated as row_number * number_of_columns + column_number:
        // 3 * 6 + 4
        my_data2[3*6+4] = 9;
    }
}
