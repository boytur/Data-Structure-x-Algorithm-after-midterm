package Sec7;

public class PolynomialTimeExample {
    public int polynomialSum(int[] array) {

        int sum = 0;

        int n = array.length;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                sum += array[i] * array[j];

            }

        }

        return sum;

    }

}


