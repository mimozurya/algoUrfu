package _2LR.taskNumberNine;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] NM = new int[2];
        for (int i = 0; i < 2; i++) {
            NM[i] = scanner.nextInt();
        }
        int[][] arrayChairs = new int[NM[0]][NM[1]];
        for (int i = 0; i < NM[0]; i++) {
            for (int j = 0; j < NM[1]; j++) {
                arrayChairs[i][j] = scanner.nextInt();
            }
        }
        System.out.println(Arrays.deepToString(arrayChairs));
    }
}
