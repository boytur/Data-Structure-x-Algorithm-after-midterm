import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] checker = new String[2];
        checker[0] = "1";
        Scanner input = new Scanner(System.in);
        Heap objbt = new Heap();
        do {
            checker = input.nextLine().split(" ");
            switch (Integer.parseInt(checker[0])) {
                case 0: // mode
                    objbt.setModeMax(Boolean.parseBoolean(checker[1]));
                    break;
                case 1: // insert
                    objbt.insert(Integer.parseInt(checker[1]));
                    break;
                case 2: // delete
                    objbt.delete(Integer.parseInt(checker[1]));
                    break;
                case 3: // print all
                    objbt.show_array();
                    break;
                case 4: // print tree
                    objbt.show_tree();
                    break;
            }
        } while (!checker[0].equals("-99"));
    }
}