package Search;

public class InfiniteArray {
    public static void main(String[] args) {
        //We need to think in a way that key will be always present between low and high index. Since it is a infinite array so low will be 0 but we need to find high. To find
        //high we will check key with arr[high] and every iteration we will do high * 2. Once arr[high] become greater than key then the keys lies between low and high
        //and then use binary Search. Time Complexity is O(log(2*position) + log(position) = log(position)
        int[] arr = {1, 50, 100, 150, 300, 340, 434, 555, 590, 600, 690};
        System.out.println(findElement(arr, 690));
    }

    private static int findElement(int[] arr, int num) {
        if(arr[0] == num) return 0;
        int i = 1;
        while (i < arr.length && arr[i] < num) {
             i *= 2;
        }
        i = Math.min(i, arr.length - 1);   //This is a corner case where i exceeds length of the array
        if(arr[i] == num) return i;
        return binarySearch(arr, i/2+1, i-1, num);
    }

    private static int binarySearch(int[] arr, int low, int high, int num) {
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] == num) return mid;
            if(arr[mid] > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
