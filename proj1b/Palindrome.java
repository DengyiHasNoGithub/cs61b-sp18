public class Palindrome {

    /** Creates a deque where the characters appear in the same
     *  order as in word. */
    public Deque<Character> wordToDeque(String word) {
        Deque result = new LinkedListDeque();
        int len = word.length();
        for (int i = 0; i < len; i++) {
            char ichar = word.charAt(i);
            result.addLast(ichar);
        }
        return result;
    }

    /** Helper method to return string with the first
     *  and last character removed.
     */
    private String dequeToWord(Deque<Character> deque) {
        String result = "";
        int len = deque.size();
        for (int i = 0; i < len; i++) {
            char ichar = deque.removeFirst();
            result += ichar;
        }
        return result;
    }

    /** Decides whether a word is palindrome. */
    public boolean isPalindrome(String word) {
        int len = word.length();
        if (len == 0 || len == 1) {
            return true;
        } else {
            Deque<Character> dqword = wordToDeque(word);
            char a = dqword.removeFirst();
            char b = dqword.removeLast();
            if (a != b) {
                return false;
            }
            String newword = dequeToWord(dqword);
            return isPalindrome(newword);
        }
    }

    /** Decides whether a word is palindrome decided by OffByOne. */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        int len = word.length();
        if (len == 0 || len == 1) {
            return true;
        } else {
            Deque<Character> dqword = wordToDeque(word);
            char x = dqword.removeFirst();
            char y = dqword.removeLast();
            if (!cc.equalChars(x, y)) {
                return false;
            }
            String newword = dequeToWord(dqword);
            return isPalindrome(newword, cc);
        }
    }
}
