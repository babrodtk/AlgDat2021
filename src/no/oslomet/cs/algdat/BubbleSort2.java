package no.oslomet.cs.algdat;

import java.util.Arrays;

public class BubbleSort2
{

    public static void main(String[]strings) {
        int [] values = {5, 6, 9, 2, 8, 3, 1, 10, 32, 4, 7, 14, 17, 18, 13};

        bubbleSort(values);

        System.out.println(Arrays.toString(values));


    }

    public static void binarySearch(int[] values, int search_value) {
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
