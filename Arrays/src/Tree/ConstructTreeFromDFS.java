package Tree;

public class ConstructTreeFromDFS {
    //We will use preorder array as the entry point and create a node with preOrder element and look for that element in inorder array. Then we split the array into two half
    //one will be left subtree and one be right subtree. Recursively call for the same until inStart passes inEnd

    public static int preIndex = 0;
    public static void main(String[] args) {
        int[] inorder = {40, 20, 50, 10, 30, 80, 70, 90};
        int[] preorder = {10, 20, 40, 50, 30, 70, 80, 90};
        constructTree(inorder, preorder, 0, inorder.length - 1);
    }

    private static Node constructTree(int[] inorder, int[] preorder, int inStart, int inEnd) {
        if(inStart > inEnd) return null;
        Node root = new Node(preorder[preIndex++]);
        int index = -1;
        for(int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == root.key) {
                index = i;
                break;
            }
        }
        root.left = constructTree(inorder, preorder, inStart, index - 1);
        root.right = constructTree(inorder, preorder, index + 1, inEnd);
        return root;
    }
}
