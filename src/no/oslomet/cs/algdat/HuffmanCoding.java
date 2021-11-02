package no.oslomet.cs.algdat;

import java.util.PriorityQueue;

public class HuffmanCoding {

    public static void main(String[] args) {
        char[] symbols = {'E', 'T', 'I', 'A', 'N'};
        double[] frequencies = { 0.4, 0.3, 0.1, 0.167, 0.033 };

        //Gjør om dette arrayet til en prioritetskø
        // 1. Noder med lav frekvens har høy prioritet
        PriorityQueue<Node> priority_queue = new PriorityQueue<>();

        //Legg inn alle noder i køen
        for (int i=0; i<symbols.length; ++i) {
            priority_queue.add(new Node(symbols[i], frequencies[i]));
        }

        //Grupper nodene for å lage huffman-treet
        while (priority_queue.size() > 1) {
            //Ta ut de to nodene med lavest frekvens.
            Node a = priority_queue.remove();
            Node b = priority_queue.remove();

            //Lag ny node som har summen av frekvensen til barne-nodene a og b
            Node c = new Node(a, b);

            //Legg den nye noden inn i køen
            priority_queue.add(c);
        }

        //Skriv ut treet i pre orden rekkefølge
        Node root = priority_queue.remove();

        //Lag det kanoniske huffman treet

        //Lag bit-kodene
        //Lag en rekursiv metode som går gjennom treet
        //fra root, og legger 0 til venstre og 1 til høyre for hver
        //forgrening
        root.makeBitCodes("");

        //Skriv ut bit-kodene
        System.out.println(root);
    }

    public static
    class Node implements Comparable<Node> {
        char symbol;
        String bit_code;
        double frequency;
        Node left_child;
        Node right_child;

        Node(Node left_child, Node right_child) {
            this.symbol = ' ';
            this.bit_code = "";
            this.frequency = left_child.frequency + right_child.frequency;
            this.left_child = left_child;
            this.right_child = right_child;
        }

        Node(char symbol, double frequency) {
            this.symbol = symbol;
            this.bit_code = "";
            this.frequency = frequency;
            this.left_child = null;
            this.right_child = null;
        }

        public void makeBitCodes(String bit_code) {
            //Rekursiv metode:
            //1 - kaller oss selv
            //2 - Basistilfelle
            //3 - Forenkling

            this.bit_code = bit_code;
            if (this.left_child != null) {
                this.left_child.makeBitCodes(bit_code + "0");
            }
            if (this.right_child != null) {
                this.right_child.makeBitCodes(bit_code + "1");
            }
        }

        public int compareTo(Node other) {
            return Double.compare(this.frequency, other.frequency);
        }

        public String toString() {
            String retval = "";
            //Sjekk at vi er en bladnode
            if (this.left_child == null && this.right_child == null) {
                retval += this.symbol + ": " + this.bit_code + "\n";
            }
            if (this.left_child != null) {
                retval += this.left_child.toString();
            }
            if (this.right_child != null) {
                retval += this.right_child.toString();
            }
            return retval;
        }
    }

}
