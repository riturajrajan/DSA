import java.util.ArrayList;
import java.util.List;

public class CombinationSumRecursion {
    public static void main(String[] args) {

        /*
         * Whenever there is case to take the element we can think of pick/not pick case
         */
        int[] arr = {2, 3, 6, 7};
        List<Integer> combination = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        combinationSum(arr, 7, combination, output, 0);
        output.stream().forEach(singleList -> {
            singleList.forEach(System.out::print);
        });
    }

    private static void combinationSum(int[] arr, int target, List<Integer> combination, List<List<Integer>> output, int index) {
        if(index == arr.length) {
            if(target == 0) {
                output.add(new ArrayList<>(combination));
            }
            return;
        }
        if(arr[index] <= target) {
            combination.add(arr[index]);
            combinationSum(arr, target-arr[index], combination, output, index);
            combination.remove(combination.size()-1);
        }
        combinationSum(arr, target, combination, output, index+1);
    }
    /*
     * we can take the element a single index multiple times as we are not sure about the combination. May be if we take the zero element multiple
     * times then it can form the target. if taking the same index multiple times and we are not able to form the target then we will move to
     * next index
     */
}
