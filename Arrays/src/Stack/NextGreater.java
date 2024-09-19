package Stack;

import java.util.ArrayDeque;

public class NextGreater {
    public static void main(String[] args) {
        int[] arr = {5, 15, 10, 8, 6, 12, 9, 18};
        int nextBig = -1;
        ArrayDeque<Integer> nextGreater = new ArrayDeque<>();
        ArrayDeque<Integer> ans = new ArrayDeque<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while(nextGreater.isEmpty() == false && arr[i] >= nextGreater.peek()) nextGreater.pop();
            nextBig = nextGreater.isEmpty() ? -1 : nextGreater.peek();
            ans.push(nextBig);
            nextGreater.push(arr[i]);
        }
        while(ans.isEmpty() == false) {
            System.out.println(ans.pop());
        }
    }
}
