import java.util.*;

public class Demo {
    public static void main(String[] args) {
        List<LinkedList<Integer>> num = new ArrayList<>();
        LinkedList<Integer> myList = new LinkedList<>();
        myList.add(10);
        num.add(new LinkedList<>());
        num.get(0).add(10);
    }

}