import java.util.*;

public class CombinationSumRecursion {
    public static void main(String[] args) {

        /*
         * Whenever there is case to take the element we can think of pick/not pick case
         * we can take the element a single index multiple times as we are not sure about the combination. May be if we take the zero element multiple
         * times then it can form the target. if taking the same index multiple times and we are not able to form the target then we will move to
         * next index
         * Time complexity will be O(2^t * k) -> Since we will pick or not pick the index so probability will be 2^t and at the end
         * we are copying from one data structure to another which will take k times.
         */
        int[] arr = {1, 2, 2};
        List<Integer> combination = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        List<List<Integer>> output2 = new ArrayList<>();
        Set<List<Integer>> output1 = new HashSet<>();
        List<Integer> sumIncreasing = new ArrayList<>();
//        combinationSum(arr, 2, combination, output, 0);
//        output.stream().forEach(singleList -> {
//            System.out.println(singleList);
//        });
//        -------------------
//        combinationSumUniqueUsingSet(arr, 2, combination, output1, 0);
//        output1.stream().forEach(singleList -> {
//              System.out.println(singleList);
//        });
//        -------------------
//        Arrays.sort(arr);
//        combinationSumUnique(arr, 2, combination, output2, 0);
//        output2.stream().forEach(singleList -> {
//            System.out.println(singleList);
//        });
//        -------------------
//        sumOfAllSubsetIncreasingOrder(0, arr, sumIncreasing, 0);
//        output.forEach(singleList -> singleList.stream().reduce(0, (acc, element) -> acc + element));
//        sumIncreasing.stream().sorted().forEach(element -> System.out.println(element));
//        ------------------
        subsetWithNoDuplicate(arr, 0, output1, combination);
        output1.stream().forEach(singleList -> {
            System.out.println(singleList);
        });
    }

    // Element at any index can be picked any number of times. Below code depicts this scenario
    private static void combinationSum(int[] arr, int target, List<Integer> combination, List<List<Integer>> output, int index) {
        if (index == arr.length) {
            if (target == 0) {
                output.add(new ArrayList<>(combination));
            }
            return;
        }
        if (arr[index] <= target) {
            combination.add(arr[index]);
            combinationSum(arr, target - arr[index], combination, output, index);
            combination.remove(combination.size() - 1);
        }
        combinationSum(arr, target, combination, output, index + 1);
    }

    /*
     * Another question can be form the unique combination which doesn't contain duplicates and element can be picked once
     * Time complexity will be O(2^t*k*logN). Why extra logN is because we need to convert Set to List and return the result
     * TO overcome above problem we can use the code from line 65 where we will form the subsequence and then find the target
     */
    //Approach1
    private static void combinationSumUniqueUsingSet(int[] arr, int target, List<Integer> combination, Set<List<Integer>> output1, int index) {
        if (index == arr.length) {
            if (target == 0) {
                output1.add(new ArrayList<>(combination));
            }
            return;
        }
        if (arr[index] <= target) {
            combination.add(arr[index]);
            combinationSumUniqueUsingSet(arr, target - arr[index], combination, output1, index + 1);
            combination.remove(combination.size() - 1);
        }
        combinationSumUniqueUsingSet(arr, target, combination, output1, index + 1);
    }

    //Approach 2
    /*
     * In this approach we will take the element and form the sequence and then look for the target. SO , we will pick first element and second element and third element as
     * seen in for loop. Now there is a condition to select the element. First element will be sorted and if we have added element and next element is also same and next element
     * is also same then we will not consider all those elements because we don't want duplicate so simply we will continue inside the loop, Now i>index -> Means already we picked
     * first element and second element is also same as well as third element so this check will make sure only first element is picked
     */
    private static void combinationSumUnique(int[] arr, int target, List<Integer> combination, List<List<Integer>> output2, int index) {
        if (target == 0) {
            output2.add(new ArrayList<>(combination));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;
            combination.add(arr[i]);
            combinationSumUnique(arr, target - arr[i], combination, output2, index + 1);
            combination.remove(combination.size() - 1);
        }
    }

    /*
     * Print the sum of all subsequence in increasing order. We will pick/not-pick the element and then form the subset and add the subset
     */
    private static void sumOfAllSubsetIncreasingOrder(int index, int[] arr, List<Integer> output, int sum) {
        if (index >= arr.length) {
            output.add(sum);
            return;
        }
        sumOfAllSubsetIncreasingOrder(index + 1, arr, output, sum + arr[index]);
        sumOfAllSubsetIncreasingOrder(index + 1, arr, output, sum - arr[index]);
    }

    /*
     * Print all subset but duplicate subset is not allowed. For ex: Input[] = [1,2,2]. Subset will be [], [1], [2], [2], [1, 2], [1, 2], [2,2], [1,2,2].
     * Since [2] and [1,2] is repeating so it cannot be the part of final solution
     * So solution will be same just we will use Set to remove duplicates
     * Time Complexity = O(2^N*N)
     */
    private static void subsetWithNoDuplicate(int[] arr, int index, Set<List<Integer>> output, List<Integer> combination) {
        if(index >= arr.length) {
            output.add(new ArrayList<>(combination));
            return;
        }
        combination.add(arr[index]);
        subsetWithNoDuplicate(arr, index + 1, output, combination);
        combination.remove(combination.size() - 1);   // we are removing because we want the original state of the array
        subsetWithNoDuplicate(arr, index + 1, output, combination);
    }
}
