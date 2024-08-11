package Search;

public class IndexOfLastOccurrence {
    public static void main(String[] args) {
        //We will follow normal approach of binary search and when the element is same as the mid element then we have to think something. If mid == arrLength
        // it means arr[mid] == elem and mid == arrLength so, we are the first occurrence and if arr[mid+1] != arr[mid] then also is the first occurrence else move low index to mid+1;
        int[] arr = {10, 10, 10, 10, 20, 20, 30};
        System.out.println(findLastOccurrence(arr, 0, arr.length-1, 10));
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
