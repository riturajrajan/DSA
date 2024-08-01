package Arrays;

public class WindowSliding {
    public static void main(String[] args) {
        //We will calculate the sum of first k element and make i to start from k. we will use the sum of previous k and add new element and remove first element from the window
        int[] arr = {5, -10, 6, 90, 3};
        int len = arr.length, k = 5, max = 0, sum = 0;
        if(k > len) return;
        for(int i = 0; i < k; i++) {
            sum += arr[i];
        }
        max = sum;
        for(int i = k; i < len; i++) {
            sum = sum + arr[i] - arr[i-k];
            max = Math.max(sum, max);
        }
        System.out.println(max);
    }
}
