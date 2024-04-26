package _5LR.taskNumFour;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        BigInteger[] array = new BigInteger[N];
        for (int i = 0; i < N; i++) {
            array[i] = new BigInteger(scanner.next());
        }

        for (int i = 0; i < N; i++) {
            if (isSqrt(array[i])) {
                System.out.println(i+1);
            }
        }
    }

    public static boolean isSqrt (BigInteger number) {
//        double squareRoot = Math.sqrt(number.doubleValue());
//        return squareRoot == Math.floor(squareRoot);

        BigInteger low = BigInteger.ZERO;
        BigInteger high = number.add(BigInteger.ONE);
        while (low.compareTo(high.subtract(BigInteger.ONE)) < 0) { // пока low < high - 1
            BigInteger mid = low.add(high).divide(BigInteger.valueOf(2)); // (low + high) / 2
            if (number.compareTo(mid.multiply(mid)) < 0) { // if (mid * mid > number)
                high = mid;
            } else if (number.compareTo(mid.multiply(mid)) == 0) {
                return true; // если нашли число выходим
            } else {
                low = mid; // if (mid * mid) < number
            }
        }

        if (low.multiply(low).equals(number)) {
            return true;
        }

        return false;
    }
}
