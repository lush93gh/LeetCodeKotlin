package treesAndGraphs.binarysearchtree;

import hackerrank.Node;

public class InorderSuccessorInBST {
    boolean hasFound = false;
    Node next = null;

    public Node inorderSuccessor(Node root, Node x) {
        inorder(root, x);
        return next;
    }

    private void inorder(Node root, Node x) {
        if (root.getLeft() != null) inorder(root.getLeft(), x);
        if (hasFound) {
            next = root;
            hasFound = false;
        }
        if (root == x) {
            hasFound = true;
        }
        if (root.getRight() != null) inorder(root.getRight(), x);
    }
}
