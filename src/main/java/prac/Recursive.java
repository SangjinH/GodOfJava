package prac;

public class Recursive {

    public static void main(String[] args) {

        int targetNumber = 12;

        int fibonacciRecursive = fibonacciRecursive(targetNumber);
        System.out.println("targetNumber = " + targetNumber);
        System.out.println("fibonacciRecursive = " + fibonacciRecursive);

        int fibonacciIterative = fibonacciIterative(targetNumber);
        System.out.println("fibonacciIterative = " + fibonacciIterative);
    }

    private static int fibonacciRecursive(int targetNumber) {
        if (targetNumber == 1) {
            return 1;
        } else if (targetNumber == 0) {
            return 0;
        } else {
            return fibonacciRecursive(targetNumber - 1) + fibonacciRecursive(targetNumber - 2);
        }
    }

    private static int fibonacciIterative(int targetNumber) {

        int a = 0;
        int b = 1;

        int cnt = 0;
        while (cnt < targetNumber) {
            cnt += 1;

            int tempA = b;
            int tempB = a + b;

            a = tempA;
            b = tempB;
        }

        return a;
    }
}
