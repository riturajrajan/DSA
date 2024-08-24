import java.util.*;

public class Demo {
    public static void main(String[] args) {
        int[] arr = {100, 90, 80, 60, 50, 10};
        int low = 0, high = arr.length - 1, num = 10;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] == num){
                System.out.println(mid);
                return;
            } else if(arr[mid] > num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
    }
}