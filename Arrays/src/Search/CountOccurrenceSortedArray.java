package Search;

public class CountOccurrenceSortedArray {
    public static void main(String[] args) {
        //Approach 1: In the naive approach we can iterate over the array and when we encounter the element we can have the counter. Time Complexity will be O(N).
        //Approach 2: We can use binary search and when the mid element is same as the element to be searched then we can have two pointer, one will go left and
        //other will go to right until the element is same. In worst case all the element are same then mid == element and left and right pointer will go to extreme end.
        //Time complexity will be O(logN) + O(N) = Binary Search + left/Right traversal
        //Approach 3: We can find the count of the element in O(logN) complexity. We will use firstOccurrence and lastOccurrence and then do lastOccurrence - firstOccurrence + 1
        int[] arr = {0,0,0,1,1,1,1};
        int len = arr.length;
        System.out.println(findCount(arr, len, 40));

    }

    private static int findCount(int[] arr, int len, int elem) {
        int firstOcc = findFirstOccurrence(arr, 0, len-1, elem);
        if(firstOcc == -1) {            //If firstOcc == -1 it means element is not present so no need to check for last element directly return count as 0
            return 0;
        } else {
            return (findLastOccurrence(arr, 0, len-1, elem) - firstOcc + 1);
        }
    }

    private static int findFirstOccurrence(int[] arr, int low, int high, int elem) {
        if(low > high) return -1;
        int mid = (low + high) / 2;
        if(arr[mid] > elem) {
            return findFirstOccurrence(arr, low, mid - 1, elem);
        } else if(arr[mid] < elem) {
            return findFirstOccurrence(arr, mid + 1, high, elem);
        } else {
            if(mid == 0 || arr[mid-1] != arr[mid]) {
                return mid;
            } else {
                return findFirstOccurrence(arr, low, mid - 1, elem);
            }
        }
    }

    private static int findLastOccurrence(int[] arr, int low, int high, int elem) {
        if(low > high) return -1;
        int mid = (low + high) / 2;
        if(arr[mid] > elem) {
            return findLastOccurrence(arr, low, mid - 1, elem);
        } else if(arr[mid] < elem) {
            return findLastOccurrence(arr, mid + 1, high, elem);
        } else {
            if(mid == arr.length-1 || arr[mid+1] != arr[mid]) {
                return mid;
            } else {
                return findLastOccurrence(arr, mid+1, high, elem);
            }
        }
    }
}
