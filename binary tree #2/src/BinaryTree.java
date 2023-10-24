public class BinaryTree {
    class node{
        Object data;
        node left;
        node right;
        int height;

        node(Object data){
            this.data = data;
            this.left = null;
            this.right = null;
            height = 0;
        }

        boolean isLeaf(){
            return left == null && right == null;
        }
    }

    node root;
    BinaryTree(){
        root = null;
    }

    boolean isFullBinaryTree(node leaf){
        if(leaf.isLeaf()){
            return true;
        }
        if((leaf.left != null && leaf.right == null) || (leaf.left == null && leaf.right != null)){
            return false;
        }
        return isFullBinaryTree(leaf.left) && isFullBinaryTree(leaf.right);
    }

    boolean isBalancedBinaryTree(node leaf) {
        if (leaf == null) {
            return true;
        }

        int balanceFactor = balanceFector(leaf);
        return balanceFactor >= -1 && balanceFactor <= 1 &&
                isBalancedBinaryTree(leaf.left) && isBalancedBinaryTree(leaf.right);
    }

    void insert(Object value){
        root = insert(root,value);
    }


    void delete(Object value){
        root = delete(root,value);
    }
    int height(node leaf){
        if(leaf == null){
            return 0;
        }
        return leaf.height;
    }
    int balanceFector(node leaf){
        if(leaf == null){
            return 0;
        }
        return height(leaf.left) - height(leaf.right);
    }
    void updateHeight(node leaf){
        if(leaf != null){
            leaf.height = 1 + Math.max(height(leaf.left),height(leaf.right));
        }
    }
    node rotateRight(node y){
        node x = y.left;
        node T2 = x.right;
        x.right = y;
        y.left = T2;
        updateHeight(y);
        updateHeight(x);
        return x ;
    }
    node rotateLeft(node x){
        node y = x.left;
        node T2 = y.right;
        y.left = x ;
        x.right = T2;
        updateHeight(x);
        updateHeight(y);
        return y ;
    }
    node balance (node leaf){
        updateHeight(leaf);
        int balanceFactornode = balanceFector(leaf);
        if(balanceFactornode > 1){
            if (balanceFector(leaf.left) < 0){
                leaf.left = rotateLeft(leaf.left);
            }
            return rotateRight(leaf);
        }
        if (balanceFactornode < -1){
            if(balanceFector(leaf.right) > 0){
                leaf.right = rotateRight(leaf.right);
            }
            return rotateLeft(leaf);
        }
        return leaf;
    }
    node findMin(node leaf){
        while (leaf.left != null){
            leaf = leaf.left;
        }
        return leaf;
    }
    node insert(node leaf, Object value) {
        if (leaf == null) {
            return new node(value);
        }

        if (Integer.parseInt(value.toString()) < Integer.parseInt(leaf.data.toString())) {
            leaf.left = insert(leaf.left, value);
        } else if (Integer.parseInt(value.toString()) > Integer.parseInt(leaf.data.toString())) {
            leaf.right = insert(leaf.right, value);
        } else {
            return leaf;
        }

        return balance(leaf);
    }
    node delete(node leaf,Object value) {
        if (leaf == null) {
            return null;
        }
        node temp;
        if (Integer.parseInt(value.toString()) < Integer.parseInt(leaf.data.toString())) {
            leaf.left = delete(leaf.left, value);
        } else if (Integer.parseInt(value.toString()) > Integer.parseInt(leaf.data.toString())) {
            leaf.right = delete(leaf.right, value);
        } else {
            if (leaf.left == null || leaf.right == null) {
                temp = (leaf.left != null) ? leaf.left : leaf.right;
                if(temp == null){
                    temp = leaf;
                    leaf = null;
                }else {
                    leaf = temp;
                }
            }else {
                temp = findMin(leaf.right);
                leaf.data = temp.data;
                leaf.right = delete(leaf.right,temp.data);
            }
        }
        if(leaf == null) {
            return null;
        }
        return balance(leaf);
    }
    void printPreOrder(node leaf){
        if(leaf == null) return;
        System.out.print(leaf.data + " ");
        printPreOrder(leaf.left);
        printPreOrder(leaf.right);
    }

    void printInOrder(node leaf){
        if(leaf == null) return;
        printInOrder(leaf.left);
        System.out.print(leaf.data + " ");
        printInOrder(leaf.right);
    }
    void printPostOrder(node leaf){
        if(leaf == null) return;
        printPostOrder(leaf.left);
        printPostOrder(leaf.right);
        System.out.print(leaf.data + " ");
    }

    boolean search(Object value){
        return false;
    }
    void destroyTree(node leaf){
        if (leaf == null) return;
        // find left
        if (leaf.left != null) {
            destroyTree(leaf.left);
            // process
            leaf.left = null;
        }
        // find right
        if (leaf.right != null) {
            destroyTree(leaf.right);
            // process
            leaf.right = null;
        }
        // set root is null
        if(root.isLeaf()){
            root = null;
        }
    }
}

