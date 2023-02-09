package weivretni.yapyap;

class SumTree {
    boolean isSumTree(Node root) {
        if (isLeafNode(root)) return true;
        else {
            int left = root.left != null ? root.left.data : 0;
            int right = root.right != null ? root.right.data : 0;
            int sum = 0;
            if (isLeafNode(root.left)) {
                sum += left;
            } else {
                sum += left * 2;
            }
            if (isLeafNode(root.right)) {
                sum += right;
            } else {
                sum += right * 2;
            }
            return isSumTree(root.left) && isSumTree(root.right) && sum == root.data;
        }
    }

    boolean isLeafNode(Node root) {
        return root == null || (root.left == null && root.right == null);
    }
}
