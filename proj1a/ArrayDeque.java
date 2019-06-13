public class ArrayDeque<T> {

    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] items;

    private static int RFACTOR = 2;

    public ArrayDeque() {
        items = (T []) new Object[8];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

    public ArrayDeque(ArrayDeque other) {
        int len = other.items.length;
        items = (T[]) new Object[len];
        size = 0;

        for (int i = 0; i < other.size(); i += 1) {
            addLast((T) other.get(i));
        }
    }

    /** Resize our backing array so that
     * it is of the given capacity.
     */
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void addFirst(T x) {
        if (size == items.length) {
            resize(size * RFACTOR);
        }
        items[nextFirst] = x;
        if (nextFirst == 0) {
            nextFirst = items.length - 1;
        } else {
            nextFirst -= 1;
        }
        size += 1;
    }


    public void addLast(T x) {
        if (size == items.length) {
            resize(size * RFACTOR);
        }
        items[nextLast] = x;
        if (nextLast == items.length - 1) {
            nextLast = 0;
        } else {
            nextLast += 1;
        }
        size += 1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int i;
        if (nextFirst == items.length - 1) {
            i = 0;
        } else {
            i = nextFirst + 1;
        }
        for (int j = 1; j <= size; j++) {
            System.out.print(items[i] + " ");
            if (i == items.length - 1) {
                i = 0;
            } else {
                i += 1;
            }
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size >= 0.25 * items.length) {
            resize(size * RFACTOR);
        }
        int i;
        if (nextFirst == items.length - 1) {
            i = 0;
        } else {
            i = nextFirst + 1;
        }

        T temp = items[i];
        items[i] = null;

        nextFirst = i;

        size -= 1;
        return temp;
    }

    public T removeLast() {
        if (size >= 0.25 * items.length) {
            resize(size * RFACTOR);
        }
        int i;
        if (nextLast == 0) {
            i = items.length - 1;
        } else {
            i = nextLast - 1;
        }

        T temp = items[i];
        items[i] = null;

        nextLast = i;

        size -= 1;
        return temp;
    }

    public T get(int index) {
        return items[index];
    }
}
