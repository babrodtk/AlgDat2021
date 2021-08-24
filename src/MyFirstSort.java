public class MyFirstSort {

    public static void main(String[] args) {
        System.out.println("Hello algdat");

        int values[] = {1, 7, 2, 4, 6, 9};

        for (int k=0; k<values.length-1; ++k) {
            //Sjekk at vi får fornuftig svar for *ett* tilfelle.
            //Vi må utføre ordentlig testing før vi
            //faktisk kan stole på kildekoden vår
            int max_index = findMax(values, k, values.length);
            System.out.println("Største verdi ligger på plass "
                    + max_index + " og har verdi " + values[max_index]);

            //Bytte plass på tall på plass 0 og max_index
            int temp = values[k];
            values[k] = values[max_index];
            values[max_index] = temp;

            System.out.println("Bytter plass " + k + " med plass " + max_index);
            System.out.println("Arrayet etter ombytting");
            for (int i = 0; i < values.length; ++i) {
                System.out.print(values[i] + ", ");
            }
            System.out.println();
        }
    }

    /**
     * Findmax - finner index til største tall i et array,
     * men søker bare innenfor tallene i [fra, til)
     */
    public static int findMax(int[] values, int fra, int til) {
        //Initialiser ved å se på første "kort"
        //Dette er det største tallet jeg har funnet
        //så langt
        int index = fra;
        int max_value = values[fra];

        //Sjekk at grensene for løkken er riktig.
        // [1, values.length)
        for (int i=fra+1; i<til; ++i) {
            //Sjekk om vi har funnet nytt største tall
            if (values[i] > max_value) {
                max_value = values[i];
                index = i;
            }
        }

        return index;
    }
}
