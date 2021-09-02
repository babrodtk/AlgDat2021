package no.oslomet.cs.algdat;

public class TournamentTree {

    /**
     * A node in a tournament tree. Each node
     * has a "pointer" to its children.
     * A Java object is actually just a pointer to a memory address where the objects data lies.
     * This means that we can have an instantiated object of Node,
     * Node root = new Node('r');
     * This node, root, then is a pointer to a memory location. At this location, we will then find
     * the value 'r', and two more pointers: left_child and right_child.
     */
    public static class Node {
        char value;
        Node left_child;
        Node right_child;

        Node(char value) {
            this.value = value;
            this.left_child = null;
            this.right_child = null;
        }

        /**
         * This is a so-called recursive function that prints pre-order.
         * We will cover recursive functions and what pre-order means
         * later in the course. The print function ends up printing all
         * nodes in the binary tournament tree to screen.
         */
        void print() {
            System.out.print(value + ", ");
            if (this.left_child != null) {
                this.left_child.print();
            }
            if (this.right_child != null) {
                this.right_child.print();
            }
        }
    }

    /**
     * A function that plays a match between two teams, and
     * creates a parent node with the winner
     * @param team_1 First team to play
     * @param team_2 Second team to play
     * @return The winner, with the two teams (team_1, and team_2) as children
     */
    static Node playMatch(Node team_1, Node team_2) {
        /**
         * The following ternary if statment on line
         * 59 corresponds to the following code:
        char winner;
        if (team_1.value > team_2.value) {
            winner = team_1.value;
        }
        else {
            winner = team_2.value;
        }
         */
        char winner = (team_1.value > team_2.value) ? team_1.value : team_2.value;

        //Create the parent node, and set the pointers
        //to the children
        Node parent = new Node(winner);
        parent.left_child = team_1;
        parent.right_child = team_2;

        return parent;
    }

    public static void main(String[] args) {
        //Create the four teams that we want to play a tournament with
        Node z = new Node('Z');
        Node c = new Node('C');
        Node f = new Node('F');
        Node k = new Node('K');

        //Verdien av en char bestemmes av ASCII-tabellen.
        //f.eks. så er 'A' = 65, 'B' = 66, ... 'a' = ??

        //Play semi-finals, and store the winners
        Node semi_1 = playMatch(z, c);
        Node semi_2 = playMatch(f, k);

        //Play the final, and store the winner
        Node winner = playMatch(semi_1, semi_2);

        //Print out the tree
        System.out.println("Turneringstreet i pre-orden:");
        //Expected output: zzzckfk
        winner.print();
    }

}
