package _2LR.taskNumberTwo;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();

        String priorityString = scanner.nextLine();
        String[] arrPriorityString = priorityString.split(" ");
        int[] arrPriority = new int[k];
        for (int i = 0; i < k; i++) {
            arrPriority[i] = Integer.parseInt(arrPriorityString[i]);
        }

        String[][] arrNumbers = new String[N][];
        for (int j = 0; j < N; j++) {
            String numString = scanner.nextLine();
            String[] arrNumString = numString.split(" ");
            arrNumbers[j] = arrNumString;
        }

        System.out.println(Arrays.toString(findPriority(N, k, arrPriority, arrNumbers)));
    }

    public static String[] findPriority (int N, int k, int[] arrPriority, String[][] arrNumbers) {
        String[] result = new String[N];
        int maxNum = 0;
        int indexOfMax = 0;
        int i = 0;
        int j = 0;

        while (i < k && j < N) {
            maxNum = 0;
            j = 0;
            while (j < N) {
                int priorityElem = Integer.parseInt(arrNumbers[j][arrPriority[i]]);
                String firstLetterPriorityElem = arrNumbers[j][0];

                if (priorityElem > maxNum && findSymbol(result, arrNumbers[j][0])) {
                    maxNum = priorityElem;
                    result[i] = firstLetterPriorityElem;
                    indexOfMax = j;
                } else if (priorityElem == maxNum) {
                    if (Integer.parseInt(arrNumbers[j][arrPriority[i + 1]]) >
                            Integer.parseInt(arrNumbers[indexOfMax][arrPriority[i + 1]])) {

                        String tempString = result[i];
                        result[i] = firstLetterPriorityElem;
                        result[i + 1] = tempString;
                        i++;
                        break;
                    } else {
                        result[i + 1] = firstLetterPriorityElem;
                        i++;
                        break;
                    }
                }
                j++;
            }
            i++;
        }
        return result;
    }
    public static boolean findSymbol (String[] array, String symbol) {
        boolean isPresent = true;
        if (array != null && array.length > 0) {
            for (String str : array) {
                if (str != null && str.contains(symbol)) {
                    isPresent = false;
                    break;
                }
            }
        }
        return isPresent;
    }
}
