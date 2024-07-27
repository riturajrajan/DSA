package Recursion;

import java.util.Arrays;

public class JosephKilling {
    public static void main(String[] args) {
        System.out.println(findSurvivor(5, 3));
    }

    private static int findSurvivor(int people, int killingIndex) {
        if(people == 1) return 0;
        return (killingIndex + findSurvivor(people - 1, killingIndex)) % people;
    }
}
