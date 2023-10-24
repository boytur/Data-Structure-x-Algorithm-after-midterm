import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] checker = new String[3];
        checker[0] = "1";
        Scanner input = new Scanner(System.in);
        StackLink obj_arr = new StackLink();
        do {
            checker = input.nextLine().split(" ");
            if (checker.length > 0 && !checker[0].isEmpty())
                switch (Integer.parseInt(checker[0])) {
                    case 1:
                        try {
                            obj_arr.push(Integer.parseInt(checker[1]));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        try {
                            System.out.println(obj_arr.pop());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        try {
                            System.out.println(obj_arr.peek());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        System.out.println(obj_arr.size());
                        break;
                    case 5:
                        obj_arr.show();
                        break;
                    case 6:
                        if (obj_arr.isEmpty()) {
                            System.out.println("is empty");
                        } else {
                            System.out.println("not empty");
                        }
                        break;
                }
        } while (!checker[0].equals("-99"));
    }
}
