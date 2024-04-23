package _2LR.taskNumberOne;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        int[] arrayNumbers = new int [N];
        for (int i = 0; i < N; i++) {
            arrayNumbers[i] = scanner.nextInt();
        }
        System.out.println(findMaxPossibleProduct(N, arrayNumbers));
    }

    public static int findMaxPossibleProduct (int N, int[] arrayNumbers) {
        Arrays.sort(arrayNumbers);
        int maxProduct1 = arrayNumbers[N-1] * arrayNumbers[N-2] * arrayNumbers[N-3];
        int maxProduct2 = arrayNumbers[0] * arrayNumbers[1] * arrayNumbers[N-1];

        return Math.max(maxProduct1, maxProduct2);
    }
}