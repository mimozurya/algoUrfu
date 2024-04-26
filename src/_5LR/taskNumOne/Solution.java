package _5LR.taskNumOne;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    // подстроки
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(findMaxWeightOfSubStrings(input));
    }
    private static int findMaxWeightOfSubStrings(String line) {
        Map<String, Integer> weights = new HashMap<>();
        int maxWeight = Integer.MIN_VALUE;

        for (int window = 1; window <= line.length(); window++) {
            for (int i = 0; i <= line.length() - window; i++) {
                String substring = line.substring(i, i + window);
                weights.put(substring, weights.getOrDefault(substring, 0) + 1);
            }// ищем подпоследовательности
        }

        for (Map.Entry<String, Integer> entry : weights.entrySet()) {
            String substring = entry.getKey();
            int occurrences = entry.getValue();
            int weight = substring.length() * occurrences;

            if (weight > maxWeight) {
                maxWeight = weight;
            }
        }

        return maxWeight;
    }
}
