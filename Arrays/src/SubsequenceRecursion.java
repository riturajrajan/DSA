import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsequenceRecursion {

    /*
     * For sequence think of take/not-take approach
     */
    public static void main(String[] args) {

        int[] arr = {1, 2, 1};
        int index = 0;
        List<Integer> output = new ArrayList<>();
        printSubsequence(arr, index, output);
        printSubsequenceSumK(arr, index, output, 2);
        printSubsequenceSumCarrying(arr, index, output, 2, 0);
        printOneSubsequenceSum(arr, index, output, 2, 0);
    }

    private static void printSubsequence(int[] arr, int index, List<Integer> output) {
        if(index >= arr.length) {
            System.out.println(output);
            return;
        }
        output.add(arr[index]);
        printSubsequence(arr, index+1, output);
        output.remove(output.size()-1);   // we are removing because we want the original state of the array
        printSubsequence(arr, index+1, output);
    }

    /*
     * Print the sequence whose sum is equal to k. Now in the above code we are forming the sequence and adding
     * same in the output list. So, we can check if the sum is 2 then print only that element
     */
    //Approach 1 without carrying the sum
    private static void printSubsequenceSumK(int[] arr, int index, List<Integer> output, int targetSum) {
        if(index >= arr.length) {
            if(output.stream().reduce(0, (acc, element) -> acc + element) == targetSum) {
                System.out.println(output.toString());
            }
            return;
        }
        output.add(arr[index]);
        printSubsequenceSumK(arr, index+1, output, targetSum);
        output.remove(output.size()-1);   // we are removing because we want the original state of the array
        printSubsequenceSumK(arr, index+1, output, targetSum);
    }

    //Approach 2
    private static void printSubsequenceSumCarrying(int[] arr, int index, List<Integer> output, int targetSum, int sum) {
        if(index >= arr.length) {
            if(sum == targetSum) {
                System.out.println(output.toString());
            }
            return;
        }
        output.add(arr[index]);
        sum += arr[index];
        printSubsequenceSumCarrying(arr, index+1, output, targetSum, sum);
        output.remove(output.size()-1);   // we are removing because we want the original state of the array
        sum -= arr[index];
        printSubsequenceSumCarrying(arr, index+1, output, targetSum, sum);
    }

    /*
     * Instead of printing the whole sequence just print one sequence
     */

    private static boolean printOneSubsequenceSum(int[] arr, int index, List<Integer> output, int targetSum, int sum) {
        if(index >= arr.length) {
            if(sum == targetSum) {
                System.out.println(output.toString());
                return true;
            }
            return false;
        }
        output.add(arr[index]);
        sum += arr[index];
        if(printOneSubsequenceSum(arr, index+1, output, targetSum, sum)) return true;
        output.remove(output.size()-1);   // we are removing because we want the original state of the array
        sum -= arr[index];
        if(printOneSubsequenceSum(arr, index+1, output, targetSum, sum)) return true;
        return false;
    }
}
