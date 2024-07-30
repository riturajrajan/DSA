package Arrays;

public class TrappingRainWater {
    public static void main(String[] args) {
        // Idea here is water at particular index can be filled only when it leftmost and rightmost element are greater then only water can be hold by two bigger column in left & right
        //Now water can be stored with the min(leftmost, rightmost). Suppose we are at index 1 with value 1 and index 0 has 3 and index 2 has 5 value. So, max water can be placed at index 1 will be
        //min(3, 5) which is 3 and we need to do minValue-arr[1] to get the water level. Time complexity is O(n) and space complexity is O(n)
        //Since the 0 index and last index element can't hold the water so we start iteration ignoring this element
        int[] arr = {5, 0, 6, 2, 3};
        int len = arr.length, res = 0;
        int[] leftMost = new int[len];
        leftMost[0] = arr[0];
        int[] rightMost = new int[len];
        rightMost[len-1] = arr[len - 1];
        for(int i = 1; i < len; i++) {
            leftMost[i] = Math.max(arr[i], leftMost[i - 1]);
        }
        for(int i = len-2; i >=0; i--) {
            rightMost[i] = Math.max(arr[i], rightMost[i + 1]);
        }
        for(int i = 1; i < len - 1; i++) {
            res = res + (Math.min(leftMost[i], rightMost[i]) - arr[i]);
        }
        System.out.println(res);
    }
}
