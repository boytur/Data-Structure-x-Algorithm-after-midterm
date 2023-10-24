public class DoublyLinkedList implements Collection {

    class Node {
        Object data;
        Node link;
        Node plink;

        Node(Object d, Node l, Node pl) {
            data = d;
            link = l;
            plink = pl;
        }
    }

    private Node head;
    private Node tail;
    private int count;

    public DoublyLinkedList() {
        count = 0;
        head = null;
        tail = null;
    }

    @Override
    public void add(Object value) {
        Node newNode = new Node(value, null, tail);
        if (tail != null) {
            tail.link = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = newNode;
        }
        count++;
    }

    @Override
    public void add(int index, Object value) {
        if (index <= 0 || index > count + 1) {
            throw new IndexOutOfBoundsException("out of bound");
        }
        if (index == count+1) {
            add(value);
        } else if (index == 1) {
            Node newNode = new Node(value, head, null);
            head.plink = newNode;
            head = newNode;
            count++;
        } else {
            Node current = head;
            for (int i = 1; i < index; i++) {
                current = current.link;
            }
            Node newNode = new Node(value, current, current.plink);
            current.plink.link = newNode;
            current.plink = newNode;
            count++;
        }
    }

    @Override
    public Object get(int index) {
        if (index <= 0 || index > count) {
            throw new IndexOutOfBoundsException("out of bound");
        }
        Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.link;
        }
        return current.data;
    }

    @Override
    public void set(int index, Object value) {
        if (index <= 0 || index > count) {
            throw new IndexOutOfBoundsException("out of bound");
        }
        Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.link;
        }
        current.data = value;
    }

    @Override
    public void remove(Object value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                if (current.plink != null) {
                    current.plink.link = current.link;
                } else {
                    head = current.link;
                }
                if (current.link != null) {
                    current.link.plink = current.plink;
                } else {
                    tail = current.plink;
                }
                count--;
            }
            current = current.link;
        }
    }

    public boolean find(Object value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.link;
        }
        return false;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public void show() {
        Node current = head;
        System.out.print("[ ");
        while (current != null) {
            System.out.print(current.data);
            if(current.link != null){
                System.out.print(", ");
            }else{
                System.out.print(" ");
            }
            current = current.link;
        }
        System.out.println("]");
    }

    public void show_backward() {
        Node current = tail;
        System.out.print("[ ");
        while (current != null) {
            System.out.print(current.data);
            if(current.plink != null){
                System.out.print(", ");
            }else{
                System.out.print(" ");
            }
            current = current.plink;
        }
        System.out.println("]");
    }

    @Override
    public void sort_radix() {
        if (count > 1) {
            int max = Integer.MIN_VALUE;
            Node current = head;
            while (current != null) {
                int num = Integer.parseInt(current.data.toString());
                if (num > max) {
                    max = num;
                }
                current = current.link;
            }

            for (int exp = 1; max / exp > 0; exp *= 10) {
                radixSortByDigit(exp);
            }
        }
    }
    private void radixSortByDigit(int exp) {
        int n = count;
        java.util.LinkedList<Object>[] buckets = new java.util.LinkedList[10];
        for (int i = 0; i < 10; i++) {
            buckets[i] = new java.util.LinkedList<>();
        }

        for (int i = 0; i < n; i++) {
            Node current = head;
            for (int j = 0; j < i; j++) {
                current = current.link;
            }
            int num = Integer.parseInt(current.data.toString());
            int index = (num / exp) % 10;
            buckets[index].addLast(current.data);
        }
        Node current = head;
        for (int i = 0; i < 10; i++) {
            java.util.LinkedList<Object> bucket = buckets[i]; // Use fully qualified name
            while (!bucket.isEmpty()) {
                current.data = bucket.removeFirst();
                current = current.link;
            }
        }
    }
    @Override
    public void sort_insertion() {
        if (count <= 1) {
            return;
        }

        Node current = head.link;
        while (current != null) {
            Node key = current;
            Object keyValue = key.data;
            Node prev = current.plink;

            while (prev != null && Integer.parseInt(prev.data.toString()) > Integer.parseInt(keyValue.toString())) {
                prev.link.data = prev.data;
                prev = prev.plink;
            }
            if (prev != null) {
                prev.link.data = keyValue;
            } else {
                head.data = keyValue;
            }

            current = current.link;
        }
    }
}