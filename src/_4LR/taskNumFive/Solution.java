package _4LR.taskNumFive;

import java.util.*;

public class Solution {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] arrM = new int[M];
        for (int i = 0; i < M; i++) {
            arrM[i] = scanner.nextInt();
        }

        System.out.println(Arrays.toString(arrM));
        System.out.println(findResult(N, M, arrM));
    }

    public static int findResult (int N, int M, int[] arrM) {
        int counter = 1;
        List<Integer> tempList = new ArrayList<Integer>();
        tempList.add(arrM[0]);

        for (int i = 1; i < M; i++) {
            if (!findNumberInList(tempList, arrM[i]) && tempList.size() < N) {
                tempList.add(arrM[i]);
                counter++;
            }
            else if (!findNumberInList(tempList, arrM[i]) && tempList.size() == N) {
                sortIntList(tempList);
                for (int j = 0; j < N; j++) {
                    if (!findNumberInArray(i, M, arrM, tempList.get(j))) {
                        tempList.set(j, arrM[i]);
                        counter++;
                        break;
                    }
                }
            }
        }
        return counter;
    }
    public static boolean findNumberInArray (int start, int end, int[] array, int elem) {
        boolean result = false;
        for (int i = start + 1; i<end; i++) {
            if (array[i] == elem) {
                result = true;
                break;
            }
        }
        return result;
    }
    public static boolean findNumberInList (List<Integer> list, int element) {
        boolean result = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == element) {
                result = true;
                break;
            }
        }
        return result;
    }
    public static void sortIntList (List<Integer> list) {
        Collections.sort(list);
    }
}
