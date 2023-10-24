public class StackArray implements Stack {
     int top = -1;
    Object[] arr_stack  ;
     int max ;

    public StackArray(int size) {
        top = -1;
        max = size;
        arr_stack = new Object[size];

    }

    @Override
    public void push(Object value) {
        if(isFull()){
            throw new ArrayStoreException("is full");

        }else
            top++;
         arr_stack[top]=  value;

    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("is empty");
        }
        top--;
        return arr_stack[top+1];

    }

    @Override
    public Object peek() {
       if(isEmpty()){
           throw new ArrayIndexOutOfBoundsException("is empty");

       }
       return arr_stack[top];
    }

    @Override
    public int size() {
        return top+1;
    }

    @Override
    public void show() {
        System.out.print("[");
        for (int i=top;i>=0;i--){
            System.out.print(arr_stack[i]);
            if(i!=0){
                System.out.print(", ");

            }
        }
        System.out.println("]");

    }

    @Override
    public boolean isEmpty() {
        return top==-1;
    }
    public boolean isFull(){
        return size()==max;
    }
}

