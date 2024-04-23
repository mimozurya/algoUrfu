package _4LR.taskNumThree;

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
        List<String> humans = new ArrayList<String>();

        for (int i = 0; i < N; i++) {
            if (arrN[i][0].equals("ADD")) {
                if (arrN[i].length == 3) {
                    humans.add(arrN[i][1] + " " + arrN[i][2]);
                } else {
                    results.add("ERROR");
                }
            }
            else if (arrN[i][0].equals("DELETE")) {
                if (arrN[i].length == 2) {
                    int indexOfDeleteElement = findIndexByName(humans, arrN[i][1]);
                    if (indexOfDeleteElement == -1) {
                        results.add("ERROR");
                        continue;
                    }

                    List<String> elementToRemove = new ArrayList<>();
                    elementToRemove.add(humans.get(indexOfDeleteElement));
                    humans.removeAll(elementToRemove);
                } else {
                    results.add("ERROR");
                }
            }
            else if (arrN[i][0].equals("EDITPHONE")) {
                if (arrN[i].length == 3) {
                    int indexOfName = findIndexByName(humans, arrN[i][1]);
                    String[] splitted = humans.get(indexOfName).split(" ");
                    if (splitted.length > 1) {
                        splitted[1] = arrN[i][2];
                        humans.set(indexOfName, String.join(" ", splitted));
                    } else {
                        results.add("ERROR");
                    }
                } else {
                    results.add("ERROR");
                }
            }
            else if (arrN[i][0].equals("PRINT")) {
                if (arrN[i].length == 2) {
                    int indexOfName = findIndexByName(humans, arrN[i][1]);
                    if (indexOfName == -1) {
                        results.add("ERROR");
                        continue;
                    }

                    results.add(humans.get(indexOfName));
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

    public static int findIndexByName (List<String> humans, String name) {
        int result = -1;
        for (int i = 0; i < humans.size(); i++) {
            if (humans.get(i).split(" ")[0].equals(name)) {
                result = i;
                break;
            }
        }
        return result;
    }
}
