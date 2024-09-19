package Stack;

import java.util.ArrayDeque;

public class StockSpan {
    public static void main(String[] args) {
        //pattern here is if the current element is bigger than previous element from start then span will be (i+1) and if it is smaller than the previous greater element then
        //span will be i - (index of prev next big element). Now we have to maintain a previous big element so we will use stack. If current element is bigger than top of stack
        //then we need to pop the element until current element is bigger than stack.peek(). No poping will raise two condition. 1. Stack gets empty it means the current element
        //is the biggest so span will be (i+1) 2. Still stack has some element then span will be i - stack.peek(),
        int[] stock = {60, 10, 20, 40, 35, 30, 50, 70, 65};
        int len = stock.length, span;
        ArrayDeque<Integer> prevLarge = new ArrayDeque<>();
        if(len == 0) return;
        System.out.print("1 ");
        if(len == 1) {
            return;
        }
        prevLarge.push(0);
        for(int i = 1; i < len; i++) {
            while(prevLarge.isEmpty() == false && stock[i] >= stock[prevLarge.peek()]) prevLarge.pop();
            span = prevLarge.isEmpty() ? (i+1) : (i - prevLarge.peek());
            System.out.print(span + " ");
            prevLarge.push(i);
        }
    }
}
