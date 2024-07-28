package Arrays;

import java.util.Arrays;

public class MoveZeroToEnd {
    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 20, 40, 0};
        int count = 0, temp = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;
                count++;
            }
        }
        Arrays.stream(arr).forEach(System.out::println);
    }
}
