package no.oslomet.cs.algdat;

public class BinarySearchTree {

    public static void main(String[] args) {
        System.out.println("Hello world!!!");
    }

    /**
     * Node-klasse som har alt vi trenger for hver eneste node i det
     * binære søketreet.
     */
    class Node {
        Node parent;
        Node left_child;
        Node right_child;
        int value;

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
    }

    /**
     * Binary search tree (BST)-klasse som har rot-noden og annen info
     * om vårt søketre. Har også metoden for innlegging, fjerning, søking, etc
     */
    class BST {
        Node root;

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
                }
                else {
                    q.left_child = new Node(value, q);
                }
            }
        }
    }
}
