package Stack;

public class GetMinStack {
    public static void main(String[] args) {
        //If numbers are positive - Whenever we see a value less than current minimum then we have to do something like before pushing we have to update the value to val - getMin
        //so it will make the value negative (because val is new min identified and we are subtracting new min with prev min) and then we push it. If the number is
        // greater than min then simply we push it. Now before popping if we see a negative value it means we have to pushed a modified value and we need to get
        // original value. To do so we have to do getMin - val (val will be negative and -val will become +ve).
        //If numbers are negative - Then we have to use formula like 2*val - min.


        MyGetMinStack myStack = new MyGetMinStack(10);
        myStack.push(5);
        myStack.push(10);
        myStack.push(20);
        myStack.push(2);
        myStack.push(6);
        myStack.push(4);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        myStack.push(2);
        System.out.println(myStack.getMin());
    }
}

class MyGetMinStack {
     int[] stack;
     int capacity;
     int top;
     int getMin;

    MyGetMinStack(int capacity) {
        this.capacity = capacity;
        this.stack = new int[capacity];
        this.top = -1;
        this.getMin = Integer.MAX_VALUE;
    }

    public int getMin() {
        return getMin;
    }

     public void push(int item) {
        top += 1;
        if(isEmpty()) {
            getMin = item;
            stack[top] = item;
        } else if(item <= getMin) {
            stack[top] = item - getMin;     //(2*item - getMin)
            getMin = item;
        } else {
            stack[top] = item;
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int pop() {
        if(top == -1) {
            return -1;
        }
        int item = stack[top], popVal;
        top -= 1;
        if(item <= 0) {             //if(item <= min)
            popVal = getMin;
            getMin -= item;         //getMIn = 2*getMin - item
        } else {
            popVal = item;
        }
        return popVal;
    }
}