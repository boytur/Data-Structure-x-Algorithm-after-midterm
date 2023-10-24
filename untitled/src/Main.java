import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 2 * n - 1; j++) {
                if (j == i || j == 2 * n - i + 1) {
                    System.out.print("+");
                } else if (j < i || j > 2 * n - i + 1) {
                    System.out.print("=");
                }
            }
            System.out.println();
        }
    }
}
