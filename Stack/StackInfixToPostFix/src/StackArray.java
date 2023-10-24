import java.util.Scanner;

class StackLink {
    private class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;

    public StackLink() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(char data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public char pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        char data = top.data;
        top = top.next;
        return data;
    }

    public char peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return top.data;
    }
}