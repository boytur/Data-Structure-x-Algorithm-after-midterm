public class QueueCircleArray implements Queue {
    int count = 0;
    int front = 0;
    int back = 0;
    Object[] arr_queue;
    int max;

    QueueCircleArray(int size){
        arr_queue = new Object[size];
        max = size;
    }
    @Override
    public void enqueue(Object value) {
        if(isFull()){
            throw new ArrayIndexOutOfBoundsException("is full");
        }
        arr_queue[back] = value;
        back = (back + 1) % max;
        count++;
    }

    @Override
    public Object dequeue() {
        if(isEmpty()){
            throw new ArrayIndexOutOfBoundsException("is empty");
        }
        Object up ;
        up = arr_queue[front];
        arr_queue[front] = null;
        front = (front + 1) % max;
        count--;
        return up;
    }
    @Override
    public Object peek() {
        if (isEmpty()){
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
        for (int i = 0; i < count; i++) {
            if(i == count-1){
                System.out.print( (i+front)%max + " => " + arr_queue[(i+front)%max]);
            }else {
                System.out.print((i+front)%max + " => " + arr_queue[(i+front)%max]+", ");
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
