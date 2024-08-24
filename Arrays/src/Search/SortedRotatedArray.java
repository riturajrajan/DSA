package Search;

public class SortedRotatedArray {
    public static void main(String[] args) {
        //Idea here is one half of the array will be sorted. To check which half is sorted we need to check mid with low. If arr[mid] > arr[low] it means left half is sorted
        //and we can ignore the right half. Now once we checked which half is sorted we need to check whether the element lies in the half sorted array. If yes then we
        //do binary search else we move to other half. Time Complexity is O(logN)
        int[] arr = {80, 100, 10, 20, 30, 50};
        System.out.println(findElementRotated(arr, 50));
    }

    private static int findElementRotated(int[] arr, int elem) {
        int low = 0, high = arr.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] == elem) return mid;
            if(arr[low] <= arr[mid]) {
                if(elem >= arr[low] && elem < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if(elem > arr[mid] && arr[high] >= elem) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
