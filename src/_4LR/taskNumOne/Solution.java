package _4LR.taskNumOne;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt();
        int M = scanner.nextInt();
        int[] arrV = new int[V];
        for (int i = 0; i < V; i++) {
            arrV[i] = scanner.nextInt();
        }
        int[][] arrM = new int[M][3];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                arrM[i][j] = scanner.nextInt();
            }
        }

        System.out.println(findResult(V, M, arrV, arrM));

    }

    public static List<Integer> findResult (int V, int M, int[] arrV, int[][] arrM) {
        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < M; i++) {
            if (arrM[i][0] == 1) {
                result.add(findSum(arrM[i][1], arrM[i][2], arrV));
            } else {
                arrV[arrM[i][1]] = arrM[i][2];
            }
        }

        return result;
    }

    public static int findSum (int start, int end, int[] array) {
        int ans = 0;
        for (int i = start; i <= end; i++) {
            ans += array[i];
        }
        return ans;
    }
}