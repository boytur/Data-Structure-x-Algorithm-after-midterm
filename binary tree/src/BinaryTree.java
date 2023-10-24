public class BinaryTree {
    class Node {
        private Object data;
        private Node left;
        private Node right;

        Node(Object data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        boolean isLeaf() {
            return left == null && right == null;
        }
    }

    Node root;

    BinaryTree() {
        this.root = null;
    }

    void insert(Object value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, Object value) {
        if (root == null) {
            return new Node(value);
        }
        if (value.hashCode() < root.data.hashCode()) {
            root.left = insertRec(root.left, value);
        } else if (value.hashCode() > root.data.hashCode()) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    void printPreOrder(Node leaf) {
        if (leaf != null) {
            System.out.print(leaf.data + " ");
            printPreOrder(leaf.left);
            printPreOrder(leaf.right);
        }
    }
    void printInOrder(Node leaf) {
        if (leaf != null) {
            printInOrder(leaf.left);
            System.out.print(leaf.data + " ");
            printInOrder(leaf.right);
        }
    }

    void printPostOrder(Node leaf) {
        if (leaf != null) {
            printPostOrder(leaf.left);
            printPostOrder(leaf.right);
            System.out.print(leaf.data + " ");
        }
    }

    boolean search(Object value) {
        return searchRec(root, value);
    }

    private boolean searchRec(Node root, Object value) {
        if (root == null) {
            return false;
        }


        if (value.hashCode() == root.data.hashCode()) {
            return true;
        }  if (value.hashCode()< root.data.hashCode()) {
            return searchRec(root.left, value);
        } else {
            return searchRec(root.right, value);
        }
    }

    void destroyTree(Node leaf) {
       this.root =null;
    }
}
