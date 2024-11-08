package Tree;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class PairSumBST {
    //Idea here we will store the difference of visited node with sum in hashtable if this is not present then we add the current node into hashtable. We continue the process
    //until the other pair is find in hashtable
    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.right.right = new Node(80);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.left.right = new Node(65);
        root.right.left.left = new Node(55);
        Set<Integer> ds = new HashSet<>();
        System.out.println(pairSum(root, ds, 20));
    }

    private static boolean pairSum(Node root, Set<Integer> ds, int sum) {
        if(root == null) return false;
        if(pairSum(root.left, ds, sum)) return true;
        if(ds.contains(sum - root.key)) return true;
        else ds.add(root.key);
        return pairSum(root.right, ds, sum);
    }
}
