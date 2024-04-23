package _2LR.taskNumberTen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arrSpeed = new int[N];
        for (int i = 0; i < N; i++) {
            arrSpeed[i] = scanner.nextInt();
        }
        System.out.println(findMinSpeed(N, arrSpeed));
    }
    public static int findMinSpeed (int N, int[] arrSpeed) {
        int totalSpeed = 0;
        Arrays.sort(arrSpeed);
        List<Integer> speed = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            speed.add(arrSpeed[i]);
        }
        while (speed.size() > 3) {
            int _1 = speed.get(0);
            int _2 = speed.get(1);
            int _3 = speed.get(2);
            int _4 = speed.get(3);
            if (_2 + _1 + _4 + _2 > _4 + _1 + _3 + _1) {
                totalSpeed += _4 + _1 + _3 + _1;
                speed.remove(speed.size() - 1);
                speed.remove(speed.size() - 1);
            } else {
                totalSpeed += _2 + _1 + _4 + _2;
                speed.remove(speed.size() - 1);
                speed.remove(speed.size() - 1);
            }
        }
        if (speed.size() == 3) {
            totalSpeed += speed.get(0) + speed.get(1) + speed.get(2);
        } else if (speed.size() == 2) {
            totalSpeed += speed.get(1);
        } else if (speed.size() == 1) {
            totalSpeed += speed.get(0);
        }
        return totalSpeed;
    }
}
