
package main;

public class VectorNode {

    int[] data;
    VectorNode next;
    VectorNode prev;

    public VectorNode(int capacity) {
        this.data = new int[capacity];
        this.next = null;
        this.prev = null;
    }
}
