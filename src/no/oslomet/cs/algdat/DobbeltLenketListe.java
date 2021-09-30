package no.oslomet.cs.algdat;

public class DobbeltLenketListe {

    /**
     * Representasjon av en node i en dobbelt lenket
     * liste
     *
     */
    static class Node {
        int value; //Verdien vi vil lagre. Burde brukt generics
        Node next; //Peker til neste node eller null
        Node prev; //Peker til forrige node eller null

        Node(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }

        Node(int value, Node prev, Node next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    //Variabler i klassen min
    Node head; //Peker til første node i den lenkede listen
    Node tail; //Peker til siste node i den lenkede listen
    int num_values; //Antall verdier i den lenkede listen

    /**
     * Konstruktør
     */
    DobbeltLenketListe() {
            this.head = null;
            this.tail = null;
            this.num_values = 0;
    }

    /**
     * Add funksjon som legger til ved hode-enden
     * av den dobbelt lenkede listen. Synonymer er:
     * head, front, ..
     * @return Antall verdier vi har i listen etter
     *         innlegging
     */
    int add_first(int value) {
        Node p = new Node(value);

        //Spesialtilfelle: Vi har tom liste!
        //head == null
        //tail == null
        if ( (head == null) && (tail == null) ) {
            head = p;
            tail = p;
            num_values += 1;
        }

        return num_values;
    }

    /**
     * Add funksjon som legger til ved hale-enden
     * Synonymer: back, tail, ...
     */
    void add_last() {

    }

    /**
     * insert funksjon
     */
    void insert() {
        //???
    }
}
