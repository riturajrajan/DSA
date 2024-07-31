package Arrays;

public class MinGroupFlip {
    public static void main(String[] args) {
        //Approach 1: There is a hidden pattern, if you see if the number starting with 0 then minimum flips can be achieved by 1's flips and vice versa. In short the second group flips will
        //always give the minimum flips
        int[] arr = {0, 0, 1, 1, 0, 0, 1, 1};
        int len = arr.length, res = arr[0] == 1 ? 0 : 1, i = 1;
        while(i < len) {
            if(res == arr[i]) {
                System.out.print("From " + i);
                i++;
                while(i < len && arr[i] == res) {
                    i++;
                }
                System.out.println(" to " + (i-1));
            }
            i++;
        }

        //Approach 2: Follow this approach
        for(int j = 1; j < len; j++) {
            if(arr[j] != arr[j-1]) {
                if(arr[j] != arr[0]) {  // We need to check whether this is the starting of second group. If yes then we need to print "from" else "to"
                    System.out.print("From " + j + " to ");
                } else {
                    System.out.println(j-1);
                }
            }
        }
        if(arr[len-1] != arr[0]){
            System.out.println(len -1);
        }
    }
}
