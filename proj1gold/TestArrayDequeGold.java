import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void testStudent() {
        StudentArrayDeque<Integer> std = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sol = new ArrayDequeSolution<>();
        String message = "";
        for (int i = 0; i < 10; i += 1) {
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
            if (!stdFirst.equals(solFirst)) {
                message += "removeFirst()";
                assertEquals(message, solFirst, stdFirst);
                return;
            }
            std.addFirst(stdFirst);
            sol.addFirst(solFirst);
            Integer stdLast = std.removeLast();
            Integer solLast = sol.removeLast();
            if (!stdLast.equals(solLast)) {
                message += "removeLast()";
                assertEquals(message, solLast, stdLast);
                return;
            }
            std.addLast(stdLast);
            sol.addLast(solLast);
        }
    }
}
