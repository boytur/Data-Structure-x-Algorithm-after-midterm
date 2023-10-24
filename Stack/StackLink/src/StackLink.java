
class StackLink implements Stack {

    public class Node {
        public int data;
        public Node link;

        public Node(int d, Node l) {
            this.data = d;
            this.link = l;
        }
    }

    private Node top = null;
    private int count;

    @Override
    public void push(Object value) {
        Node newNode = new Node((Integer) value, top);
        top = newNode;
        count++;
    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            throw new RuntimeException("is empty");
        }
        int poppedData = top.data;
        top = top.link;
        count--;
        return poppedData;
    }

    @Override
    public Object peek() {
        if (isEmpty()) {
            throw new RuntimeException("is empty");
        }
        return top.data;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void show() {
        Node nodeCurrent = top;
        System.out.print("[");
        while (nodeCurrent != null) {
            System.out.print(nodeCurrent.data);
            if (nodeCurrent.link != null) {
                System.out.print(", ");
            }
            nodeCurrent = nodeCurrent.link;
        }
        System.out.println("]");
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }
}




