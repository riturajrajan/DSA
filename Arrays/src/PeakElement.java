import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PeakElement {
    public static void main(String[] args) {

        /* Three cases can be arrived
         * 1. If array has one length
         * 2. If array has first element as greater or last element as greater. This is handled in line 27 and 39
         * 3. If array has more than 3 elements then it will pass through all condition but if the elements is greater
         *    in the middle will be decided by while()
         */
        int[] neighbours = {10, 20, 5};
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
        }
        while(nextIndex != arrLen-1) {
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
    }
}
