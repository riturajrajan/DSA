import java.util.Arrays;

public class SelectionSort {
    private static int temp;

    public static void main(String[] args) {
        int[] arr = {13, 1, 4, 3, 10, 40, 5};
        int min, temp;
        /*
         * Time Complexity is O(n2). We will have one pointer fixed and another pointer will traverse and do the comparison with fixed pointer
         * If it is smaller than swap the element. Carry one till n-2 because for last element sorting is not required as by then array will be sorted
         * Selection sort consumes less memory compare to other sort. If the read operation is critical then don't use selection sort. Let's say write operation
         * is critical like in Flash memory then use selection sort where reading can be compromised but not write
         */
        for(int i = 0; i <=  arr.length-2; i++) {
            //min = arr[i];
            for(int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {             // Either we can use this condition here where swapping happens once the smallest element find out and if there is
                    //min = arr[j];               // still small element then again swapping will happen. Instead of this we can find the min index and then outer of this
                    temp = arr[i];                // for loop we can swap the element
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        selection_sort(0, 1, arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selection_sort(int i, int j, int[] arr) {
        //Approach 1
        if(i == arr.length-1) return;
        if(arr[i] > arr[j]){
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        if(j == arr.length-1) {
            selection_sort(i+1, i+2, arr);
        } else {
            selection_sort(i, j+1, arr);
        }

        //Approach 2
        /*
         * Instead of swapping lets find the min index and then swap the element. By this was we will not have to do intermediate swap.
         * We can do with single pointer. No need of passing j index in this method
         */
        int min = i;
        for(int z = i+1; z < arr.length; z++) {
            if(arr[min] > arr[z]) {
                min = z;
            }
        }
        temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
        if(i + 1 < arr.length) {                     //base condition
            selection_sort(i+1, 0, arr);
        }

    }
}
