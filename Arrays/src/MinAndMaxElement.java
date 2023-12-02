import java.util.Arrays;

public class MinAndMaxElement {
    public static void main(String[] args) {

        //First approach
        /*
         * Traverse the array and check the value against min and max and assign value accordingly.
         * Complexity is O(n)
         */
        int[] arr = {-10, 5, 40, 80, 1};
        int currIndex = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        while(currIndex != arr.length) {
            if(arr[currIndex] > max) {
                max = arr[currIndex];
            } else if(arr[currIndex] < min) {
                min = arr[currIndex];
            }
            currIndex++;
        }
        System.out.println("Max element: " + max  + " Min Element: " + min);

        //Second Approach
        /*
         * Use inbuilt function and sort the array then arr[0] will be the min and arr[arr.length-1] will be the max element.
         * Complexity is O(n)
         */
        Arrays.sort(arr);
        System.out.println("Max element: " + max  + " Min Element: " + min);

        //Third Approach
        /*
         * We can use inbuilt method in java like Math.min() and Math.max(); Complexity is O(nlogn)
         */

        int minElem = arr[0], maxElem = arr[0];
        for(int i = 0; i < arr.length; i++) {
            minElem = Math.min(minElem, arr[i]);
        }
        for(int i = 0; i < arr.length; i++) {
            maxElem = Math.max(maxElem, arr[i]);
        }
        System.out.println("Max element: " + max  + " Min Element: " + min);
    }
}
