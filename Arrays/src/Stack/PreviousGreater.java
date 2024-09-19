package Stack;

import java.util.ArrayDeque;

public class PreviousGreater {
    public static void main(String[] args) {
        int[] arr = {15, 10, 18, 12, 4, 6, 2, 8};
        int prevBig = -1;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < arr.length; i++) {
            while (stack.isEmpty() == false && arr[i] >= stack.peek()) stack.pop();
            prevBig = stack.isEmpty() ? -1 : stack.peek();
            System.out.println(prevBig);
            stack.push(arr[i]);
        }
    }
}
