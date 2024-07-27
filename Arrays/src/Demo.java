import java.util.*;

public class Demo {
    public static void main(String[] args) {
        int[] arr = {7, 20, 30, 10, 80, 90};
        reverseArray(arr, 0, arr.length-1);
    }

    private static void reverseArray(int[] arr, int start, int end) {
        if(start >= end) {
            Arrays.stream(arr).forEach(System.out::println);
            return;
        }

        int temp = 0;
        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverseArray(arr, start + 1, end - 1);
    }
}