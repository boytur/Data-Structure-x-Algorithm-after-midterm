public class ArrayList implements Collection{
    private int capacity;
    private int count;
    private Object[] arry;

    public ArrayList(int size){
        arry = new Object[size];
        capacity = size;
        count = 0;
    }

    @Override
    public void add(Object value) {
        if(!isFull()){
            add(count, value);
        }else {
            throw new RuntimeException("is full");
        }
    }

    @Override
    public void add(int index, Object value) {
        if(index == count) {
            arry[index] = value;
        } else if (index < count) {
            for(int i = count; i > index; i--){
                arry[i] = arry[i-1];
            }
            arry[index] = value;
        } else {
            throw new RuntimeException("out of bounds");
        }
        count++;
    }

    @Override
    public Object get(int index) {
        if(index < count) {
            return arry[index];
        } else{
            throw new RuntimeException("not found");
        }
    }

    @Override
    public void set(int index, Object value) {
        if(index < count){
            arry[index] = value;
        }else{
            throw new RuntimeException("not found");
        }
    }

    @Override
    public void remove(Object value) {
        if(indexOf(value) == -1){
            throw new RuntimeException("not found");
        }
        Object[] temp_arry = new Object[capacity];
        int temp_count = 0;
        for(int i=0; i < capacity; i++){
            if(arry[i] != value){
                temp_arry[temp_count++] = arry[i];
            } else {
                count--;
            }
        }
        arry = temp_arry;
    }

    public int indexOf(Object value) {
        for(int i=0;i<count;i++){
            if(arry[i]== value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return count;
    }

    public int max_size() {
        return capacity;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }


    public boolean isFull() {
        return count >= capacity;
    }

    @Override
    public void show() {
        System.out.print("[");
        if(!isEmpty())
            for(int i=0;i<max_size();i++){
                if(i == 0){
                    System.out.print(" ");
                }
                System.out.print(i);
                System.out.print("=>");
                System.out.print(arry[i]);
                if(i < max_size()-1){
                    System.out.print(", ");
                }else {
                    System.out.print(" ");
                }
            }
        System.out.println("]");
    }

    @Override
    public void sort_merge() {
        mergeSort(0, count - 1);
    }
    private void mergeSort(int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(left, middle);
            mergeSort(middle + 1, right);

            merge(left, middle, right);
        }
    }
    private void merge(int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        Object[] leftArray = new Object[n1];
        Object[] rightArray = new Object[n2];
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arry[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arry[middle + 1 + j];
        }
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (Integer.parseInt(leftArray[i].toString()) <= Integer.parseInt(rightArray[j].toString())) {
                arry[k] = leftArray[i];
                i++;
            } else {
                arry[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arry[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arry[k] = rightArray[j];
            j++;
            k++;
        }
    }

    @Override
    public int search_sequential(Object value) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (arry[i].equals(value)) {
                return i;
            }
        }
        return index;
    }

    @Override
    public int search_binary(Object value) {
        return binarySearch(value, 0, count - 1);
    }
    private int binarySearch(Object value, int left, int right) {
        if (left <= right) {
            int middle = (left + right) / 2;

            if (arry[middle].equals(value)) {
                return middle;
            }

            if (Integer.parseInt(arry[middle].toString()) < Integer.parseInt(value.toString())) {
                return binarySearch(value, middle + 1, right);
            } else {
                return binarySearch(value, left, middle - 1);
            }
        }
        return -1;
    }

    @Override
    public int search_hashing(Object value) {
        int hashing = value.hashCode();
        int index = hashing % capacity;
        if(index >= 0 && index < count && arry[index] != null && arry[index].equals(value)){
            return index;
        }
        for(int i = (index + 1) % capacity; i != index; i = (i + 1) % capacity){
            if (i >= 0 && i < count && arry[i] != null && arry[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }
}