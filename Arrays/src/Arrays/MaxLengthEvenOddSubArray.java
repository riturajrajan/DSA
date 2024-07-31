package Arrays;

public class MaxLengthEvenOddSubArray {
    public static void main(String[] args) {
        //Idea here is to check the two consecutive index. If one index is divisible by 2 and other will be not and vice versa. We will keep res because there can be more subarray
        //but we want max out of it
        int[] arr = {8, 7, 6, 3, 4, 9, 10, 12, 14, 7, 8, 8};
        int len = arr.length, counter = 1, res = 1;
        for(int i = 1; i < len; i++) {
            if((arr[i] % 2 == 0 && arr[i-1] % 2 == 1) || (arr[i] % 2 == 1 && arr[i-1] % 2 == 0)) {
                counter++;
                res = Math.max(res, counter);
            } else {
                counter = 1;
            }
        }
        System.out.println(res);
    }
}
