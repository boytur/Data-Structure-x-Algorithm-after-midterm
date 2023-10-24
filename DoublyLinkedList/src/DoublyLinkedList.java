import java.util.StringJoiner;

public class DoublyLinkedList implements Collection {
    private Node head;
    private Node tail;
    private int size;

    private static class Node {
        int value;
        Node prev;
        Node next;

        Node(int value, Node L ,Node P) {
            this.next=L;
            this.prev=P;
            this.value = value;
        }
    }
    @Override
    public void add(int value) {
        Node newNode = new Node(value,null,null);
        if(head==null){
            head=newNode;
            tail=newNode;
        }else {
            newNode.prev=tail;
            tail.next=newNode;
            tail=newNode;
        }
        size++;
    }

    @Override
    public void add(int index, int value) {
        Node new_node = new Node(value, null,null);
        if(index>size+1||index<1) {
            throw new IndexOutOfBoundsException("out of bound");
        } else if (index==size()+1) {
            add(value);
        } else if (index==1) {
            Node ptemp=head;
            head = new_node;
            new_node.next = ptemp;
            ptemp.prev = new_node;
            size++;
        } else {
            Node temp = head;
            for (int i=1;i<=size();i++){
                if(index==i) {
                    Node ptemp=temp.prev;
                    ptemp.next=new_node;
                    temp.prev=new_node;
                    new_node.next=temp;
                    new_node.prev=ptemp;
                }
                temp=temp.next;
            }
            size++;
        }
    }

    @Override
    public int get(int index) {
        if (index == 0 || index > size) {
            throw new IndexOutOfBoundsException("out of bound");
        }

        Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }

        return current.value;
    }

    @Override
    public void set(int index, int value) {
        if (index <= 0 || index > size) {
            throw new IndexOutOfBoundsException("out of bound");
        }

        Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }

        current.value = value;
    }

    @Override
    public void remove(int value) {
        Node temp=head;
        for(int i=1;i<=size();i++){
            if(value==head.value){
                head=head.next;
                head.prev=null;
                size--;
            } else  if (tail.value==value) {
                tail = tail.prev;
                tail.next = null;
                size--;
            }else if(temp.value==value){
                temp.prev.next=temp.next;
                temp.next.prev=temp.prev;
                size--;
            }
            temp=temp.next;
        }
    }

    @Override
    public boolean find(int value) {
        Node current = head;
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void show() {
        Node newNode = head;
        System.out.print("[");
        while (newNode!=null){
            System.out.print(" "+newNode.value);
            newNode = newNode.next;
            if(newNode!=null){
                System.out.print(",");
            }
        }
        if(isEmpty()){
            System.out.println(" ]");
        }else {
            System.out.println(" ]");
        }
    }


    @Override
    public void show_backward() {
        if(isEmpty()){
            System.out.println("[ ]");
        }else {
            Node temp = tail;
            System.out.print("[ ");
            for (int i = size(); i > 0; i--) {
                if (i == 1) {
                    System.out.print(temp.value + " ");
                    break;
                }
                System.out.print(temp.value + ", ");
                temp = temp.prev;
            }
            System.out.println("]");
        }
    }
}
