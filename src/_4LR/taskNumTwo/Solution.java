package _4LR.taskNumTwo;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();

        int[][] arrN = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arrN[i][j] = scanner.nextInt();
            }
        }

        int[][] arrK = new int[K][M];
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < M; j++) {
                arrK[i][j] = scanner.nextInt();
            }
        }

        System.out.println(Arrays.deepToString(arrN));
        System.out.println(Arrays.deepToString(arrK));
        System.out.println(Arrays.toString(findResult(N, M, K, arrN, arrK)));
    }

    public static String[] findResult (int N, int M, int K, int[][] arrN, int[][] arrK) {
        String[] result = new String[K];

        for (int i = 0; i < K; i++) {
            for (int j = 0; j < N; j++) {
                if (coincidenceArrays(arrK[i], arrN[j], M)) {
                    result[i] = String.valueOf('1');
                    break;
                } else {
                    result[i] = String.valueOf('0');
                }
            }
        }

        return result;
    }

    public static boolean coincidenceArrays(int[] arrNew, int[] arrOld, int M) {
        boolean[] foundArrOld = new boolean[M];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if (arrNew[i] == arrOld[j] && !foundArrOld[j]) {
                    foundArrOld[j] = true;
                    break;
                }
            }
        }

        for (int k = 0; k < M; k++) {
            if (!foundArrOld[k]) {
                return false;
            }
        }

        return true;
    }
}
