package Arrays;

public class MaxCircularSubArraySum {
    public static void main(String[] args) {
        //The idea here is to find the sum of normal array and then the circular array. The max of both the result is the final one. To find the max sum of normal array use kadane's algo and
        //to find the sum of circular array we have to think in a way that some element in the middle breaks the order. This elements are smallest sum of element. It means if we find
        // the total sum of the array ans substract the minimum sum of element we can get the max sum of circular array.
        int[] arr = {8, -4, 3, -5, 4};
        int len = arr.length;
        int maxNormalSum = maxKadenaAlgo(arr, len);
        if(maxNormalSum < 0) {
            System.out.println(maxNormalSum);
            return;
        }
        int arr_sum = 0;
        for(int i = 0; i < len; i++) {   // To find the minimum sum array we can revert the array and find the max sum subarray which actually means we are finding min sum subarray in original array
            arr_sum += arr[i];
            arr[i] = -arr[i];
        }
        int maxCircularSum = arr_sum + maxKadenaAlgo(arr, len);    //Instead of doing (total_sum - min sum subarray) we are adding because -(-min sum subarray) we become positive
        System.out.println("Max sum is: " + Math.max(maxCircularSum, maxNormalSum));
    }

    private static int maxKadenaAlgo(int[] arr, int len) {
        int maxEnding = arr[0], res = arr[0];
        for(int i = 1; i < len; i++) {
            maxEnding = Math.max((arr[i] + maxEnding), arr[i]);
            res = Math.max(res, maxEnding);
        }
        return res;
    }
}
