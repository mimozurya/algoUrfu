package _5LR.taskNumTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();

        String[][] arrN = new String[N][];

        for (int i = 0; i < N; i++) {
            arrN[i] = scanner.nextLine().split(" ");
        }

        System.out.println(Arrays.deepToString(arrN));
        System.out.println(findResult(N, arrN));
    }

    public static List<String> findResult (int N, String[][] arrN) {
        List<String> results = new ArrayList<String>();
        List<String> dataSet = new ArrayList<String>();

        for (int i = 0; i < N; i++) {
            if (arrN[i][0].equals("ADD")) {
                if (arrN[i].length == 3 && findIndexByName(dataSet, arrN[i][1]) == -1) {
                    dataSet.add(arrN[i][1] + " " + arrN[i][2]);
                } else {
                    results.add("ERROR");
                }
            }
            else if (arrN[i][0].equals("DELETE")) {
                if (arrN[i].length == 2) {
                    int indexOfDeleteElement = findIndexByName(dataSet, arrN[i][1]);
                    if (indexOfDeleteElement == -1) {
                        results.add("ERROR");
                        continue;
                    }

                    List<String> elementToRemove = new ArrayList<>();
                    elementToRemove.add(dataSet.get(indexOfDeleteElement));
                    dataSet.removeAll(elementToRemove);
                } else {
                    results.add("ERROR");
                }
            }
            else if (arrN[i][0].equals("UPDATE")) {
                if (arrN[i].length == 3) {
                    int indexOfName = findIndexByName(dataSet, arrN[i][1]);
                    if (indexOfName == -1) {
                        results.add("ERROR");
                        continue;
                    }
                    String[] splitted = dataSet.get(indexOfName).split(" ");
                    if (splitted.length > 1) {
                        splitted[1] = arrN[i][2];
                        dataSet.set(indexOfName, String.join(" ", splitted));
                    } else {
                        results.add("ERROR");
                    }
                } else {
                    results.add("ERROR");
                }
            }
            else if (arrN[i][0].equals("PRINT")) {
                if (arrN[i].length == 2) {
                    int indexOfName = findIndexByName(dataSet, arrN[i][1]);
                    if (indexOfName == -1) {
                        results.add("ERROR");
                        continue;
                    }

                    results.add(dataSet.get(indexOfName));
                } else {
                    results.add("ERROR");
                }
            }
            else {
                results.add("ERROR");
            }
        }
        return results;
    }

    public static int findIndexByName (List<String> dataSet, String name) {
        int result = -1;
        for (int i = 0; i < dataSet.size(); i++) {
            if (dataSet.get(i).split(" ")[0].equals(name)) {
                result = i;
                break;
            }
        }
        return result;
    }
}
