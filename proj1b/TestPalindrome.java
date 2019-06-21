import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        boolean a = palindrome.isPalindrome("persiflage");
        assertFalse(a);
        boolean b = palindrome.isPalindrome("a");
        assertTrue(b);
    }

    @Test
    public void testIsPalindrome2() {
        CharacterComparator obo = new OffByOne();
        boolean a = palindrome.isPalindrome("flake", obo);
        assertTrue(a);
        boolean b = palindrome.isPalindrome("dengyi", obo);
        assertFalse(b);
    }
}
