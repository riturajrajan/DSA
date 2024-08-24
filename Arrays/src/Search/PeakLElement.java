package Search;

public class PeakLElement {
    public static void main(String[] args) {
        //Idea here is if we are thinking of independent array of size 1, 2, 3 just to understand then there will be one peak element so we will use binary search and divide the
        //array into smaller than we will use one logic to divide, we will go to left or right half depends on which neighbour is greater than the mid element.
        //Take an example - [5, 10, 20, 40, 60, 70, 80}. Mid is 40 and if we left half then no element is peak element, if we think of [5, 10, 20] then 20 is the peak element
        //but 40 is cancelling its peak element so we have to go right side by following the above logic of which is greater
        //Time Complexity is O(logN)
        int[] arr = {5, 20, 10, 30, 40, 50, 60};
        System.out.println(findPeakElement(arr, 0, arr.length - 1));
    }

    private static int findPeakElement(int[] arr, int low, int high) {
        while(low <= high) {
            int mid = (low + high) / 2;
            if((mid == 0 || arr[mid] >= arr[mid-1]) && (mid == arr.length - 1 || arr[mid] >= arr[mid+1])) return mid;
            if(mid > 0 && arr[mid-1] > arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
