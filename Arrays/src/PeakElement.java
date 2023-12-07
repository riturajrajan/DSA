import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PeakElement {
    public static void main(String[] args) {

        // First Approach

        /* Three cases can be arrived
         * 1. If array has one length
         * 2. If array has first element as greater or last element as greater. This is handled in line 27 and 39
         * 3. If array has more than 3 elemets then it will pass through all condition but if the elements is greater
         *    in the middle will be decided by while()
         */
        int[] neighbours = {40, 30, 20 , 10};
        int prevIndex = 0, currIndex = 0, nextIndex = 1;
        int arrLen = neighbours.length;
        List<Integer> output = new ArrayList<Integer>();
        //If the list contains only single element
        if(arrLen == 1) {
            System.out.println(neighbours[0]);
            return;
        }
        /* If the list contains more than 1 element then in that case we will point the currentIndex to 0 and nextIndex to
         * 1. So, basically the line 21 will check for 2 elements. If out of 2 one is greater than add into output array.
         * Then proceed with moving the pointer. see line 25

         */
        if(neighbours[currIndex] > neighbours[nextIndex]) {
            output.add(neighbours[currIndex]);
            currIndex++;            //Increase the pointer so that while loop start with
            nextIndex++;            //latest index because comparion start here if element has more than 1 element
        }
        while(nextIndex < arrLen-1) {
            prevIndex = currIndex;
            currIndex = nextIndex;
            nextIndex = nextIndex + 1;
            if(neighbours[currIndex] >= neighbours[prevIndex] && neighbours[currIndex] >= neighbours[nextIndex]) {
                output.add(neighbours[currIndex]);
            }
        }
        // This condition is used to test for last element
        if(neighbours[arrLen-1] > neighbours[arrLen-2]) {
            output.add(neighbours[arrLen-1]);
        }
        System.out.println(output);

        //Second Approach
        /*
         * The main of this approach is to make an array with 3 elements and keep the first & last element as the
         * smallest element in the array and then the code flows like above while loop in line 34
         */
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter size of array");
        int N = scan.nextInt();
        int[] arr = new int[N + 2];
        /* set corner values to -infinity */
        arr[0] = Integer.MIN_VALUE;
        arr[N + 1] = Integer.MIN_VALUE;

        /* Accept N elements */
        System.out.println("Enter "+ N +" elements");
        for (int i = 1; i <= N; i++)
            arr[i] = scan.nextInt();

        /* Find All Peak Elements */
        System.out.println("\nAll Peak Elements : ");
        for (int i = 1; i <= N; i++)
            if (arr[i - 1] <= arr[i] && arr[i] >= arr[i + 1])
                System.out.println(arr[i] +" at position "+ i);

        System.out.println();
    }
}
