public class LinkedListDeque<T> {

    public class Node {
        private T item;
        private Node prev;
        private Node next;

        public Node(T i) {
            item = i;
        }

        public Node(Node m, T i, Node n) {
            item = i;
            prev = m;
            next = n;
        }
    }

    /* The first item (if it exists) is at sentinel.next. */
    private Node sentinel;
    private int size;

    /** Creates an empty list. */
    public LinkedListDeque() {
        sentinel = new Node(null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /** Creates a deep copy of other. */
    /** public LinkedListDeque(LinkedListDeque other) {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
        
        for (int i = 0; i < other.size; i++) {
            addLast((T) other.get(i));
        }
    }*/

    /** Helper for creating a deep copy. */
    private LinkedListDeque copy(LinkedListDeque other) {
        LinkedListDeque result = new LinkedListDeque();
        for (int i = 1; i <= other.size; i++) {
            result.addLast(other.get(i));
        }
        return result;
    }

    /** Adds x to the front of the list. */
    public void addFirst(T x) {
        Node newnode = new Node(sentinel, x, sentinel.next);
        sentinel.next = newnode;
        newnode.next.prev = newnode;
        size += 1;
    }

    /** Add x to the end of the list. */
    public void addLast(T x) {
        Node newnode = new Node(sentinel.prev, x, sentinel);
        sentinel.prev = newnode;
        if (sentinel.prev.prev == sentinel) {
            sentinel.next = newnode;
        }
        sentinel.prev.prev.next = newnode;
        size += 1;
    }

    /** Returns true if the deque is empty, false otherwise. */
    public boolean isEmpty() {
        return (size == 0);
    }

    /** Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last. */
    public void printDeque() {
        Node currentNode = sentinel.next;
        for (int i = 1; i <= size; i++) {

            System.out.print(currentNode.item + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    /** Removes and return the item at the front of the deque. */
    public T removeFirst() {
        if (sentinel.prev == null) {
            return null;
        }
        T temp = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return temp;
    }

    /** Removes and returns the items at the back of the deque. */
    public T removeLast() {
        if (sentinel.prev == null) {
            return null;
        }
        T temp = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return temp;
    }

    /** Gets the items at the given index. */
    public T get(int index) {
        int iindex = 0;
        Node currentnode = sentinel;
        while (iindex < index) {
            if (currentnode.next == sentinel) {
                return null;
            }
            currentnode = currentnode.next;
            iindex += 1;
        }
        return currentnode.item;
    }

    /** Gets the items at the given index using recursion. */
    public T getRecursive(int index) {
        if (index == 0) {
            return sentinel.next.item;
        }
        LinkedListDeque copyD = copy(this);
        copyD.removeFirst();
        return (T) copyD.getRecursive(index - 1);
    }
}
