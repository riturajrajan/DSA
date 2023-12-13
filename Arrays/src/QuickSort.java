import java.util.Arrays;

public class QuickSort {

    private static int pivot, temp;
    public static void main(String[] args) {
        /*
         * Time complexity is same as merge sort O(nlogn) but it has Space complexity of O(1) while merge sort has O(n)
         * Pick a pivot element. It can be any element
         * 1. First Element 2. Last element 3. Middle Element 4. Random element
         *
         * Place the smaller element to left of pivot and large element to right of pivot
         * Then from left of pivot create a hypothetical array to left and right and apply recursion and follow the same approach.
         *
         * Take a pointer i to low and j to high. Check if arr[i] is less than pivot if yes then just move the pointer and check if arr[j] is
         * greater than pivot then decrease the j pointer. Then swap the element and pivot will be placed at correct location
         */
        int[] arr = {4, 6, 2, 5, 7, 9, 1, 3};
        quickSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pIndex = parition(arr, low, high);  // This will be the correct index where the pivot needs to be placed
            quickSort(arr, low, pIndex -1);
            quickSort(arr, pIndex + 1, high);
        }

    }

    private static int parition(int[] arr, int low, int high) {
        int i = low, j = high, pivot = arr[low];
        while(i < j) {
            while(arr[i] < pivot && i <= high) i++;
            while(arr[j] > pivot && j >= low) j--;
            if(i < j) {
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
        return j;
    }
}
