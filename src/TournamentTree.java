public class TournamentTree {

    /**
     * A node in a tournament tree. Each node
     * has a "pointer" to its children.
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

        void print() {
            System.out.print(value + ", ");
        }
    }

    static Node playMatch(Node team_1, Node team_2) {

        char winner;
        if (team_1.value > team_2.value) {
            winner = team_1.value;
        }
        else {
            winner = team_2.value;
        }

        Node parent = new Node(winner);
        parent.left_child = team_1;
        parent.right_child = team_2;

        return parent;
    }

    public static void main(String[] args) {
        Node z = new Node('Z');
        Node c = new Node('C');
        Node f = new Node('F');
        Node k = new Node('K');

        //Verdien av en char bestemmes av ASCII-tabellen.
        //f.eks. så er 'A' = 65, 'B' = 66, ... 'a' = ??

        Node semi_1 = playMatch(z, c);
        Node semi_2 = playMatch(f, k);
        System.out.println("Semifinalevinnere:");
        semi_1.print();
        semi_2.print();

        Node winner = playMatch(semi_1, semi_2);
        System.out.println("Vinner av match");
        winner.print();
    }

}
