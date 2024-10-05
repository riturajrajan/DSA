package Queue;

import java.util.Arrays;

public class ArrayImpl {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(3);
        System.out.println(queue.getFront());
        System.out.println(queue.getRear());
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println(queue);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);
        System.out.println(queue.size());
        System.out.println(queue.getFront());
        System.out.println(queue.getRear());
    }
}

class MyQueue {
    private int[] queue;
    private int capacity;
    private int front, rear;

    public MyQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = this.rear = -1;
    }

    public void enqueue(int item) {
        if(isEmpty()) {
            rear++;
            queue[++front] = item;
        } else if(!isFull()){
            queue[++rear] = item;
        }
    }

    public void dequeue() {
        if(isEmpty()) {
            System.out.println("Queue is empty cannot remove items");
        } else if(front <= rear){
            front++;
        } else {
            System.out.println("Queue is empty cannot remove items");
        }
    }

    public int getFront() {
        return front == -1 || front == capacity ? -1 : queue[front];
    }

    public int getRear() {
        return front == capacity || rear == -1 ? -1 : queue[rear];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return rear == capacity - 1;
    }

    public int size() {
        return rear - front + 1;
    }

    public String toString() {
        return Arrays.toString(queue);
    }
}