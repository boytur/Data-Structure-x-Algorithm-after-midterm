package Sec6;

public class ExponentialTimeExample {
    public int fibonacci(int n) {

        if (n <= 1) {

            return n;

        } else {

            return fibonacci(n - 1) + fibonacci(n - 2);

        }

    }

}

