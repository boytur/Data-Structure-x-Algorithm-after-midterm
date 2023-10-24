public class ArrayList implements Collection {
    private int capacity; // ตัวแปรสําหรับการใช้ระบุความจุสูงสุดในการ เก็บข้อมูล
    private int count;
    private int[] arry;
    public ArrayList(int Size) {
        capacity = Size;
        count = 0;
        arry =new int[Size];
    }

    @Override
    public void add(int value) {
        arry[count]=value;
        count++;
        
    }

    @Override
    public void add(int index, int value) {
        if(index==count){
            arry[index]=value;
        }else if (index<count){
            for(int i =count ;i >index;i--){
                arry[i]=arry[i-1];
            }
            arry[index]=value;
        }else {
            throw new RuntimeException("out of bounds");
        }
count++;
    }

    @Override
    public int get(int index) {
        int value = 0 ;
        if (index >= count){
            throw new RuntimeException("not found");
        }else {
            for (int i = 0; i < capacity; i++) {
                if (i==index){
                    value = arry[i] ;
                    break;
                }
            }
        }
        return value ;
    }


    @Override
    public void set(int index, int value) {
        if(index>=count){
            throw  new RuntimeException("not found");
        }else {
            arry[index]=value;
        }
    }

    @Override
    public void remove(int value) {
        int CheckIndex=indexOf(value);
        if (CheckIndex<=-1){
            throw new RuntimeException("not found");
        }
        for (int i=CheckIndex;i<count-1;i++){
            arry[i]=arry[i+1];

        }
        arry[count-1]=0;
        count--;
    }

    @Override
    public int indexOf(int value) {
        int index = 0;
        for (int i = 0; i < capacity; i++) {
            if (arry[i]==value){
                index = i;
                break;
            }else {
                index = -1;
            }
        }
        return index;
    }

    @Override
    public int size() {

        return count;
    }

    @Override
    public int max_size() {
        return capacity;
    }

    @Override
    public boolean isEmpty() {
        boolean Check = true;
        if (count==0){
            Check = true;
        }else {
            Check = false;
        }
        return Check;
    }

    @Override
    public boolean isFull() {

        return count==capacity;
    }

    @Override
    public void show() {
        System.out.print("[ ");
        for (int i = 0; i < capacity ; i++) {
            if (i == capacity-1){
                System.out.print(i+"=>"+arry[i]);
            }else {
                System.out.print(i+"=>"+arry[i]+", ");
            }
        }
        System.out.print(" ]");
        System.out.println();
    }
}
