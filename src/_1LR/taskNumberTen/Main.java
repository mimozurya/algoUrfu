package _1LR.taskNumberTen;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stringNM = scanner.nextLine();
        String[] arrayStringNM = stringNM.split(" ");
        int[] arrayNM = new int[2];
        for (int i = 0; i < 2; i++) {
            arrayNM[i] = Integer.parseInt(arrayStringNM[i]);
        }

        int countHoleFirstKey = Integer.parseInt(scanner.nextLine());
        int[][] arrFirstXY = new int[countHoleFirstKey][];

        for (int k = 0; k < countHoleFirstKey; k++) {
            String stringFirstXY = scanner.nextLine();
            String[] arrayStringFirstXY = stringFirstXY.split(" ");
            int[] arrayFirstXY = new int[4];
            for (int i = 0; i < 4; i++) {
                arrayFirstXY[i] = Integer.parseInt(arrayStringFirstXY[i]);
            }
            arrFirstXY[k] = arrayFirstXY;
        }

        int countHoleSecondKey = Integer.parseInt(scanner.nextLine());
        int[][] arrSecondXY = new int[countHoleSecondKey][];

        for (int l = 0; l < countHoleSecondKey; l++) {
            String stringSecondXY = scanner.nextLine();
            String[] arrayStringSecondXY = stringSecondXY.split(" ");
            int[] arraySecondXY = new int[4];
            for (int i = 0; i < 4; i++) {
                arraySecondXY[i] = Integer.parseInt(arrayStringSecondXY[i]);
            }
            arrSecondXY[l] = arraySecondXY;
        }

        System.out.println(Arrays.toString(arrayNM));
        System.out.println(countHoleFirstKey);
        System.out.println(Arrays.deepToString(arrFirstXY));
        System.out.println(countHoleSecondKey);
        System.out.println(Arrays.deepToString(arrSecondXY));
        System.out.println(findCountOfHole(arrayNM, countHoleFirstKey, arrFirstXY, countHoleSecondKey, arrSecondXY));
    }

    public static int findCountOfHole (int[] arrayNM, int countHoleFirstKey, int[][] arrFirstXY, int countHoleSecondKey, int[][] arrSecondXY) {
        int answer = 0;
        int N = arrayNM[0];
        int M = arrayNM[1];

        for (int i = 0; i < countHoleFirstKey; i++) {
            for (int j = 0; j < countHoleSecondKey; j++) {
                /*if ((arrSecondXY[j][0] <= arrFirstXY[i][0] || arrSecondXY[j][1] <= arrFirstXY[i][1])
                && (arrSecondXY[j][2] >= arrFirstXY[i][2] || arrSecondXY[j][3] >= arrFirstXY[i][3])) {
                    answer++;
                }*/

                if (i+2 == countHoleFirstKey) {
                    if (((arrSecondXY[j][2] - arrSecondXY[j][0]) + (arrFirstXY[i][2] - arrFirstXY[i][0]) >
                            arrFirstXY[i+1][0] - (arrFirstXY[i][2] - arrFirstXY[i][0])) &&
                            ((arrSecondXY[j][3] - arrSecondXY[j][1]) + (arrFirstXY[i][3] - arrFirstXY[i][1]) <
                            arrFirstXY[i+1][1] - (arrFirstXY[i][3] - arrFirstXY[i][1]))) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}
