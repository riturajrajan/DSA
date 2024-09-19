package Stack;

import java.util.ArrayDeque;

public class LargestRectangleAreaInMatrix {
    public static void main(String[] args) {
        //We will use idea of largest area inside histogram. One by one we will pass a single row considering as a single array and maxAreaInHistogram will return max area
        //If row is 1 or greater we need to pass the sum of upper single array passed. If the current element is 0 then simply we add in array
        int[][] matrix = {{0, 1, 1, 0}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 0, 0}};
        int maxArea = maxAreaInHistogram(matrix[0]);
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if(matrix[row][col] == 1)     //If current element is one then add previous row sum as a bar
                    matrix[row][col] += matrix[row - 1][col];
            }
            maxArea = Math.max(maxArea, maxAreaInHistogram(matrix[row]));
        }
        System.out.println(maxArea);
    }

    public static int maxAreaInHistogram(int[] arr) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int element, pse, nse, maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                element = arr[stack.peek()];
                stack.pop();
                pse = stack.isEmpty() ? -1 : stack.peek();
                nse = i;
                maxArea = Math.max(maxArea, (element * (nse - pse - 1)));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            element = arr[stack.peek()];
            stack.pop();
            pse = stack.isEmpty() ? -1 : stack.peek();
            nse = arr.length;
            maxArea = Math.max(maxArea, (element * (nse - pse - 1)));

        }
        return maxArea;
    }
}
