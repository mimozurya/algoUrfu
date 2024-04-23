package _1LR.taskNumberTwo;

import java.util.Scanner;

// number 2
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputNumSymbols = scanner.nextLine();
        String[] arrayInputNumSymbols = inputNumSymbols.split(" ");
        int N1 = Integer.parseInt(arrayInputNumSymbols[0]);
        int N2 = Integer.parseInt(arrayInputNumSymbols[1]);

        int[] arrayN1 = new int[N1];
        for (int i = 0; i < N1; i++) {
            arrayN1[i] = scanner.nextInt();
        }
        int[] arrayN2 = new int[N2];
        for (int j = 0; j < N2; j++) {
            arrayN2[j] = scanner.nextInt();
        }

        System.out.println(findCountElements(arrayN1, arrayN2));
    }
    public static int findCountElements (int[] arrayN1, int[] arrayN2) {
        int i = 0;
        int j = 0;
        int res = 0;
        while (i < arrayN1.length && j < arrayN2.length){
            if (arrayN1[i] < arrayN2[j]){
                i++;
            }
            else if (arrayN1[i] == arrayN2[j]){
                res++;
                i++;
                j++;
            }
            else if (arrayN1[i] > arrayN2[j]){
                j++;
            }
        }


        return res;
    }
}
