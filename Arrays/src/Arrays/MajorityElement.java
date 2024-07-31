package Arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        //Approach 1: Not to be followed..  We have to iterate over the array and create a map which contains the key as element and a submap which contains the index along with the count
        //Whenever we encounter the element which is present in Map we simply increment the count and if it is not present then we add into map. Here we are storing the index of first
        //occurence and then increment the count. Time Complexity is O(n) and Space Complexity is O(n)
        int[] arr = {8, 7, 6, 8, 8, 8, 8, 8, 8};
        Map<Integer, Map<Integer, Integer>> res = new HashMap<>();
        int val = 0;
        for(int i = 0; i < arr.length; i++) {
            if(res.containsKey(arr[i])){
                val = (int)res.get(arr[i]).entrySet().iterator().next().getValue();
                val++;
                res.get(arr[i]).put(res.get(arr[i]).entrySet().iterator().next().getKey(), Integer.valueOf(val));
            } else {
                Map<Integer, Integer> index = new HashMap<>();
                index.put(i, 1);
                res.put(arr[i], index);
            }
        }
        res.entrySet().stream().forEach(data -> {
            if(data.getValue().entrySet().iterator().next().getValue() > arr.length / 2) {
                System.out.println(data.getValue().entrySet().iterator().next().getKey());
            }
        });

        //Approach 2: Moore Voting Algorithm -> We will iterate over the array and if the same element is occuring multiple times we will increment the counter and when different element
        //is encountered we decrement the counter. When the counter becomes zero we assign current index as the majority element and set the counter to 1. Counter = 0 means all the previous
        //element cancel out each other occurence and cannot be the majority element. This algo say that majority element found can be the majority so for safety we will run the loop on
        //array and confirm the count of element found by Moore Algo. Ex -> {8, 7, 6, 8, 8, 1, 1, 1}. Moore will say that 1 is majority but when we iterate over array and check the count
        //we will see 1 is not the majority element.
        int count = 0, currIndex = 0;
        for(int i = 0; i < arr.length; i++) {

        }


    }
}
