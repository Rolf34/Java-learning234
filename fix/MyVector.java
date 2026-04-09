package main;

public class MyVector {

    private int[] data;
    private int size;

    public MyVector() {
        this.data = new int[4];
        this.size = 0;
    }

    public MyVector(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Ємність має бути більше нуля");
        }
        this.data = new int[initialCapacity];
        this.size = 0;
    }

    private void grow() {
        int newCapacity = data.length * 2;
        int[] newData = new int[newCapacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    public void addLast(int value) {
        if (size == data.length) {
            grow();
        }
        data[size++] = value;
    }

    public void addMiddle(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Індекс " + index + " виходить за межі");
        }
        if (size == data.length) {
            grow();
        }
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = value;
        size++;
    }

    public void addFirst(int value) {
        addMiddle(0, value);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Індекс " + index + " виходить за межі. Size=" + size);
        }
        return data[index];
    }

    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Індекс " + index + " виходить за межі");
        }
        int removed = data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
        if (size > 0 && size <= data.length / 4 && data.length > 4) {
            int newCapacity = data.length / 2;
            int[] newData = new int[newCapacity];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
        return removed;
    }

    public void clear() {
        data = new int[4];
        size = 0;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return data.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
