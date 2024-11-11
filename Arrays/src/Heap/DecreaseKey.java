package Heap;

public class DecreaseKey {
    public static void main(String[] args) {
        //Idea her is we will override the value with the given value at given index and now we need to see if the parent becomes smaller or greater. So, for this
        //we need to check for its then its parents then it parents until parent becomes smaller or we reach root of the tree
        //Delete a key: Idea will be the same. The node which we want to delete we will make that node as -Infinity and call the minHeapify so that it moves to the
        //root of the tree and then call extractMin to remove from the tree.
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
        decreaseKey(3, 5, minHeap);
    }

    private static void decreaseKey(int position, int value, Heap minHeap) {
        minHeap.heap[position] = value;
        while (position != 0 && minHeap.heap[minHeap.getParent(position)] > minHeap.heap[position]) {
            int parentIndex = minHeap.getParent(position);
            int temp = minHeap.heap[parentIndex];
            minHeap.heap[parentIndex] = minHeap.heap[position];
            minHeap.heap[position] = temp;
            position = parentIndex;
        }
    }

    //to build a binary heap from a given array we need to call minHeapify for the node which is the parent of the bottom right internal node. Let's understand this
    //Size of the array will be size and last element will be present at size-1. Now we need to call minHeapify for the parent of this node and we can the parent
    //by ((size-1)-1)/2 where i - size-1.
//    public void buildHeap() {
//        for(int i = (size-2) / 2; i >= 0; i--) {
//            minHeapify(i);  // call this till the root
//        }
//    }
}
