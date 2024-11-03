package Tree;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.left.left = new Node(5);
        root.left.right = new Node(6);
        root.left.left.left = new Node(7);
        root.right = new Node(9);
        root.right.right = new Node(60);
        root.right.right.left = new Node(20);
        root.right.right.right = new Node(30);
        //Approach1
        int node1 = 9, node2 = 30;
        List<Node> path1 = new ArrayList<>();
        List<Node> path2 = new ArrayList<>();
        //If any of the node is not present then there will not be any common ancestor so return directly
        /*if(!lowestCommonAncestor(root, path1, node1) || !lowestCommonAncestor(root, path2, node2)) {
            return;
        }
        //Now we need to iterate both the array to find LCA
        int i = 0;
        while (i < path1.size() && i < path2.size()) {
            // Stop when the nodes at this position are different
            if (path1.get(i) != path2.get(i)) {
                break;
            }
            i++;
        }
        if (i > 0) {
            System.out.println("Lowest Common Ancestor: " + path1.get(i - 1).key);
        } else {
            System.out.println("No common ancestor found.");
        }*/

        //Approach2
        Node ancestor = lowestCommonAncestorApproach2(root, node1, node2);
        System.out.println(ancestor.key);
    }

    //Approach2
    //In the same traversal we will find the common ancestor. Anytime if a node left child and right child returns node1 and node2 it means beneath current node two nodes
    //are present and this is our LCA. if left child return null then we will return right child because may be right child contains the any of the required node
    private static Node lowestCommonAncestorApproach2(Node root, int node1, int node2) {
        if(root == null) return null;
        if(root.key == node1 || root.key == node2) return root;
        Node left = lowestCommonAncestorApproach2(root.left, node1, node2);
        Node right = lowestCommonAncestorApproach2(root.right, node1, node2);
        if(left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;        //this means left and right node has return something which is not null basically the current node is LCA
        }
    }

    //Approach 1: we need to traverse the tree from root to the required node and add the path in path array and same we have to do for other node, finally we will have
    //path1[] and path2[]. Now we will iterate one by one in both the array and whenever we see different element it means previous element was the LCA. If both the elements are
    //matching it means they have common ancestor for top but, we need to find the node from bottom which will be LCA.
    //Time Complexity is O(N + N + N) since it needs two traversal to find the path of two nodes plus traverse the arraylist. Space Complexity is O(N)
    private static boolean lowestCommonAncestor(Node root, List<Node> paths, int node) {
        if(root == null) return false;
        paths.add(root);
        if(root.key == node) return true;
        if(lowestCommonAncestor(root.left, paths, node) || lowestCommonAncestor(root.right, paths, node)) {
            return true;
        }
        paths.remove(paths.size() - 1);
        return false;
    }
}
