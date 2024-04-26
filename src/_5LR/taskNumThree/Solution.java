package _5LR.taskNumThree;

import java.util.Scanner;

public class Solution {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        String wordPattern = scanner.nextLine();

        System.out.println(findResult(word, wordPattern));
    }

    public static String findResult (String word, String wordPattern) {
        int i = 0;
        int j = 0;
        int indexOfStar = -1;
        int tempIndex = -1;

        while (i < word.length()) {
            if (j < wordPattern.length() && (wordPattern.charAt(j) == '?' || word.charAt(i) == wordPattern.charAt(j))) {
                i++;
                j++;
            }
            else if (j < wordPattern.length() && wordPattern.charAt(j) == '*') {
                indexOfStar = j;
                tempIndex = i;
                j++;
            }
            else if (indexOfStar != -1) {
                j = indexOfStar + 1;
                i = tempIndex + 1;
                tempIndex++;
            }
            else {
                return "NO";
            }
        }

        return j == wordPattern.length() ? "YES" : "NO";
    }
}
