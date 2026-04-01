package main;

public class MyVector {

    private VectorNode head;
    private VectorNode current;
    private int size;
    private int capacity;
    private int blockCapacity;

    public MyVector() {
        this.blockCapacity = 4;
        this.head = new VectorNode(blockCapacity);
        this.current = head;
        this.size = 0;
        this.capacity = blockCapacity;
    }

    public MyVector(int blockCapacity) {
        this.blockCapacity = blockCapacity;
        this.head = new VectorNode(blockCapacity);
        this.current = head;
        this.size = 0;
        this.capacity = blockCapacity;
    }

    private VectorNode getNodeAt(int globalIndex) {
        VectorNode node = head;
        int passed = 0;
        while (node != null) {
            if (globalIndex < passed + blockCapacity) {
                return node;
            }
            passed += blockCapacity;
            node = node.next;
        }
        return null;
    }

    private int localIndex(int globalIndex) {
        return globalIndex % blockCapacity;
    }

    private void addNewBlock() {
        VectorNode newNode = new VectorNode(blockCapacity);
        newNode.prev = current;
        current.next = newNode;
        current = newNode;
        capacity += blockCapacity;
    }

    public void addLast(int value) {
        if (size == capacity) {
            addNewBlock();
        }
        int localIdx = size % blockCapacity;
        VectorNode node = getNodeAt(size);
        node.data[localIdx] = value;
        size++;
    }

    public void addMiddle(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Індекс " + index + " виходить за межі");
        }
        if (index == size) {
            addLast(value);
            return;
        }
        if (size == capacity) {
            addNewBlock();
        }
        for (int i = size; i > index; i--) {
            int val = getElement(i - 1);
            setElement(i, val);
        }
        setElement(index, value);
        size++;
    }

    public void addFirst(int value) {
        addMiddle(0, value);
    }

    private int getElement(int globalIndex) {
        VectorNode node = getNodeAt(globalIndex);
        return node.data[localIndex(globalIndex)];
    }

    private void setElement(int globalIndex, int value) {
        if (globalIndex == capacity) {
            addNewBlock();
        }
        VectorNode node = getNodeAt(globalIndex);
        node.data[localIndex(globalIndex)] = value;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Індекс " + index + " виходить за межі. Size=" + size);
        }
        return getElement(index);
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Індекс " + index + " виходить за межі");
        }
        int removed = getElement(index);
        for (int i = index; i < size - 1; i++) {
            setElement(i, getElement(i + 1));
        }
        size--;
        if (size > 0 && size % blockCapacity == 0 && current != head) {
            VectorNode prev = current.prev;
            prev.next = null;
            current = prev;
            capacity -= blockCapacity;
        }
        return removed;
    }

    public void clear() {
        head = new VectorNode(blockCapacity);
        current = head;
        size = 0;
        capacity = blockCapacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(getElement(i));
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
