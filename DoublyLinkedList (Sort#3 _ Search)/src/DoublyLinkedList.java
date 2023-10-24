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
    private static final int TABLE_SIZE = 101;

    private Node[] hashTable = new Node[TABLE_SIZE];

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
        int hashCode = calculateHashCode(value);
        if (hashTable[hashCode] == null) {
            hashTable[hashCode] = newNode;
        }
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
    public void sort_merge() {
        if (head != null && head != tail) {
            head = mergeSort(head);
            Node current = head;
            while (current.link != null) {
                current.link.plink = current;
                current = current.link;
            }
            tail = current; // Update the tail to the last node
        }
    }
    private Node getMiddle(Node start) {
        if (start == null) {
            return null;
        }

        Node slow = start;
        Node fast = start;

        while (fast.link != null && fast.link.link != null) {
            slow = slow.link;
            fast = fast.link.link;
        }

        return slow;
    }

    private Node mergeSort(Node start) {
        if (start == null || start.link == null) {
            return start;
        }

        Node middle = getMiddle(start);
        Node nextToMiddle = middle.link;

        middle.link = null;

        Node left = mergeSort(start);
        Node right = mergeSort(nextToMiddle);

        return merge(left, right);
    }

    private Node merge(Node left, Node right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        if (Integer.parseInt(left.data.toString()) <= Integer.parseInt(right.data.toString())) {
            left.link = merge(left.link, right);
            left.link.plink = left;
            return left;
        } else {
            right.link = merge(left, right.link);
            right.link.plink = right;
            return right;
        }
    }

    @Override
    public int search_sequential(Object value) {
        Node current = head;
        int index = 1;
        while (current != null) {
            if (current.data.equals(value)) {
                return index - 1;
            }
            current = current.link;
            index++;
        }
        return -1;
    }

    @Override
    public int search_binary(Object value) {
        sort_merge();
        int left = 1;
        int right = count;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            Object midValue = get(mid);
            int comparison = Integer.parseInt(midValue.toString()) - Integer.parseInt(value.toString());
            if (comparison == 0) {
                return mid-1;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    @Override
    public int search_hashing(Object value) {
        int hashCode = calculateHashCode(value);
        Node current = hashTable[hashCode];
        int index = 1;

        while (current != null) {
            if (current.data.equals(value)) {
                return index + 2;
            }
            current = current.link;
            index++;
        }
        return -1;
    }
    private int calculateHashCode(Object value){
        return value.toString().hashCode() % TABLE_SIZE;
    }
}