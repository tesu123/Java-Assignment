import java.util.Stack;

public class BinaryTreePaths {
    class Node {
        public int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    Stack<Integer> st = new Stack<>();

    public void getPath(Node root) {
        if (root == null)
            return;

        st.push(root.val);

        getPath(root.left);

        if (root.left == null && root.right == null) {
            System.out.println("Path is");
            System.out.println(st);
        }

        getPath(root.right);
        st.pop();
    }

    public static void main(String[] args) {
        BinaryTreePaths tree = new BinaryTreePaths();
        Node root = tree.new Node(10);
        root.left = tree.new Node(56);
        root.right = tree.new Node(35);
        root.left.left = tree.new Node(77);
        root.right.right = tree.new Node(50);
        root.left.right = tree.new Node(60);
        root.right.left = tree.new Node(14);
        root.left.left.left = tree.new Node(5);

        tree.getPath(root);
    }
}