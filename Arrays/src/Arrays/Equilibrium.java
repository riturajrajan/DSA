package Arrays;

public class Equilibrium {
    public static void main(String[] args) {
        //Idea here is to first calculate the total sum of the array. Once total sum is calculated we need to maintain leftSum and rightSum. Dominating will be rightSum, we will start
        //removing from rightSum and check if they are equal and if not equal then we add current element to leftSum and continue the iteration
        int[] arr = {3, 4, 8, -9, 20, 6};
        int len = arr.length, rightSum = 0, leftSum = 0;
        for(int i = 0; i < len; i++) {
            rightSum += arr[i];
        }
        for(int i = 0; i < len; i++) {
            rightSum = rightSum - arr[i];
            if(rightSum == leftSum) {
                System.out.println("Yes");
            }
            leftSum = leftSum + arr[i];
        }
    }
}
