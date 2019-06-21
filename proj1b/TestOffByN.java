import org.junit.Test;
import static org.junit.Assert.*;


public class TestOffByN {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offBy5 = new OffByN(5);

    @Test
    public void testEqualChars() {
        boolean s1 = offBy5.equalChars('a', 'h');
        assertFalse(s1);
        boolean s2 = offBy5.equalChars('a', 'f');
        assertTrue(s2);
    }
}
