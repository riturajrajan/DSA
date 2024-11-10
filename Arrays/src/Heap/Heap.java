package Heap;

public class Heap {
    int[] heap;
    int size;

    public Heap(int size) {
        this.heap = new int[size];
        this.size = size;
    }

    public int getLeft(int node) {
        return 2 * node + 1;
    }

    public int getRight(int node) {
        return 2 * node + 2;
    }

    public int getParent(int node) {
        return Math.abs((node - 1) / 2);
    }
}
