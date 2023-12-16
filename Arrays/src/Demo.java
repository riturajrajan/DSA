import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {
    public static int sumNum;
    public static void main(String[] args) {
        String s = "ABCDCB";
        System.out.println(sum(s, 0, s.length()-1));
    }

    public static boolean sum(String s, int start, int end) {
        if(start == end) return true;
        if(s.charAt(start) == s.charAt(end)) {
            return sum(s, start+1, end-1);
        }
        return false;
    }

}
