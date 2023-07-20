
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 중위순회 {
    static int N;
    static Tree tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int tc = 1; tc <= 10; tc++) {
            N = Integer.parseInt(br.readLine());
            tree = new Tree();

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                char data = st.nextToken().charAt(0);
                int left = 0;
                int right = 0;

                if(st.countTokens() == 2){
                    left = Integer.parseInt(st.nextToken());
                    right = Integer.parseInt(st.nextToken());
                } else if(st.countTokens() == 1){
                    left = Integer.parseInt(st.nextToken());
                }

                tree.add(i, data, left, right);
            }

            System.out.printf("#%d ", tc);
            tree.inOrder(tree.root);
            System.out.println();
        }
    }

    static class Node {
        int index;
        char data;
        Node left;
        Node right;

        public Node(int index) {
            this.index = index;
            this.data = ' ';
            left = null;
            right = null;
        }
    }

    static class Tree {
        Node root = null;

        public void add(int index, char data, int left, int right) {
            if (root == null) {
                root = new Node(index);
                root.data = data;
                if (left != 0) root.left = new Node(left);
                if (right != 0) root.right = new Node(right);
            } else {
                search(root, index, data, left, right);
            }
        }

        public void search(Node root, int index, char data, int left, int right) {
            if (root.index == index) {
                root.data = data;
                if (left != 0) root.left = new Node(left);
                if (right != 0) root.right = new Node(right);
            } else {
                if (root.left != null) search(root.left, index, data, left, right);
                if (root.right != null) search(root.right, index, data, left, right);
            }
        }

        public void inOrder(Node root) {
            if (root.left != null) inOrder(root.left);
            System.out.print(root.data);
            if (root.right != null) inOrder(root.right);
        }
    }
}
