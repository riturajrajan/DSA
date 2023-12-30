import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public static int temp;
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        boolean[] freq = new boolean[arr.length];
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
//        findPermutation(arr, ds, output, freq);
//        output.forEach(singleList -> System.out.println(singleList));
        //---------------------------
        findPermutationSwap(0, arr);
    }

    /* Approach 1
     * We can pick any of the element as the first set in permutation so from this we get to know we have to iterate from 0 to arr.length-1. Now the case will be
     * to pick the element as we have to form a set of 3 elements everytime. We can to get one map with every function call which will tell which element we have picked
     * and in place of that index we will place 1. For ex: arr=[1,2,3] and map=[], now if we picked 2 from arr then map will be map=[0,1,0]. We will check if i is !map then
     * we can pick that element
     * Time Complexity - n!*O(N) =  n factorial we know extra O(N) because we have to iterate over array
     * Space Complexity - O(N)+O(N) = because we will be carrying a data structure which hold the permutation and extra map also we have to carry
     */
    private static void findPermutation(int[] arr, List<Integer> ds, List<List<Integer>> output, boolean[] freq) {
        if (ds.size() == arr.length) {
            output.add(new ArrayList<>(ds));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                ds.add(arr[i]);
                findPermutation(arr, ds, output, freq);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }

    /* Approach 2
     * Let takes first element and swap with first element then move the pointer for next function call. In first function call try to swap first element with all
     * other elements in array and increment the pointer
     * Time Complexity - n!*O(N) =  n factorial we know extra O(N) because we have to iterate over array
     * Space Complexity = O(1)
     */
    private static void findPermutationSwap(int index, int[] arr) {
        if (index >= arr.length) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for(int i = index; i < arr.length; i++) {
            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
            findPermutationSwap(index+1, arr);
            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }
}
