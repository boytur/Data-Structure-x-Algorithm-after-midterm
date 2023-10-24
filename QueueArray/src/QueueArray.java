

public class QueueArray implements Queue {
    int count = 0;
    int front = 0;
    int back = 0;
    Object[] arr_queue;
    int max;
    QueueArray(int size){
        max = size;
        arr_queue = new Object[size];
    }
    @Override
    public void enqueue(Object value) {
        if(isFull()){
            throw new  ArrayIndexOutOfBoundsException("is full");
        }
        back++;
        arr_queue[count++] = value;
    }

    @Override
    public Object dequeue() {
        Object up;
        if(isEmpty()){
            throw new ArrayIndexOutOfBoundsException("is empty");
        } else if (count > 1) {
            up = arr_queue[front];
            front++;
            count--;
        }else {
            up = arr_queue[front];
            count--;
            front = 0;
            back = 0;
        }
        return up;
    }

    @Override
    public Object peek() {
        if(isEmpty()){
            throw new ArrayIndexOutOfBoundsException("is empty");
        }
        return arr_queue[front];
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void show() {
        System.out.print("[");
        for (int i = front; i < max; i++) {
            System.out.print(i+" => "+arr_queue[i]);
            if(i != max-1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }
    public boolean isFull(){
        if(max == size() || back == max){
            return true;
        }
        return false;
    }
}
