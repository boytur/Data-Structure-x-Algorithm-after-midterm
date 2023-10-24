import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] checker = new String[2];
        checker[0] = "1";
        Scanner input = new Scanner(System.in);
        BinaryTree objbt = new BinaryTree();
        do {
            checker = input.nextLine().split(" ");
            switch (Integer.parseInt(checker[0])) {
                case 1: // insert
                    objbt.insert(checker[1]);
                    break;
                case 2: // pre order
                    System.out.print("PreOrder: ");
                    objbt.printPreOrder(objbt.root);
                    System.out.println();
                    break;
                case 3: // in order
                    System.out.print("InOrder: ");
                    objbt.printInOrder(objbt.root);
                    System.out.println();
                    break;
                case 4: // post order
                    System.out.print("PostOrder: ");
                    objbt.printPostOrder(objbt.root);
                    System.out.println();
                    break;
                case 5: // search
                    if(objbt.search(checker[1])){
                        System.out.println("found");
                    }else{
                        System.out.println("not found");
                    }
                    break;
                case 6: // destroTree
                    objbt.destroyTree(objbt.root);
                    break;
            }
        } while (!checker[0].equals("-99"));
    }
}