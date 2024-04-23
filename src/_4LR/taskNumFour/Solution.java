package _4LR.taskNumFour;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();

        String[][] array = new String[N][];
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextLine().split("");
        }

        System.out.println(Arrays.deepToString(array));
        System.out.println(findResult(N, array));
    }

    public static int findResult (int N, String[][] array) {
        HashSet<String> set = new HashSet<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            for (String s : array[i]) {
                sb.append(s);
            }
            String sortedString = sortString(sb.toString());
            if (!set.contains(sortedString)) {
                set.add(sortedString);
                count++;
            }
        }

        return count;
    }

    public static String sortString(String s) {
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            for (int j = i + 1; j < charArray.length; j++) {
                if (charArray[i] > charArray[j]) {
                    char temp = charArray[i];
                    charArray[i] = charArray[j];
                    charArray[j] = temp;
                }
            }
        }

        return new String(charArray);
    }
}
