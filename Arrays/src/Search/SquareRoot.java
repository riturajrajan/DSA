package Search;

public class SquareRoot {
    public static void main(String[] args) {
        /* We can use binary search here because we have a increasing number and idea here is if we multiply mid * mid and it is same as num then mid is the square root
           if mid * mid > num it means we need to reduce high and if mid * mid is less than num then there can be multiple cases which satisfy the case like 2*2 and 3*3 will
           be the output for num=14. So, we will store all possible answer and move towards bigger number by doing low=mid+1. Time Complexity is O(logN)
         */

         int num = 900;
         int low = 1, high = num, mid = 0, ans = -1;
         while (low <= high) {
            mid = (low + high) / 2;
            int midSquare = mid * mid;
            if(midSquare == num) {
                System.out.println(mid);
                return;
            } else if(midSquare > num) {
                high = mid - 1;
            } else {
                ans = mid;
                low = mid + 1;
            }
         }
        System.out.println(ans);
    }
}
