package no.oslomet.cs.algdat;

import java.util.Stack;

public class FactorialTest {

    public static void main(String[] args) {
        System.out.println("Tester factorial funksjonen.");
        System.out.println("5!=" + fakultet(5));
        System.out.println("5!=" + stackBasedFactorial(5));
    }

    /**
     * n! (n fakultet) = n * (n-1) * (n-2) * ... * 1
     * fakultet(5) = 5*fakultet(4)
     * fakultet(4) = 4*fakultet(3)
     * ..
     * fakultet(1) = 1
     */
    public static
    int fakultet(int n) {
        //1 - Basistilfelle! Slutte rekursjon
        //2 - Forenkling av argumenter (gå mot et basistilfelle)
        //3 - Kalle på seg selv

        if (n == 1) {
            return 1;
        }
        else {
            return n * fakultet(n-1);
        }
    }

    /**
     * (n) * (n-1) * (n-2) * ... * 1
     * @param n
     * @return
     */
    public static
    int stackBasedFactorial(int n) {
        //Vi trenger comparable-interface,
        //derfor Integer og ikke int.
        Stack<Integer> factorial_stack = new Stack<Integer>();

        int result = 1;
        //push, add, addHead, ...
        factorial_stack.push(n);
        while (!factorial_stack.isEmpty()) {
            Integer current = factorial_stack.pop();
            result = result * current;
            if (n > 1) {
                n = n-1;
                factorial_stack.push(n);
            }
        }
        return result;

        /* Ikke lov nå:
        int result = 1;
        for (int i=1; i<=n; ++i) {
            result = result * n;
        }
        return result;
         */
    }
}
