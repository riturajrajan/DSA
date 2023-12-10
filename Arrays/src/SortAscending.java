import java.util.Arrays;

public class SortAscending {

    public static void main(String[] args) {
        int[] arr = {1, 10, 2 , 5 , 88 , 1, 8, 44, 56, 22, 99, 101, 100};

        //Using inbuilt Arrays function
        /*Arrays.sort((arr));
        for (int i: arr) {
            System.out.println(i);
        }*/

        if(arr.length==1) {
            System.out.println(arr[0]);
            return;
        }
        //Iterative approach
        /*
         * keep first element fixed and iterate over array by another loop till the end of the array. Move the top pointer till length-2 becasue
         * when i = arr-len-2 and j = arr.len-1 this statement itself is doing the comparison for the last two element.
         * Inbetween swap the element if i > j
         */
        int temp;

        /*for(int i = 0; i <= arr.length-2; i++) {
            for(int j = i+1; j<= arr.length-1; j++) {
                if(arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        for(int i: arr) {
            System.out.println(i);
        }*/

        //Recursive Approach
        ascendingArray(arr, 0, arr.length);
        for (int i : arr){
            System.out.println(i);
        }
    }

    public static void ascendingArray(int[] arr, int parentIndex, int length) {
        if(parentIndex == length-1) {
            return;
        }
        int j = parentIndex +1, temp;
        while(j <= length-1) {
            if(arr[parentIndex] > arr[j]) {
                temp = arr[j];
                arr[j] = arr[parentIndex];
                arr[parentIndex] = temp;
            }
            j++;
        }
        ascendingArray(arr, ++parentIndex, length);

    }
}
