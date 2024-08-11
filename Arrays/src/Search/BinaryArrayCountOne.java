package Search;

public class BinaryArrayCountOne {
    public static void main(String[] args) {
        //Idea here is to find the first occurrence of 1 using binary search. If arr[mid] == 0 it means 1 is on the right side so, we will move low = mid+1.
        //If we find the first occurrence then simply do (len - index of first occurrence). Time Complexity is O(logN)
        int[] arr = {0, 0, 0, 0, 1, 1, 1, 1};
        System.out.println(findOne(arr));
    }

    private static int findOne(int[] arr) {
        int low = 0, high = arr.length - 1, mid = 0;
        while(low <= high) {
            if(low > high) return -1;
            mid = (low + high) / 2;
            if(arr[mid] == 0) {
                low =  mid + 1;
            } else {
                if(mid == 0 || arr[mid] != arr[mid-1]) {
                    return (arr.length - mid);
                } else {
                    high = mid - 1;
                }
            }
        }
        return 0;
    }
}
