import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String[] check = new String[3];
        check[0] = "1";
        Scanner input = new Scanner(System.in);
        QueueLink obj_link = new QueueLink();
        do {
            check = input.nextLine().split(" ");
            if (check.length > 0 && !check[0].isEmpty()) {
                switch (Integer.parseInt(check[0])) {
                    case 1://enqueue
                        try {
                            obj_link.enqueue((Integer.parseInt(check[1])));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2://dequeue
                        try {
                            System.out.println(obj_link.dequeue());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:// peek
                        try {
                            System.out.println(obj_link.peek());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4: // size
                        System.out.println(obj_link.size());
                        break;
                    case 5: // show
                        obj_link.show();
                        break;
                    case 6: // isEmpty
                        if (obj_link.isEmpty()) {
                            System.out.println("is empty");
                        } else {
                            System.out.println("not empty");
                        }
                        break;
                }
            }
        }
        while (!check[0].equals("-99"));
    }
}