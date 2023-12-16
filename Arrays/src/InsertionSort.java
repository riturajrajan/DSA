import java.util.Arrays;

public class InsertionSort {
    private static int temp;

    public static void main(String[] args) {
        int[] arr = {10, 3, 1, 6, 4};

        /*
         * In insertion sort we pick the element and compare with the left element. If element is greater than we shift the element to write.
         * So one loop will traverse the array in forward direction and other will traverse in backward direction and it will check whether the element
         * is greater. If it is greater than swap the element
         */
        if(arr.length == 1) {
            System.out.println(Arrays.toString(arr));
        }

        for(int i = 1; i < arr.length; i++) {
            temp = arr[i];
            int j = i-1;
            while(j >=0 && arr[j] > temp) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
