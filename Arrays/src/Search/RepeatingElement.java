package Search;

import java.util.Arrays;

public class RepeatingElement {
    public static void main(String[] args) {
        //Allowed elements in the array is less than max(arr[i]) and only one element will be repeating and 0 must be present.
        int[] arr = {3, 1, 0, 2, 4, 3};
        boolean[] visited = new boolean[arr.length - 1]; // check this rule 0 <= arr[max] <= N-1
        Arrays.fill(visited, false);
        System.out.println(findRepeatedElementApproach1(arr, visited));
    }

    //Approach 1: Time Complexity: O(N) and Space Complexity is O(N)
    //in this approach we will create a visited array as false, we will use array element as index in visited array and mark it as true. If the visited array is already
    //marked as true it means that element is repeating so, simply return that element. Its like we are using hashing technique
    private static int findRepeatedElementApproach1(int[] arr, boolean[] visited) {
        for(int i = 0; i < arr.length; i++) {
            if(visited[arr[i]]) return arr[i];
            visited[arr[i]] = true;
        }
        return -1;
    }

    //Approach 2: Time Complexity: O(N) and Space Complexity: O(1)
    //We will use circular node is linked list approach. We will create a list and two pointers slow and fast, slow will move by one node and fast will move by 2 nodes.
    //It means fast pointer will already enter first in the circle and then slow will enter. After sometime both will collide which means we reached the end of circular node.
    //After that we move slow to start of array and fast will be at the end of circular node, then we will move both the pointer by one index and now their intersection will
    //give the repeating element.
    private static int findRepeatedElementApproach2(int[] arr, boolean[] visited) {
        for(int i = 0; i < arr.length; i++) {
            if(visited[arr[i]]) return arr[i];
            visited[arr[i]] = true;
        }
        return -1;
    }
}
