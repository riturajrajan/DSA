package Stack;

import java.util.Arrays;
import java.util.Stack;

public class MyStack {
    private int[] stack;
    private int top;

    MyStack(int capacity) {
        stack = new int[capacity];
        top = 0;
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "stack=" + Arrays.toString(stack) +
                ", top=" + top +
                '}';
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack(10);
        push(10, stack);
        push(20, stack);
        push(30, stack);
        System.out.println(stack);
        size(stack);
        System.out.println(peek(stack));
        System.out.println(pop(stack));
        System.out.println(stack);
        size(stack);
        push(50, stack);
        size(stack);
        System.out.println(stack);
        System.out.println(peek(stack));
    }

    private static int pop(MyStack stack) {
        if(stack.top == 0) {
            System.out.println("UnderFlow: no element");
            return -1;
        }
        int pop = stack.stack[stack.top];
        stack.top--;
        return pop;
    }

    private static void push(int item, MyStack stack) {
        if(stack.top == stack.stack.length) {
            System.out.println("Stack Overflow");
            return;
        }
        stack.stack[stack.top++] = item;
    }

    private static int peek(MyStack stack)  {
        if(stack.top == 0) {
            System.out.println("UnderFlow: no element");
            return -1;
        }
        return stack.stack[stack.top - 1];
    }

    private static void size(MyStack stack) {
        System.out.println(stack.top);
    }

    private static boolean isEmpty(MyStack stack) {
         return stack.stack.length > 0;
    }
}
