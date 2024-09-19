package Stack;

import java.util.Arrays;

public class KStackInsideArray {
    public static void main(String[] args) {

    }
}

class MyStackTwo {
    int[] stack;
    int capacity, top1, top2;

    MyStackTwo(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        top1 = -1;
        top2 = capacity;
    }

    public void push1(int item) {
        if (top1 < (top2 - 1)) {
            top1++;
            stack[top1] = item;
        }
    }

    public void push2(int item) {
        if (top1 < (top2 - 1)) {
            top2--;
            stack[top2] = item;
        }
    }

    public int pop1() {
        int res = -1;
        if (top1 > -1) {
            res = stack[top1];
            top1--;
        }
        return res;
    }

    public int pop2() {
        int res = -1;
        if (top2 < capacity) {
            res = stack[top2];
            top2++;
        }
        return res;
    }

    public void size1() {
        System.out.println(top1 + 1);
    }

    public void size2() {
        System.out.println(capacity - top2);
    }

    @Override
    public String toString() {
        return Arrays.toString(stack);
    }
}
