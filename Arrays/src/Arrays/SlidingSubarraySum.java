package Arrays;

public class SlidingSubarraySum {
    public static void main(String[] args) {
        //Idea here is to maintain the start and end index and if the sum is greater than current window sum then we start expanding the window by incrementing j++. If the windowSum becomes
        //greater than sum then we start removing from the beginning. Once removed we will check with sum and if equal then return true
        int[] arr = {1, 4, 20, 3, 10, 5};
        int len = arr.length, j = 0, windowSum = arr[0], sum = 33;
        for(int i = 1; i < len; i++) {
            windowSum += arr[i];
            while(windowSum > sum) {
                windowSum -= arr[j];
                j++;
            }
            if(windowSum == sum) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }
}
