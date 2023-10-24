import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("exit")) {
                break;
            }

            try {
                String postfix = infixToPostfix(input);
                System.out.println(postfix);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String infixToPostfix(String infix) {
        StackLink stack = new StackLink();
        StringBuilder postfix = new StringBuilder();

        for (char ch : infix.toCharArray()) {
            if (isOperand(ch)) {
                postfix.append(ch);
            } else if (isOperator(ch)) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            } else if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                char openBracket = getMatchingOpenBracket(ch);
                while (!stack.isEmpty() && stack.peek() != openBracket) {
                    postfix.append(stack.pop());
                }
                if (stack.isEmpty() || stack.peek() != openBracket) {
                    throw new RuntimeException("not found " + getMatchingOpenBracket(ch));
                }
                stack.pop(); // Pop the matching open bracket
            }
        }

        while (!stack.isEmpty()) {
            char top = stack.pop();
            if (top == '(' || top == '[' || top == '{') {
                throw new RuntimeException("not found " + getMatchingCloseBracket(top));
            }
            postfix.append(top);
        }

        return postfix.toString();
    }

    private static boolean isOperand(char ch) {
        return Character.isLetterOrDigit(ch);
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    private static char getMatchingOpenBracket(char closeBracket) {
        switch (closeBracket) {
            case ')':
                return '(';
            case ']':
                return '[';
            case '}':
                return '{';
            default:
                throw new IllegalArgumentException("Invalid bracket: " + closeBracket);
        }
    }

    private static char getMatchingCloseBracket(char openBracket) {
        switch (openBracket) {
            case '(':
                return ')';
            case '[':
                return ']';
            case '{':
                return '}';
            default:
                throw new IllegalArgumentException("Invalid bracket: " + openBracket);
        }
    }
}
