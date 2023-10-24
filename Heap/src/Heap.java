import java.util.Arrays;

public class Heap {
    private int size;
    private int[] data;
    private boolean mode_max; // true = max heap, false = min heap

    Heap() {
        size = 0;
        data = new int[0];
        mode_max = true;
    }

    Heap(boolean mode) {
        size = 0;
        data = new int[0];
        mode_max = mode;
    }

    void setModeMax(boolean mode) {
        mode_max = mode;
        heaptify(data, size);
    }

    void heaptify(int[] arr, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (mode_max) {
            if (left < size && arr[left] > arr[largest]) {
                largest = left;
            }

            if (right < size && arr[right] > arr[largest]) {
                largest = right;
            }
        } else {
            if (left < size && arr[left] < arr[largest]) {
                largest = left;
            }

            if (right < size && arr[right] < arr[largest]) {
                largest = right;
            }
        }

        if (largest != i) {
            // swap arr[i] and arr[largest]
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // recursively heapify the affected sub-tree
            heaptify(arr, largest);
        }
    }

    void insert(int value) {
        if (size == 0) {
            data = new int[1];
        } else {
            data = Arrays.copyOf(data, size + 1);
        }

        int index = size;
        size++;
        data[index] = value;

        while (index > 0) {
            int parent = (index - 1) / 2;
            if ((mode_max && data[index] > data[parent]) || (!mode_max && data[index] < data[parent])) {
                // swap arr[index] and arr[parent]
                int temp = data[index];
                data[index] = data[parent];
                data[parent] = temp;

                index = parent;
            } else {
                break;
            }
        }
    }

    void delete(int value) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Value not found in the heap.");
            return;
        }

        // swap arr[index] and arr[size-1]
        int temp = data[index];
        data[index] = data[size - 1];
        data[size - 1] = temp;

        size--;

        heaptify(data, index);
    }

    void show_array() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i]);
            if (i < size - 1) {
                System.out.print(" ");
            }
        }
        System.out.println("]");
    }

    private int calculateHeapHeight(int n) {
        return (int) Math.floor(Math.log(n + 1) / Math.log(2));
    }

    void show_tree() {
        int i = 0;
        int h = calculateHeapHeight(size);

        for (int level = 0; level <= h; level++) {
            for (int j = 0; j < Math.pow(2, level) && i < size; j++) {
                System.out.print(data[i] + " ");
                i++;
            }
            System.out.println();
        }
    }
}
