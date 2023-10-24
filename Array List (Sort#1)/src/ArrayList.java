package ArrayList;

public class ArrayList implements Collection {
    private int capacity;
    private int count;
    private Object[] arry;

    public ArrayList(int size) {
        arry = new Object[size];
        capacity = size;
        count = 0;
    }
    @Override
    public void add(Object value) {
        if (!isFull()) {
            add(count, value);
        } else {
            throw new RuntimeException("is full");
        }
    }

    @Override
    public void add(int index, Object value) {
        if (index == count) {
            arry[index] = value;
        } else if (index < count) {
            for (int i = count; i > index; i--) {
                arry[i] = arry[i - 1];
            }
            arry[index] = value;
        } else {
            throw new RuntimeException("out of bounds");
        }
        count++;
    }

    @Override
    public Object get(int index) {
        if (index < count) {
            return arry[index];
        } else {
            throw new RuntimeException("not found");
        }
    }

    @Override
    public void set(int index, Object value) {
        if (index < count) {
            arry[index] = value;
        } else {
            throw new RuntimeException("not found");
        }
    }

    @Override
    public void remove(Object value) {
        if (indexOf(value) == -1) {
            throw new RuntimeException("not found");
        }
        Object[] temp_arry = new Object[capacity];
        int temp_count = 0;
        for (int i = 0; i < capacity; i++) {
            if (arry[i] != value) {
                temp_arry[temp_count++] = arry[i];
            } else {
                count--;
            }
        }
        arry = temp_arry;
    }
    public int indexOf(Object value) {
        for (int i = 0; i < count; i++) {
            if (arry[i] == value) {
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
        if (!isEmpty())
            for (int i = 0; i < max_size(); i++) {
                if (i == 0) {
                    System.out.print(" ");
                }
                System.out.print(i);
                System.out.print("=>");
                System.out.print(arry[i]);
                if (i < max_size() - 1) {
                    System.out.print(", ");
                } else {
                    System.out.print(" ");
                }
            }
        System.out.println("]");
    }

    @Override
    public void sort_radix() {
        if (count > 1) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < count; i++) {
                int num = Integer.parseInt(arry[i].toString());
                if (num > max) {
                    max = num;
                }
            }
            for (int exp = 1; max / exp > 0; exp *= 10) {
                radixSortByDigit(exp);
            }
        }

    }
    private void radixSortByDigit(int exp) {
        int n = count;
        Object[] output = new Object[n];
        int[] countArray = new int[10];

        for (int i = 0; i < n; i++) {
            int index = (Integer.parseInt(arry[i].toString()) / exp) % 10;
            countArray[index]++;
        }
        for (int i = 1; i < 10; i++) {
            countArray[i] += countArray[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int index = (Integer.parseInt(arry[i].toString()) / exp) % 10;
            output[countArray[index] - 1] = arry[i];
            countArray[index]--;
        }

        System.arraycopy(output, 0, arry, 0, n);
    }
    @Override
    public void sort_insertion() {
        for (int i = 1; i < count; i++) {
            Object key = arry[i];
            int j = i - 1;

            while (j >= 0 && Integer.parseInt(arry[j].toString()) > Integer.parseInt(key.toString())) {
                arry[j + 1] = arry[j];
                j = j - 1;
            }
            arry[j + 1] = key;
        }
    }
}
