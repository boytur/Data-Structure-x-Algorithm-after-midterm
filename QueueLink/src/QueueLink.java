public class QueueLink implements Queue {
    private class node{
        Object data;
        node link;
        node(Object d,node l){
            this.data = d;
            this.link = l;
        }
    }
    private node front = null;
    private node back = null;
    private int count;
    public QueueLink(){
        front = null;
        back = null;
        count = 0;
    }
    @Override
    public void enqueue(Object value) {
        node new_node = new node(value,null);
        if(front == null){
            front = new_node;
            back = new_node;
        }else {
            back.link = new_node;
            back = new_node;
        }
        count++;
    }

    @Override
    public Object dequeue() {
        if(isEmpty()){
            throw new RuntimeException("is empty");
        }
        node temp ;
        temp = front;
        count--;
        front = temp.link;

        return temp.data;
    }

    @Override
    public Object peek() {
        if(isEmpty()){
            throw new RuntimeException("is empty");
        }
        return front.data;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void show() {
        node temp = front;
        System.out.print("[");
        for (int i = 0; i < count; i++) {
            if(front.link == null) {
                System.out.print(temp.data);
            }else {
                System.out.print(temp.data);
                if (i != count - 1) {
                    System.out.print(", ");
                }
                temp = temp.link;
            }
        }
        System.out.println("]");
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }
}
