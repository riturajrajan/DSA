package Stack;

import java.util.ArrayDeque;

public class LargestRectangleAreaInHistogram {
    public static void main(String[] args) {
        //One thing is clear we have to push every element into the stack so that we can process every element. Now if the current element is smaller than stack top element
        //it means stack top next smaller element is current element and in stack already we are storing previous small element because as we see greater element we are
        // directly push into the stack and from the formula of element * (nse - pse - 1))
        //we can calculate the max area.
        int[] arr = {3, 2, 10, 11, 5, 6, 3};
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int element, pse, nse, maxArea = 0;
        for(int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                element = arr[stack.peek()];
                stack.pop();
                pse = stack.isEmpty() ? -1 : stack.peek();
                nse = i;
                maxArea = Math.max(maxArea, (element * (nse - pse - 1)));
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            element = arr[stack.peek()];
            stack.pop();
            pse = stack.isEmpty() ? -1 : stack.peek();
            nse = arr.length;
            maxArea = Math.max(maxArea, (element * (nse - pse - 1)));

        }
        System.out.println(maxArea);
    }
}
