package Search;

public class FindPairTwoPointerApproach {
    public static void main(String[] args) {
        //We will have two pointer one pointing to beginning and one pointing to end. If anytime the arr[low] + arr[high] > elem it means arr[high] we have to neglect because
        //whatever element we take from arr[low] the sum will always be greater so its better to drop arr[high]. Same goes when the sum is smaller than elem, in this case
        //we have to drop arr[low[ and move low++. Time Complexity is O(N)
        int[] arr = {2, 4, 8, 9, 11, 12, 20, 30};
        System.out.println(findPair(arr, 0, arr.length - 1, 23));
    }

    private static boolean findPair(int[] arr, int low, int high, int elem) {
        while(low < high) {
            if(arr[low] + arr[high] == elem) {
                return true;
            } else if(arr[low] + arr[high] > elem) {
                high--;
            } else {
                low++;
            }
        }
        return  false;
    }
}
