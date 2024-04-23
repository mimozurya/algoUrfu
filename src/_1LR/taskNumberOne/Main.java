package _1LR.taskNumberOne;

import java.util.*;

// number 1
public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputNumSymbols = scanner.nextLine();

        String[] arrayInputNumSymbols = inputNumSymbols.split("0 ");
        String N1 = arrayInputNumSymbols[0];
        String N2 = arrayInputNumSymbols[1];

        String[] newArrayNumSymbolsN1 = N1.split(" ");
        String[] newArrayNumSymbolsN2 = N2.split(" ");

        int[] A = new int[newArrayNumSymbolsN1.length];
        for (int i = 0; i < newArrayNumSymbolsN1.length; i++) {
            A[i] = Integer.parseInt(newArrayNumSymbolsN1[i]);
        }

        int[] B = new int[newArrayNumSymbolsN2.length-1];
        for (int j = 0; j < newArrayNumSymbolsN2.length-1; j++) {
            B[j] = Integer.parseInt(newArrayNumSymbolsN2[j]);
        }


        System.out.println(Arrays.toString(A) + "A");
        System.out.println(Arrays.toString(B) + "B");
        System.out.println(symmetricalDifference(A, B));
    }

    public static Set<Integer> symmetricalDifference (int[] A, int[] B) {
        List<Integer> arrList = new ArrayList<Integer>();
        for (int num : A) {
            arrList.add(num);
        }
        for (int num : B) {
            arrList.add(num);
        }

        Set<Integer> answer = new TreeSet<>();
        for (Integer number : arrList) {
            if (answer.contains(number)) {
                answer.remove(number);
            } else {
                answer.add(number);
            }
        }
        return answer;
    }
}
