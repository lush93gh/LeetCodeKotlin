package hackerrank;

public class TreeHuffmanDecoding {
    private static class Node {
        public int frequency; // the frequency of this tree
        public char data;
        public Node left, right;
    }

    class Pair<T1, T2> {
        T1 first;
        T2 second;

        public Pair(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }
    }

    void decode(String s, Node root) {
        StringBuilder sb = new StringBuilder();
        Integer index = 0;
        while (index < s.length()) {
            Pair<String, Integer> result = traverse(root, s, index);
            if (result.first.length() > 0) {
                sb.append(result.first);
            }
            index = result.second;
        }
        System.out.println(sb);
    }

    Pair<String, Integer> traverse(Node root, String s, int index) {
        if (root != null) {
            if (root.data != '\0') {
                return new Pair<>(String.valueOf(root.data), index + 1);
            } else if (index < s.length()) {
                char code = s.charAt(index);
                if (code == '0') {
                    return traverse(root.left, s, index + 1);
                } else if (code == '1') {
                    return traverse(root.right, s, index + 1);
                }
            }
        }
        return new Pair<>("", index);
    }
}
