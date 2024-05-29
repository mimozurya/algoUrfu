package _6LR.taskNumSix;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // кол-во дней
        double[] dol = new double[N];
        double[] euro = new double[N];
        for (int i = 0; i < N; i++) {
            dol[i] = scanner.nextDouble();
            euro[i] = scanner.nextDouble();
        }
        System.out.printf("%.2f", getMaxStonks(N, dol, euro));
    }

    public static double getMaxStonks(int N, double[] dol, double[] euro){
        double[][] money = new double[N][3];
        money[0][0] = 100; // по условию
        money[0][1] = money[0][0]/dol[0];
        money[0][2] = money[0][0]/euro[0];
        for (int i = 1; i < N; i++) {
            money[i][0] = Math.max(Math.max(money[i-1][1]*dol[i], money[i-1][2]*euro[i]), money[i-1][0]);
            // сверху - макс. кол-во денег, которое может иметь Петя к i-му дн.
            money[i][1] = Math.max(Math.max(money[i][0]/dol[i], money[i-1][0]/dol[i]), money[i-1][1]);
            // количество долларов
            money[i][2] = Math.max(Math.max(money[i][0]/euro[i], money[i-1][0]/euro[i]), money[i-1][2]);
            // количество евро
        }
        return money[N-1][0];
    }
}
//4
//1 10
//10 5,53
//5,53 1,25
//6 5
