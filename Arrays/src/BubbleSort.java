import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {10, 1, 20, 11, 12, 30};
        int len = arr.length;
        int i = 0, j = 1, temp;
        if(len == 1) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        //Approach 1
        /*
         * In bubble sort we do the adjacent comparison and try to push the max element to the right of the array. Once the max element is pushed then
         * again comparison starts from the start.
         */
        while(len >= 2) {   // At some point when the length becomes 2 it means no only first index and adjacent index is left for comparison

            if(arr[i] > arr[j]) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            i++;
            j++;
            if( j == len) {         // if the j pointer reaches the end of length then start from beginning and decrease the length
                len = len - 1;
                i = 0;
                j = i + 1;
            }
        }
        System.out.println(Arrays.toString(arr));

        //Approach 2: Considering best case scenario when the array is already sorted
        for(int x = len-1; x >= 0; x--) {
            int didSwap = 0;
            for(int z = 0; z <= x-1; z++) {          // Array will go to 0 to n-1 then 0 to n-2 then 0-n-3 that's why z <= i-1
                if(arr[z] > arr[z+1]) {
                    temp = arr[z];
                    arr[z] = arr[z+1];
                    arr[z+1] = temp;
                    didSwap = 1;                 //if single time swap happens then we have to run the entire loop but let say z iterated over array and not
                }                                // a single time swaps happened it means array is sorted so come out of the loop
            }
            if(didSwap == 0) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
