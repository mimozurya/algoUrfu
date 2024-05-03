package _6LR.taskNumFour;

import java.util.Scanner;

public class Solution {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strVoid = scanner.nextLine();
        int m = Integer.parseInt(strVoid.split(" ")[0]);
        int n = Integer.parseInt(strVoid.split(" ")[1]);
        int k = findK(m, n);
        System.out.println(k);
    }
    private static int findK(int m, int n) {
        int k = 2;
        //пока не вышли за пределы
        while (k <= 2 * 1000000) {
            int count = 0;
            for (int i = k; i < k + n && k + n <= 2 * 1000000; i++) {
                if (isPrime(i)) {
                    count++;
                }
            }

            if (count == m) return k;
            k++;
        }

        return -1;
    }

    public static boolean isPrime(int num) {
        boolean prime = num > 1 && (num % 2 != 0 || num == 2) && (num % 3 != 0 || num == 3);
        int i = 5;
        int d = 2;

        while (prime && i * i <= num) {
            prime = num % i != 0;
            i += d;
            d = 6 - d; // чередование прироста 2 и 4: 5 + 2, 7 + 4, 11 + 2, и т.д.
        }
        return prime;
    }
}
