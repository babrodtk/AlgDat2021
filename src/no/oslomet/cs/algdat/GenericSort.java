package no.oslomet.cs.algdat;

import java.util.Arrays;

public class GenericSort {

    /**
     * En klasse som implmenterer "Comparable"
     */
    public static class Person implements Comparable<Person> {
        //En person har fornavn og etternavn
        String first_name;
        String last_name;

        //Konstruktør
        Person(String first_name, String last_name) {
            this.first_name = first_name;
            this.last_name = last_name;
        }

        //"implements Comparable" krever at vi har denne funksjonen.
        //Kort sagt returnerer funksjonen som følger
        //-1 if this < other
        // 0 if this == other
        // 1 if this > other
        public int compareTo(Person other) {
            //Sjekk om this.last_name > other.last_name
            int last_name_compare = this.last_name.compareTo(other.last_name);
            //Samme etternavn
            if (last_name_compare == 0) {
                //Hvis vi har samme etternavn, sammenlikn fornavnet
                return this.first_name.compareTo(other.first_name);
            }
            //Forskjellig etternavn, returner sammenlikning av etternavnet
            else {
                return last_name_compare;
            }
        }

        //Hjelpefunksjon for å skrive ut til skjerm
        public String toString() {
            return last_name + "-" + first_name;
        }
    }

    public static void main(String[] args) {
        int my_value = 5;
        pass_by_value(my_value);
        System.out.println("Pass by value test: " + my_value);
        //Klassen forventer: 5: 29%, 7: 64%, vet ikke: 7%

        int[] my_value_array = {5};
        pass_by_reference(my_value_array);
        System.out.println("Pass by reference test: " + Arrays.toString(my_value_array));
        //Klassen forventer: 5: 17%, 9: 79%, vet ikke: 4%

        //int => rå datatype, ikke klasse og har ikke Comparable eller compareTo-funksjonen!
        //Integer => java-klasse som implements Comparable
        Integer[] values = {1, 9, 2, 8, 6, 4, 7, 3};
        System.out.println("Verdier før sortering: " + Arrays.toString(values));
        sort(values);
        System.out.println("Verdier etter sortering: " + Arrays.toString(values));

        //Husk, vi sammenlikner ascii-verdier slik at Z < a
        Character[] char_values = {'a', 'c', '2', 'K', 'k', 'u', '4', 'A'};
        System.out.println("Verdier før sortering: " + Arrays.toString(char_values));
        sort(char_values);
        System.out.println("Verdier etter sortering: " + Arrays.toString(char_values));

        //Test vår egen klasse som implementerer Comparable
        Person[] persons = {
                new Person("Anne", "Pettersen"),
                new Person("Berit", "Pettersen"),
                new Person("Zaed", "Ali"),
                new Person("Jarle", "Ali")
        };
        System.out.println("Verdier før sortering: " + Arrays.toString(persons));
        sort(persons);
        System.out.println("Verdier etter sortering: " + Arrays.toString(persons));
    }

    public static
    <T extends Comparable<? super T>>
    void sort(T[] values) {
        //Vi skal sortere n-1 tall, siden siste tall alltid er sortert riktig
        for (int i=0; i<values.length-1; ++i) {
            //Finn indeks til største tall i intervallet [i, n)
            int max_index = max_value(values, i, values.length);

            //Bytt tallet på plass max_index, med plass i
            T tmp = values[i];
            values[i] = values[max_index];
            values[max_index] = tmp;
        }
    }


    /**
     * Denne funksjonen finner indeksen til største heltall
     * innenfor intervallet [begin, end)
     */
    public // Denne funksjonen synes for hele verden. Alternativt private
    static // Trenger ikke GenericSort gs = new GenericSort() for å bruke funksjonen.
    <T extends Comparable<? super T>> // Denne funksjonen bruker T som en generisk type - men den må implementere Comparable!
    int // Vi returnerer ett heltall => indeksen der vi har største verdi
    max_value(T[] values, int begin, int end) {
        // Se på første verdi - det er det største tallet vi har sett så langt.
        T current_max = values[begin];
        int current_max_index = begin;

        // Se gjennom alle andre verdier i [begin+1, end) og finn største av alle
        for (int i=begin+1; i<end; ++i) {
            // ikke sikkert at T har operatoren <, >, ==, !=, ..., +, -,
            //if (values[i] > current_max) {
            /**
             * Vi bruker funksjonen compareTo som ligger i Comparable interfacet.
             * a.compareTo(b) > 0 <=> (a > b) == true
             * a.compareTo(b) < 0 <=> (a < b) == true
             * a.compareTo(b) == 0 <=> (a == b) == true
             */
            if (values[i].compareTo(current_max) > 0) {
                current_max = values[i];
                current_max_index = i;
            }
        }
        return current_max_index;
    }

    //Pass by value: ting kopieres inn i funksjonen.
    public static void pass_by_value(int value) {
        value = value + 2;
    }

    //Pass by reference: vi sender en peker til det faktiske objektet.
    public static void pass_by_reference(int[] value) {
        value[0] = value[0] + 4;
    }

}
