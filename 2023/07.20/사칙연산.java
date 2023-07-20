import java.io.*;
import java.util.*;

public class 사칙연산 {
    static int n; // 정점의 총 수
    static Tree tree; // 트리


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            n = Integer.parseInt(br.readLine());
            tree = new Tree();

            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String data = st.nextToken();
                int leftIndex = 0;
                int rightIndex = 0;

                if (st.countTokens() == 2) {
                    leftIndex = Integer.parseInt(st.nextToken());
                    rightIndex = Integer.parseInt(st.nextToken());
                }

                tree.add(i, data, leftIndex, rightIndex);
            }

            System.out.println("#" + t + " " + (int) tree.inOrder(tree.root));
        }

    }

    static class Node {
        int index;
        String data;
        Node leftNode;
        Node rightNode;

        public Node(int index) {
            this.index = index;
            this.data = "";
            leftNode = null;
            rightNode = null;
        }
    }

    static class Tree {
        Node root = null;

        public void add(int index, String data, int left, int right) {
            if (root == null) {
                root = new Node(index);
                root.data = data;
                if (left != 0) root.leftNode = new Node(left);
                if (right != 0) root.rightNode = new Node(right);
            } else {
                search(root, index, data, left, right);
            }
        }

        public void search(Node root, int index, String data, int left, int right) {
            if (root.index == index) {
                root.data = data;
                if (left != 0) root.leftNode = new Node(left);
                if (right != 0) root.rightNode = new Node(right);
            } else {
                if (root.leftNode != null) search(root.leftNode, index, data, left, right);
                if (root.rightNode != null) search(root.rightNode, index, data, left, right);
            }
        }

        public double inOrder(Node root) {
            String curData = root.data;
            double left = 0;
            double right = 0;
            double result = 0;

            if (root.leftNode.leftNode == null) {
                left = Double.parseDouble(root.leftNode.data);
            } else {
                left = inOrder(root.leftNode);
            }

            if (root.rightNode.rightNode == null) {
                right = Double.parseDouble(root.rightNode.data);
            } else {
                right = inOrder(root.rightNode);
            }

            if (curData.equals("+")) {
                result = left + right;
            } else if (curData.equals("-")) {
                result = left - right;
            } else if (curData.equals("*")) {
                result = left * right;
            } else if (curData.equals("/")) {
                result = left / right;
            }
            return result;
        }
    }
}
