package Search;

public class IndexOfFirstOccurrence {
    public static void main(String[] args) {
        //We will follow normal approach of binary search and when the element is same as the mid element then we have to think something. If mid == 0 it means arr[mid] == elem
        //and mid == 0 so, we are the first occurrence and if arr[mid-1] != arr[mid] then also is the first occurrence else move high index to mid-1;
        int[] arr = {10, 10, 10, 10, 20, 20, 30};
        System.out.println(findFirstOccurrence(arr, 0, arr.length-1, 20));
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
}
