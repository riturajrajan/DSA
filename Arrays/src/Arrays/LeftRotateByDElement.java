package Arrays;

import java.util.Arrays;

public class LeftRotateByDElement {
    public static void main(String[] args) {
        //Approach 1 - rotate by one first and then call the same method to rotate by d elements
        int[] arr = {1, 2, 3, 4, 5};
        int d = 2;
        for(int j = 0; j < d; j++) {
            rotateElement(arr);
        }
        Arrays.stream(arr).forEach(elem -> System.out.print(elem + ""));

        //Approach 2 - we will create a temporary array and copy the d elements into it and then start from d element iterating over array and shifting d position back
        //and at last copy from temp to target array. Time Complexity is O(N) and Space Complexity is O(d)
        int[] arrApproach2 = {1, 2, 3, 4, 5};
        int dApproach2 = 4;
        rotateElementApproach2(arrApproach2, dApproach2);
        System.out.println("");
        Arrays.stream(arrApproach2).forEach(elem -> System.out.print(elem + ""));

        //Approach 3 - Swap first d element and remaining n-d element and then finally swap the array totally. Time Complexity O(N) and space complexity is O(1)
        int[] arrApproach3 = {1, 2, 3, 4, 5};
        int dApproach3 = 4;
        rotateElementApproach3(arrApproach3, dApproach3);
        System.out.println("");
        Arrays.stream(arrApproach3).forEach(elem -> System.out.print(elem + ""));
    }

    private static void rotateElement(int[] arr) {
        int temp = arr[0];
        for(int i = 1; i < arr.length; i++) {
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = temp;
    }

    private static void rotateElementApproach2(int[] arrApproach2, int dApproach2) {
        int[] temp = new int[dApproach2];
        for(int i = 0; i < dApproach2; i++) {
            temp[i] = arrApproach2[i];
        }
        for (int i = dApproach2; i < arrApproach2.length; i++) {
            arrApproach2[i - dApproach2] = arrApproach2[i];
        }
        for(int i = 0; i < temp.length; i++) {
            arrApproach2[arrApproach2.length - dApproach2 + i] = temp[i];
        }
    }

    private static void rotateElementApproach3(int[] arrApproach3, int dApproach3) {
        swap(arrApproach3, 0, dApproach3-1);
        swap(arrApproach3, dApproach3,arrApproach3.length - 1);
        swap(arrApproach3, 0, arrApproach3.length - 1);
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = 0;
        while(start < end) {
            temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
    }

}
