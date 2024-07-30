package Arrays;

public class MaxSumSubarray {
    public static void main(String[] args) {
        //the idea is the do the summation of current element with the max which basically means we are doing the sum of subarray. If anytime the max is smaller than the current index
        //it means we have to ignore previous sum and start from the current index. Time complexity is O(n)
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int len = arr.length, max = arr[0], res = arr[0];
        for(int i = 1; i < len; i++) {
            max = Math.max(arr[i] + max, arr[i]);
            res = Math.max(max, res);   // We have to do this because we might have found a bigger sum earlier so we cannot ignore that because above line 10 will just give max of current element
                                        // with the previous max which can decrease the max res value.
        }
        System.out.println(res);
    }
}
