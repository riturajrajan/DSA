package Arrays;

public class StockBuySell {
    public static void main(String[] args) {
        //Approach 1: First element consider you are buying. If the next element is increasing then just increase the pointer because the client is making profit. As soon as the number decreases
        //then substract n-1 with buy pointer and then make buy = i because from here again the process starts
        int[] arr = {1, 5, 3, 1, 2, 8};
        int len = arr.length;
        int buy = 0, i = 1, maxGain = 0;
        while(i < len) {
            if(arr[i] < arr[i-1]) {
                maxGain = maxGain + (arr[i-1] - arr[buy]);
                buy = i;
            }
            i++;
        }
        if(i == len && arr[i-1] > arr[i-2]) {       //If the profit is still growing then this block will capture the maxgain
            maxGain = maxGain + (arr[i-1] - arr[buy]);
        }
        System.out.println(maxGain);

        //Approach 2: If the price the i > i-1 we will find the profit and when the price is decreasing we will not do anything
        int profit = 0;
        for(int j = 1; j < len; j++) {
            if(arr[j] > arr[j - 1]) {
                profit += (arr[j] - arr[j - 1]);
            }
        }
        System.out.println(profit);
    }
}
