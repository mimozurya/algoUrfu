package _2LR.taskNumberEight;

import java.util.Scanner;

public class Solution {
    static final int SIZE = 10001;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        for (int i = 0; i < k; i++) {
            System.out.println(checkSecurity(scanner));
        }
    }
    public static String checkSecurity (Scanner scanner) {
        int countTime = scanner.nextInt();
        int[] countDiff = new int[SIZE];
        int[] sumDiff = new int[SIZE];
        boolean[] singles = new boolean[countTime];
        for (int j = 0; j < countTime; j++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            countDiff[start]++;
            countDiff[end]--;
            sumDiff[start] += j;
            sumDiff[end] -= j;
        }
        int curCount = 0;
        int curSum = 0;
        int minCount = Integer.MAX_VALUE;
        for (int z = 0; z < SIZE - 1; z++) {
            curCount += countDiff[z];
            minCount = Math.min(minCount, curCount);
            curSum += sumDiff[z];
            if (curCount == 1) {
                singles[curSum] = true;
            }
        }
        if (minCount != 1) {
            return "Wrong answer";
        }
        for (int x = 0; x < countTime; x++) {
            if (!singles[x]) {
                return "Wrong answer";
            }
        }
        return "Accepted";
    }
}
