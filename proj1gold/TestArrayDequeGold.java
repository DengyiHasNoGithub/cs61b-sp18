import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void testStudent() {
        StudentArrayDeque<Integer> std = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sol = new ArrayDequeSolution<>();
        String message = "";
        for (int i = 0; i < 20; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                std.addLast(i);
                sol.addLast(i);
                message += "addLast(" + i + ")\n";
            } else {
                std.addFirst(i);
                sol.addFirst(i);
                message += "addFirst(" + i + ")\n";
            }

            Integer stdFirst = std.removeFirst();
            Integer solFirst = sol.removeFirst();

            if (stdFirst == null) {
                continue;
            }
            if (!stdFirst.equals(solFirst)) {
                message += "removeFirst()";
                assertEquals(message, solFirst, stdFirst);
            }

            std.addFirst(stdFirst);
            sol.addFirst(solFirst);

            Integer stdLast = std.removeLast();
            Integer solLast = sol.removeLast();

            if (stdLast == null) {
                continue;
            }
            if (!stdLast.equals(solLast)) {
                message += "removeLast()";
                assertEquals(message, solLast, stdLast);
            }
            std.addLast(stdLast);
            sol.addLast(solLast);
        }
    }

    /** This main method is optional. */
    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests(TestArrayDequeGold.class);
    }
}
