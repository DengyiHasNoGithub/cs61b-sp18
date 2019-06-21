public class OffByN implements CharacterComparator {
    private int num;

    /** Constructor for OffByN. */
    public OffByN(int N) {
        num = N;
    }

    /** Returns true for characters that are different by exactly N. */
    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        return (diff == num || diff == -num);
    }
}
