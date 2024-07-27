import java.util.*;

public class RopeCutting {
    public static void main(String[] args) {
        int ropeLength = 23;
        int cut1 = 12, cut2 = 9, cut3 = 11;
        System.out.println(findMaxCuts(ropeLength, cut1, cut2, cut3));
    }

    private static int findMaxCuts(int ropeLength, int cut1, int cut2, int cut3) {
        if(ropeLength == 0) return 0;
        if(ropeLength < 0) return -1;
        int totalCuts = Math.max(Math.max(findMaxCuts(ropeLength - cut1, cut1, cut2, cut3), findMaxCuts(ropeLength - cut2, cut1, cut2, cut3)),
                findMaxCuts(ropeLength - cut3, cut1, cut2, cut3));
        if(totalCuts >= 0) {
            return totalCuts + 1;
        } else {
            return -1;
        }
    }

}