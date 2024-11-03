package Arrays;

public class RotatedAndSorted {
    public static void main(String[] args) {
        //We have to do 3 things to identify where the array is either increasing/decreasing and rotated
        //1. Find the minIndex and maxIndex in both the case
        //2. Create a function which will just check whether the array is increasing or decreasing
        //3. Create a function to check increasing and rotated. If arr[0] > arr[n-1] it means it is increasing and for decreasing arr[0] < arr[n-1]
        //After identifying the corner cases we need to see between 0 and maxIndex array should be increasing and between minIndex and n-1 again array should be increasing for
        //increasing case and for decreasing case between 0 and minIdex array should be decreasing and between maxIndex and n-1 again should be decreasing
        int[] arr = {3, 4, 1, 2};
        final int length = arr.length - 1;
        int minIndex = 0, maxIndex = 0;
        boolean res = false;
        //Find minIndex and maxIndex
        for(int i = 0; i < length; i++) {
            if(arr[i] > arr[maxIndex]) maxIndex = i;
            if(arr[i] < arr[minIndex]) minIndex = i;
        }
        if((minIndex - 1) == maxIndex) {      //Array can be increasing and rotated so, we need to check more like the corner cases
            res = isIncRotated(arr, minIndex, maxIndex, length);
        }
        if(minIndex == maxIndex - 1) {
            res = isDecRotated(arr, minIndex, maxIndex, length);
        }
        System.out.println(res);
    }

    private static boolean isDecRotated(int[] arr, int minIndex, int maxIndex, int length) {
        if(arr[0] > arr[length]) return false;
        return isDecreasing(arr, 0, minIndex) && isDecreasing(arr, maxIndex, length);
    }

    private static boolean isIncRotated(int[] arr, int minIndex, int maxIndex, int length) {
        if(arr[0] < arr[length]) return false;
        return isIncreasing(arr, 0, maxIndex) && isIncreasing(arr, minIndex, length);
    }

    private static boolean isIncreasing(int[] arr, int start, int end) {
        for(int i = start + 1; i <= end; i++) {
            if(arr[i] < arr[i - 1]) return false;
        }
        return true;
    }

    private static boolean isDecreasing(int[] arr, int start, int end) {
        for(int i = start + 1; i <= end; i++) {
            if(arr[i] > arr[i - 1]) return false;
        }
        return true;
    }
}
