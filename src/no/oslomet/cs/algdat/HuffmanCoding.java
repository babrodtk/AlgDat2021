package no.oslomet.cs.algdat;

public class HuffmanCoding {

    public static void main(String[] args) {
        char[] symbols = {'E', 'T', 'I', 'A', 'N'};
        double[] frequencies = { 0.4, 0.3, 0.1, 0.167, 0.033 };

        //Gjør om dette arrayet til en prioritetskø
        // 1. Noder med lav frekvens har høy prioritet
        Node[] priority_queue = new Node[symbols.length];

        //Legg inn alle noder i køen
        for (int i=0; i<symbols.length; ++i) {
            priority_queue[i] = new Node(symbols[i], frequencies[i]);
        }

        while (!priority_queue.empty()) {
            //Ta ut de to nodene med lavest frekvens.
            Node a = priority_queue.pop();
            Node b = priority_queue.pop();

            Node c = new Node(a, b);

            priority_queue.push(c);
        }

        for (int i=0; i<symbols.length; ++i) {
            priority_queue[i].print();
        }
    }

    public static
    class Node {
        char symbol;
        double frequency;
        Node left_child;
        Node right_child;

        Node(Node left_child, Node right_child) {
            this.symbol = ' ';
            this.frequency = left_child.frequency + right_child.frequency;
            this.left_child = left_child;
            this.right_child = right_child;
        }

        Node(char symbol, double frequency) {
            this.symbol = symbol;
            this.frequency = frequency;
        }

        void print() {
            System.out.println(this.symbol + ": " + this.frequency);
        }
    }

}
