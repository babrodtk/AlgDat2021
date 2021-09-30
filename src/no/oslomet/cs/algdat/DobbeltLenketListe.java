package no.oslomet.cs.algdat;

public class DobbeltLenketListe {

    public static void main(String[] args) {
        DobbeltLenketListe values = new DobbeltLenketListe();

        values.add_first(3);
        values.print();
        //Forventer utskrift 3,

        values.add_first(1);
        values.print();
        //Forventer utskrift 1, 3,

        values.add_first(7);
        values.print();
        //Forventer utskrift 7, 1, 3

        values.add_last(9);
        values.print();
        //Forventer utskrift 7, 1, 3, 9

        values.insert(1, 8);
        values.print();
        //Forventer utskrift 7, 8, 1, 3, 9
    }

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

    public void print() {
        //Alternativ 1: skriv som for-løkke
        //[0, num_values)
        Node p = head;
        for (int i=0; i<num_values; ++i) {
            System.out.print(p.value + ", ");
            p = p.next;
        }
        System.out.println();

        //Alternativ 2: skriv som while-løkke
        Node q = head;
        while (q != null) {
            System.out.print(q.value + ", ");
            q = q.next;
        }
        System.out.println();
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
      //if (num_values == 0) {
            head = p;
            tail = p;
            num_values += 1;
        }
        //Generelt tilfelle: vi har noder allerede
        //i listen vår
        else {
            Node q = head;
            head = p;
            q.prev = p;
            p.next = q;
            num_values += 1;
        }

        return num_values;
    }

    /**
     * Add funksjon som legger til ved hale-enden
     * Synonymer: back, tail, ...
     */
    int add_last(int value) {
        Node q = new Node(value);

        if ( (head == null) && (tail == null) ) {
            head = q;
            tail = q;
            num_values += 1;
        }
        else {
            Node p = tail;
            tail = q;
            q.prev = p;
            p.next = q;
            num_values += 1;
        }

        return num_values;
    }

    /**
     * insert funksjon
     * Legger til ny node med index index
     */
    void insert(int index, int value) {
        if (index == 0) {
            //Spesialtilfelle!
            add_first(value);
        }
        else if (index == num_values-1) {
            //spesialtilfelle - add_last
            add_last(value);
        }
        else {
            Node q = new Node(value);

            //Finn de nodene vi skal sette inn p mellom
            //slik at vi får p - q - r i listen vår
            Node r = head;
            for (int i = 0; i < index; ++i) {
                r = r.next;
            }
            Node p = r.prev;

            p.next = q;
            q.next = r;
            q.prev = p;
            r.prev = q;

            num_values += 1;
        }
    }
}
