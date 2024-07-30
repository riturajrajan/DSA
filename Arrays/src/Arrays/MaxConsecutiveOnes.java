package Arrays;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        //Approach 1: Start from beginning and check if the element is 1. If yes then set the counter as 1 and run a while loop until 0 is meet. Inside while loop check if the element is 1
        // if yes then increase the counter. Time Complexity is O(n) and space complexity is O(1)
        int[] arr = {1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1};
        int len = arr.length, count = 0, max = 0;
        for(int i = 0; i < len; i++) {
            if(arr[i] == 1) {
                count  = 1;
                i++;
                while(i < len && arr[i] == 1) {
                    count++;
                    i++;
                }
                max = Math.max(count, max);
            }
        }
        System.out.println("Max Occurence is " + max);

        //Approach 2: (Better approach). Idea is the same as the first one just we will not use while instead we will keep track of 1 while we traverse we will incremement the counter and
        //at the same time max value is updated. Time Complexity is O(n) and space complexity is O(1)
        int counter = 0, maxApproach2 = 0;
        for(int i = 0; i < len; i++) {
            if(arr[i] == 0) {
                counter = 0;
            } else {
                counter++;
                max = Math.max(max, counter);
            }
        }
        System.out.println("Max Occurence is " + max);
    }
}
