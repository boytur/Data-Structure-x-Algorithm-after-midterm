public class LinkedList implements Collection{
    private class node{
        int data;
        node link;
        node(int d,node l){
            this.data=d;
            this.link=l;
        }
    }
    private node head;
    private node tail;
    private int count;
    public LinkedList(){
        head=null;
        tail=null;
        count=0;
    }
    @Override
    public void add(int value) {
        node new_node=new node(value,null);
        if (head == null){
            head=new_node;
        }if(tail == null) {
            tail = new_node;
        }else {
            tail.link = new_node;
            tail=new_node;
        }
        count++;
    }

    @Override
    public void add(int index, int value) {
        node new_node = new node(value, null);
        if(index>count+1) {
            throw new IndexOutOfBoundsException("out of bound");
        } else if (index==count) {
            tail.link = new_node;
            tail=new_node;
        } else {
            node temp = head;
            for (int i = 1; i <= size(); i++) {
                if (index == i + 1) {
                    node temp_2 = temp.link;
                    temp.link = new_node;
                    new_node.link = temp_2;
                    break;
                }
                temp=temp.link;
            }
            count++;
        }

    }

    @Override
    public int get(int index) {
        int checkIndex=0;
        node temp=head;
        if(index>count) {
            throw new IndexOutOfBoundsException("out of bound");
        }else
            for (int i=1;i<=size();i++){
                if(i==index){
                    checkIndex= temp.data;
                }
                temp=temp.link;
            }
        return checkIndex;
    }

    @Override
    public void set(int index, int value) {
        node ptemp = new node(value,null);
        node temp=head;
        if(index>count) {
            throw new IndexOutOfBoundsException("out of bound");
        }else
            for (int i=1;i<=size();i++){
                if(i==index){
                    temp.data= ptemp.data;
                }
                temp=temp.link;
            }
    }

    @Override
    public void remove(int value) {
        node temp=head;
        for(int i=1;i<=size();i++){
            if(temp.data==value){
                temp.data=temp.link.data;
                temp.link=temp.link.link;
                count--;
            }else
                temp=temp.link;
        }
    }

    @Override
    public boolean find(int value) {
        node temp=head;
        boolean check=false;
        for(int i=1;i<=size();i++){
            if(temp.data==value){
                check=true;
            }else
                temp=temp.link;
        }
        return check;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        if(head==null){
            return true;
        }
        return false;
    }

    @Override
    public void show() {
        if (head != null) {
            node temp = head;
            System.out.print("[ ");
            for (int i = 0; i < size(); i++) {
                System.out.print(temp.data);
                if (temp.link != null) {
                    System.out.print(", ");
                }
                temp = temp.link;
            }
            System.out.println(" ]");
        }else
            System.out.println("[  ]");
    }
}
