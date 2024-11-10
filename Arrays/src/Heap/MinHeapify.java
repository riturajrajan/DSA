package Heap;

import java.util.Arrays;

public class MinHeapify {
    //So Heap are like array but if we want to think of a tree then Heap in a complete tree which is added in array and this array is Heap and second point is the parent node
    //is always smaller than the child nodes or subtree. Here we will find the min of parent node, right and left node. If parent is the smallest then we will not do anything
    //but if left or right is smallest then we need to swap with parent node. Call this recursively for the smallest nde
    public static void main(String[] args) {
        Heap minHeap = new Heap(10);
        minHeap.heap[0] = 40;
        minHeap.heap[1] = 20;
        minHeap.heap[2] = 30;
        minHeap.heap[3] = 35;
        minHeap.heap[4] = 25;
        minHeap.heap[5] = 80;
        minHeap.heap[6] = 32;
        minHeap.heap[7] = 100;
        minHeap.heap[8] = 70;
        minHeap.heap[9] = 60;
        minHeapify(0, minHeap);
        Arrays.stream(minHeap.heap).forEach(key -> System.out.println(key));
    }

    public static void minHeapify(int node, Heap minHeap) {
        int smallest = node;
        int left = minHeap.getLeft(node), right = minHeap.getRight(node);
        if(left < minHeap.size && minHeap.heap[smallest] > minHeap.heap[left]) {
            smallest = left;
        }
        if(right < minHeap.size && minHeap.heap[smallest] > minHeap.heap[right]) {
            smallest = right;
        }
        if(smallest != node) {
            int temp = minHeap.heap[node];
            minHeap.heap[node] = minHeap.heap[smallest];
            minHeap.heap[smallest] = temp;
            minHeapify(smallest, minHeap);
        }
    }
}
