package _1LR.taskNumberSix;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countStones = Integer.parseInt(scanner.nextLine());

        String inputNumSymbols = scanner.nextLine();
        String[] arrayInput = inputNumSymbols.split(" ");
        int[] arrayStones = new int[arrayInput.length];
        for (int i = 0; i < arrayInput.length; i++) {
            arrayStones[i] = Integer.parseInt(arrayInput[i]);
        }

        System.out.println(findMinWeight(countStones, arrayStones));
    }

    public static int findMinWeight (int countStones, int[] arrayStones) {
        int weight = 0;
        int firstBox = 0;
        int secondBox = 0;

        for (int i = 0; i < countStones; i++) {
            weight += arrayStones[i];
        }
        int adrWeight = weight/countStones + 1;

        for (int j = 0; j < countStones; j++) {
            if (arrayStones[j] < adrWeight) {
                firstBox+=arrayStones[j];
            } else {
                secondBox+=arrayStones[j];
            }
        }

        return Math.abs(firstBox-secondBox);
    }
}
