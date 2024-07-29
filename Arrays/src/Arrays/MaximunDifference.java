package Arrays;

public class MaximunDifference {
    public static void main(String[] args) {
        //Idea is very simple. we will start from the beginning and find the min value along with max difference
        int[] arr = {30, 10, 8, 2};
        int res = arr[1] - arr[0], minVal = arr[0];
        for(int i = 1; i < arr.length; i++) {
            res = Math.max(arr[i] - minVal, res);
            minVal = Math.min(minVal, arr[i]);
        }
        System.out.println(res);
    }
}
