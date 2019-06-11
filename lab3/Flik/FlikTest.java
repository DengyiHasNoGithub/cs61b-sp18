import static org.junit.Assert.*;

import org.junit.Test;

public class FlikTest {

    @Test(timeout = 1000)
    public void testIsSameNumber() {
        assertTrue(Flik.isSameNumber(128,128));
        assertFalse(Flik.isSameNumber(5,8));
    }

    /** Run the unit test in the file. */

    public static void main(String... args) {
        jh61b.junit.TestRunner.runTests("all", FlikTest.class);
    }
}