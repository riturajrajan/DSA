import java.util.ArrayList;
import java.util.List;

public class CombinationSumUniqueRecursion {
    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        combinationSum(arr, output, 0, combination, 8);
        combination.forEach(singleList -> {
            System.out.println(singleList.toString());
        });
    }

    private static void combinationSum(int[] arr, List<List<Integer>> output, int index, List<Integer> combination, int target) {
        if(index == arr.length) {
            if(target == 0) {
                output.add(new ArrayList<>(combination));
            }
            return;
        }
        if(arr[index] <= target) {
            combination.add(arr[index]);
            combinationSum(arr, output, index +1, combination, target-arr[index]);
            combination.remove(combination.size()-1);
        }
        combinationSum(arr, output, index +1, combination, target);
    }
}
