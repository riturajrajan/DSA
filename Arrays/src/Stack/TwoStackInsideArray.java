package Stack;

import java.util.Arrays;

public class TwoStackInsideArray {
    public static void main(String[] args) {
        //Idea here is we will have two pointer approach and top1 points from the beginning of array for stack1 and top2 points from end of array for stack2. Now we any wants to
        //add element in stack1 then we will do top1++ and then add the element and when anyone wants to insert in stack2 then top-- then add. We can push into stack1 only when
        //top1 < (top2-1) because we need one space to do top++ to insert before top2-1. Time Complexity of every operation is O(1)
        MyNewStack myStack = new MyNewStack(4);
        myStack.push1(10);
        myStack.push2(100);
        myStack.push2(200);
        myStack.push1(20);
        myStack.size1();
        myStack.size2();
        System.out.println(myStack);
    }
}

class MyNewStack {
    int[] stack;
    int capacity, top1, top2;

    MyNewStack(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        top1 = -1;
        top2 = capacity;
    }

    public void push1(int item) {
        if(top1 < (top2 - 1)) {
            top1++;
            stack[top1] = item;
        }
    }

    public void push2(int item) {
        if(top1 < (top2 - 1)) {
            top2--;
            stack[top2] = item;
        }
    }

    public int pop1() {
        int res = -1;
        if(top1 > -1) {
            res = stack[top1];
            top1--;
        }
        return res;
    }

    public int pop2() {
        int res = -1;
        if(top2 < capacity) {
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
