import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testEqualChars() {
        boolean s1 = offByOne.equalChars('w', 'x');
        assertTrue(s1);
        boolean s2 = offByOne.equalChars('&', '%');
        assertTrue(s2);
        boolean s3 = offByOne.equalChars('a', 'c');
        assertFalse(s3);
        boolean s4 = offByOne.equalChars('x', 'w');
        assertTrue(s4);
        boolean s5 = offByOne.equalChars('A', 'B');
        assertTrue(s5);
    }
}
