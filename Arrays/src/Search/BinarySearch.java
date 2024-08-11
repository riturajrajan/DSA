package Search;

public class BinarySearch {
    public static void main(String[] args) {
        //We have to divide the array into two half based on the mid element. If mid element is greater than search element then we will move end pointer to mid-1 and if mid is smaller
        //than the search element then we will move start to mid+1. We will continue until start > end
        //Time Complexity is O(logN) and Space Complexity is O(logN) for recursive and Space Complexity is O(1) for iterative
        int[] arr = {10, 10};
        int len = arr.length;
        System.out.println(binarySearchElement(arr, 0, len-1, 10));
    }

    private static int binarySearchElement(int[] arr, int start, int end, int elem) {
        if(start > end) return -1;
        int mid = (start + end) / 2;
        if(arr[mid] == elem) return mid;
        if(elem > arr[mid]) {
            return binarySearchElement(arr, mid+1, end, elem);
        } else {
            return binarySearchElement(arr, start, mid-1, elem);
        }
    }
}
