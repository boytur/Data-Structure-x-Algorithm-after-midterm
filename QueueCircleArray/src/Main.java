import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] check = new String[3];
        check[0] = "1";
        Scanner input = new Scanner(System.in);
        int size_obj_arr = input.nextInt();
        QueueCircleArray obj_arr = new QueueCircleArray(size_obj_arr);
        do {
            check = input.nextLine().split(" ");
            if (check.length > 0 && !check[0].isEmpty()) {
                switch (Integer.parseInt(check[0])) {
                    case 1://enqueue
                        try {
                            obj_arr.enqueue(check[1]);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2://dequeue
                        try {
                            System.out.println(obj_arr.dequeue());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:// peek
                        try {
                            System.out.println(obj_arr.peek());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4: // size
                        System.out.println(obj_arr.size());
                        break;
                    case 5: // show
                        obj_arr.show();
                        break;
                    case 6: // isEmpty
                        if (obj_arr.isEmpty()) {
                            System.out.println("is empty");
                        } else {
                            System.out.println("not empty");
                        }
                        break;
                    case 7: // isFull
                        if (obj_arr.isFull()) {
                            System.out.println("is full");
                        } else {
                            System.out.println("not full");
                        }
                        break;
                }
            }
        }
        while (!check[0].equals("-99"));
    }
}