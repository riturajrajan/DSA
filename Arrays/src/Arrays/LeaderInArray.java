package Arrays;

public class LeaderInArray {
    public static void main(String[] args) {
        //Idea is very simple. Traverse the array from right to left and by default print the last element and set it as the leader. if the current element is greater
        // than the leader then print that element
        int[] arr = {7, 10, 4, 10, 6, 5, 2};
        int len = arr.length;
        int max = arr[len-1];
        System.out.println(max);
        for(int i = len - 1; i >= 0; i--) {
            if(max < arr[i]) {
                System.out.println(arr[i]);
                max = arr[i];
            }
        }
    }
}
