public class ArrayDeque<T> implements Deque<T> {

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

    /** public ArrayDeque(ArrayDeque other) {
        int len = other.items.length;
        items = (T[]) new Object[len];
        size = 0;

        for (int i = 0; i < other.size(); i += 1) {
            addLast((T) other.get(i));
        }
    } */

    /** Resize our backing array so that
     * it is of the given capacity.
     */
    private int minusOne(int index) {
        if (index == 0) {
            return (items.length - 1);
        } else {
            return (index - 1);
        }
    }

    private int addOne(int index) {
        if (index == items.length - 1) {
            return 0;
        } else {
            return (index + 1);
        }
    }
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        int pos = addOne(nextFirst);
        for (int j = 0; j < size; j++) {
            a[j] = items[pos];
            pos = addOne(pos);
        }
        items = a;
        nextFirst = capacity - 1;
        nextLast = capacity / 2;
    }

    @Override
    public void addFirst(T x) {
        if (size == items.length) {
            resize(size * RFACTOR);
        }
        items[nextFirst] = x;
        nextFirst = minusOne(nextFirst);
        size += 1;
    }


    @Override
    public void addLast(T x) {
        if (size == items.length) {
            resize(size * RFACTOR);
        }
        items[nextLast] = x;
        nextLast = addOne(nextLast);
        size += 1;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        int i = addOne(nextFirst);
        for (int j = 1; j <= size; j++) {
            System.out.print(items[i] + " ");
            i = addOne(i);
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size <= 0.25 * items.length && items.length >= 16) {
            resize(size * RFACTOR);
        }

        if (isEmpty()) {
            return null;
        }

        int i = addOne(nextFirst);

        T temp = items[i];
        items[i] = null;

        nextFirst = i;
        size -= 1;
        return temp;
    }

    @Override
    public T removeLast() {
        if (size <= 0.25 * items.length && items.length >= 16) {
            resize(size * RFACTOR);
        }

        if (size == 0) {
            return null;
        }

        int i = minusOne(nextLast);

        T temp = items[i];
        items[i] = null;

        nextLast = i;
        size -= 1;
        return temp;
    }

    @Override
    public T get(int index) {
        int i = addOne(nextFirst);
        for (int j = 0; j < index; j++) {
            i = addOne(i);
        }
        return items[i];
    }
}
