package Heap;

public class ExtractMin {
    public static void main(String[] args) {
        //We know from the property of heap that arr[0] always contains the min element in the heap. So, to achieve this we need to swap last element with first
        //element and after doing this we need to call minHeapify function to place the element in correct position.
        Heap minHeap = new Heap(10);
        minHeap.heap[0] = 20;
        minHeap.heap[1] = 25;
        minHeap.heap[2] = 30;
        minHeap.heap[3] = 35;
        minHeap.heap[4] = 40;
        minHeap.heap[5] = 80;
        minHeap.heap[6] = 32;
        minHeap.heap[7] = 100;
        minHeap.heap[8] = 70;
        minHeap.heap[9] = 60;
        extractMin(0, minHeap);
        for(int i = 0; i < minHeap.size; i++) {
            System.out.println(minHeap.heap[i]);
        }
    }

    private static void extractMin(int node, Heap minHeap) {
        if(minHeap.size == 0) return;
        if(minHeap.size == 1) {
            minHeap.size--;
            System.out.println(minHeap.heap[0]);
            return;
        }
        minHeap.heap[node] = minHeap.heap[minHeap.size - 1];
        minHeap.size--;
        minHeapify(node, minHeap);
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
