package Arrays;

import java.util.HashMap;
import java.util.Map;

public class MaxAppearingElementRanges {
    //This is solved through prefix sum. Idea here is to create a freq array which will show the start and end of a range. After marking the
    //range we will find the prefix sum and max will give  the output. Constraint given is range should be <= 100
    public static void main(String[] args) {
        int[] left = {1, 2, 4};
        int[] right = {4, 5, 7};
        int[] freq = new int[101];  //We need 101 because we are doing right[i]+1 which can increase 100 size
        int res = 0;
        for(int i = 0; i < left.length; i++) {          //This for loop will mark the starting and ending of a range
            freq[left[i]] = 1;
            freq[right[i]+1] = -1;
        }
        for(int i = 1; i < freq.length; i++) {
            freq[i] = freq[i] + freq[i-1];              //Here we are doing prefix sum
            if(freq[i] > freq[res]) {                   //At the same time we are checking which value is greater than returning the index of it
                res = i;
            }
        }
        System.out.println(res);
    }
}
