package Arrays;

import java.util.HashMap;
import java.util.Map;

public class Frequency {
    public static void main(String[] args) {
        //Approach 1:  Create a map and enter the key as the element and value as 1 when first time encounters else increase the count when the same key is present
        int[] arr = {10, 10, 10, 25, 30, 30};
        Map<Number, Number> frequency = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(frequency.containsKey(arr[i])) {
                frequency.put(arr[i], ((int)frequency.get(arr[i])) + 1);
            } else {
                frequency.put(arr[i], 1);
            }
        }
        frequency.entrySet().stream().forEach((key) -> System.out.println("key: " + key + " value: "));

        //Approach 2: Start from first index and it is same as the previous element then increment the counter else set freq = 1
        int[] arrApproach2 = {10, 10, 20, 20, 30};
        int freq = 1, len = arrApproach2.length;
        for(int i = 1; i < arrApproach2.length; i++) {
            if(arrApproach2[i] == arrApproach2[i-1]) {
                freq++;
            } else {
                System.out.println("Frequency of: " + arrApproach2[i-1] + " is " + freq);
                freq = 1;
            }
        }
        if(len > 1 && arrApproach2[len - 1] != arrApproach2[len - 2]) {   //If last element is different then this block print the frequency as 1
            System.out.println("Frequency of: " + arrApproach2[len - 1] + " is " + freq);
        }
        if(freq > 1 || len == 1) {   //if the last element is same as the previous element or array contains same element or array contains only one element then block will take care
            System.out.println("Frequency of: " + arrApproach2[len - 1] + " is " + freq);
        }

        //Better approach

        int i = 1, freqCount = 1;
        while(i < len) {
            while (i < len && arrApproach2[i] == arrApproach2[i-1]){
                freqCount++;
                i++;
            }
            System.out.println("frequency of " + arrApproach2[i-1] + " is " + freqCount);
            freqCount = 1;
            i++;
        }
        if(len == 1 || arrApproach2[len - 1] != arrApproach2[len - 2]) {
            System.out.println("frequency of " + arrApproach2[i-1] + " is " + freqCount);
        }
    }
}
