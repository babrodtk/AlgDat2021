package no.oslomet.cs.algdat;

public class BinarySearchTree {

    public static void main(String[] args) {
        System.out.println("Hello world!!!");

        BST tree = new BST();

        int[] values = { 9, 7, 1, 3, 5, 11, 13, 10, 8 };

        //Test utskrift av treet
        for (int i=0; i<values.length; ++i) {
            tree.insert(values[i]);
            tree.print();
            System.out.println(" ");
        }

        //Test at vi kan finne noder
        System.out.println(tree.search(19));
        System.out.println(tree.search(8));
    }

    /**
     * Node-klasse som har alt vi trenger for hver eneste node i det
     * binære søketreet.
     */
    public static
    class Node {
        Node parent;
        Node left_child;
        Node right_child;
        int value;

        Node() {
            //parent == null, left_child == null, right_child == null, value == 0
        }

        /**
         * Lager en node med null som foreldre og barne-pekere
         * @param value
         */
        Node(int value) {
            this.value = value;
            this.parent = null;
            this.left_child = null;
            this.right_child = null;
        }

        Node(int value, Node parent) {
            this.value = value;
            this.parent = parent;
            this.left_child = null;
            this.right_child = null;
        }

        Node(int value, Node parent, Node left_child, Node right_child) {
            this.value = value;
            this.parent = parent;
            this.left_child = left_child;
            this.right_child = right_child;
        }

        void printPreorderRecursive() {
            System.out.print(this.value + ", ");
            if (left_child != null) {
                left_child.printPreorderRecursive();
            }
            if (right_child != null) {
                right_child.printPreorderRecursive();
            }
        }
    }

    /**
     * Binary search tree (BST)-klasse som har rot-noden og annen info
     * om vårt søketre. Har også metoden for innlegging, fjerning, søking, etc
     */
    public static
    class BST {
        Node root;

        /**
         * Denne funksjonen søker etter verdien i søketreet,
         * men returnerer null om verdien ikke finnes.
         * @param value
         * @return
         */
        Node search(int value) {
            Node p = root;

            //Inntil vi er utenfor treet, eller har funnet verdien vår
            while (p != null && p.value != value) {
                //Verdien er større enn p => gå til høyre
                if (value > p.value) {
                    p = p.right_child;
                }
                //Verdien er mindre enn p => gå til venstre
                else if (value < p.value) {
                    p = p.left_child;
                }
                //Verdien er lik p => returner.
                else {
                    break;
                }
            }

            return p;
        }

        void insert(int value) {
            //Treet vårt er tomt, vi lager første node!
            if (root == null) {
                root = new Node(value);
                return;
            }
            //Treet er ikke tomt => vi må legge inn verdien på riktig plass
            else {
                //Initialiser og sett noden vi ser på (p) til rot-noden
                Node p = root;
                Node q = null; //Parent til p

                while (p != null) {
                    q = p; // oppdater at nåværende p blir nye p sin forelder
                    if (value >= p.value) {
                        //Flytt p ett hakk nedover
                        p = p.right_child;
                    } else {
                        //Flytt p ett hakk nedover.
                        p = p.left_child;
                    }
                }

                //Nå har vi funnet hvor den nye noden skal ligge!
                //nye noden skal være høyre eller venstre barn av q.
                if (value >= q.value) {
                    q.right_child = new Node(value, q);
                } else {
                    q.left_child = new Node(value, q);
                }
            }
        }

        public void print() {
            this.root.printPreorderRecursive();
        }

    }
}
