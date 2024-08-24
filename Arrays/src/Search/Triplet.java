package Search;

public class Triplet {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 8, 9, 20, 40};
        int low = 0, high = arr.length - 1, elem = 32;
        //First approach: We will fix one element at a time and then use remaining element to find the pair sum. Time complexity is O(N^2) because pair sum time complexity
        //is O(N) and we are iterating over each element.
        System.out.println(tripletSumFirstApproach(arr, elem, low, high));

        //Second approach written by me. Check once but use first approach only. Idea here is we will use two pointer approach to fix the 2 elements and then use binary
        //search to find the third element. Time complexity of two sum is O(N) and we are doing binary search in each iteration so, it will be O(N*logN)
        //System.out.println(tripletSumSecondApproach(arr, low, high, elem));
    }

    private static boolean tripletSumFirstApproach(int[] arr, int elem, int low, int high) {
        for(int i = low; i < high - 2; i++) {
            if(isPair(arr, elem - arr[i], i+1, high)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isPair(int[] arr, int elem, int start, int end) {
        while(start < end) {
            if(arr[start] + arr[end] == elem) {
                return true;
            } else if(arr[start] + arr[end] > elem) {
                end--;
            } else {
                start++;
            }
        }
        return false;
    }

    private static boolean tripletSumSecondApproach(int arr[], int low, int high, int elem) {
        while(low < (high-1)) {          //we are making sure between low and high at least one element should be there
            if(arr[low] + arr[high] == elem) {
                high--;
            }
            else if(arr[low] + arr[high] > elem) {
                high--;
            } else {
                if(binarySearch(arr, low + 1, high - 1, (elem - (arr[low] + arr[high])))) {
                    return true;
                } else {
                    low++;
                }
            }
        }
        return false;
    }

    private static boolean binarySearch(int[] arr, int low, int high, int elem) {
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] == elem) {
                return true;
            } else if(arr[mid] > elem) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
