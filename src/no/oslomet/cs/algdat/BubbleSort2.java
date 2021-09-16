package no.oslomet.cs.algdat;

import java.util.Arrays;

public class BubbleSort2
{

    public static void main(String[]strings) {
        int [] values = {5, 6, 9, 2, 8, 3, 1, 10, 32, 4, 7, 14, 17, 18, 13};

        bubbleSort(values);

        System.out.println(Arrays.toString(values));


        int index1 = binarySearch(values, 9);
        System.out.println("Fant tallet 9 på " + index1);


        int index2 = binarySearch(values, 11);
        System.out.println("Fant tallet 11 på " + index2);

        int index3 = binarySearchRecursive(values, 9,
                0, values.length-1);
        System.out.println("Fant tallet 9 rekursivt på " + index3);

        int index4 = binarySearchRecursive(values, 11,
                0, values.length-1);
        System.out.println("Fant tallet 11 rekursivt på " + index4);
    }

    public static int binarySearchRecursive(int[] values,
                                             int search_value,
                                             int l,
                                             int r) {
        int m = (l+r) / 2;

        if (l > r) {
            return -l;
        }

        if (values[m] > search_value) {
            r = m-1;
            return binarySearchRecursive(values, search_value, l, r);
        }
        else if (values[m] < search_value) {
            l = m+1;
            return binarySearchRecursive(values, search_value, l, r);
        }
        else if (values[m] == search_value) {
            return m;
        }
        else {
            //Something wrong
            System.out.println("Something wrong!, NaN etc.");
            return -m;
        }
    }


    /*
    Binærsøk
    //Intervaller:
    // Halvåpent intervall:
    // [8, 10) => 8 9 => vanlig for-løkke: for(int i=8; i<10; ++i)
    // (8, 10] => 9, 10
    // Lukket intervall:
    // [8, 10] => 8, 9, 10 => "vanlig" for-løkke: for(int i=8; i<=10; ++i)

    //Søk etter 6
    //[ l                 r ]
    //[ a b c d e f g h i j ]
    //[ 0 1 2 3 4 5 6 7 8 9 ]
    // values.length = 10
    // l = 0 //left index 0
    // r = 9 //right index 9
    // m = (l+r) / 2 = (0 + 9) / 2 = 4 //middle
    //Tanke: (0.0 + 9.0) / 2 // OBS: Double promotering

    //Tegneserie
    //1
    //[ l       m         r ]
    //[ a b c d 9 f g h i j ]
    //[ 0 1 2 3 4 5 6 7 8 9 ]

    //2
    //[ l m   r             ]
    //[ a 2 c d 9 f g h i j ]
    //[ 0 1 2 3 4 5 6 7 8 9 ]

    //3
    //[     lm r             ]
    //[ a 2 5 d 9 f g h i j ]
    //[ 0 1 2 3 4 5 6 7 8 9 ]
    // (l+r)/2 => (3+2)/2 = 5/2 = 2

    //4
    //[       lr            ]
    //[ a 2 5 7 9 f g h i j ]
    //[ 0 1 2 3 4 5 6 7 8 9 ]

    // Fant tallet på 4 søk.

    */
    public static int binarySearch(int[] values, int search_value) {
        //Søk i intervallet [l, r]:
        int l = 0;
        int r = values.length - 1;
        int m = (l+r)/2;

        while (l <= r) {
            System.out.println("Sjekker intervallet [" + l + ", " + r + "]");
            m = (l+r)/2;
            //Hvis midt-verdien er større,
            //gå til venstre
            //[ l       m         r ]
            //[ a b c d 9 f g h i j ]
            if (values[m] > search_value) {
                //[ l     r             ]
                //[ a b c d 9 f g h i j ]
                r = m - 1;
            } else if (values[m] < search_value) {
                //[           l       r ]
                //[ a b c d 9 f g h i j ]
                l = m + 1;
            } else if (values[m] == search_value) {
                //Vi har funnet plassen til verdien.
                //eller NaN (f.eks. 9/0)
                return m;
            } else {
                System.out.println("Something wrong!");
            }
        }

        //Fant ikke verdien...
        return -l;
    }

    /**
     * Sorterer verdien in-place (OBS: rekkefølgen i values blir endret!)
     * @param values
     */
    public static void bubbleSort(int[] values) {
        //To for-løkker:
        // Ytre løkke: sorterer ett tall per gjennomgang
        for (int i=0; i < values.length - 1; ++i) {
            System.out.println("Array før sortering av index " + i);
            System.out.println(Arrays.toString(values));
            // indre løkke: "bobler opp" tall til riktig posisjon
            for (int j=values.length-1; j > i; j--) {
                //Sjekk om tall på posisjon j og (j-1) er sortert riktig
                if (values[j] < values[j-1]) {
                    System.out.println("Inversjon! Bytter plass på " + j + " og " + (j-1) );
                    int tmp = values[j];
                    values[j] = values[j-1];
                    values[j-1] = tmp;
                    System.out.println(Arrays.toString(values));
                }
            }
        }

        System.out.println("Sorterte verdier:");
        System.out.println(Arrays.toString(values));
    }

}
