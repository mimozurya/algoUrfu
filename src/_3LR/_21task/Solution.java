package _3LR._21task;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // кол-во глав
        scanner.nextLine();
        int[] chapters = new int[n];
        String[] lines = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            chapters[i] = Integer.parseInt(lines[i]); // массив кол-ва страниц в главах
        }
        int nVolumes = scanner.nextInt(); // кол-во томов


        int left = Arrays.stream(chapters).min().getAsInt();
        int right = Arrays.stream(chapters).sum();
        // бинарный поиск в интервале
        while (left + 1 < right) {
            int mid = (left + right) / 2;//предполагаем сколько страниц поместится в том
            int curVolumes = 0;
            int lastVolume = 0;
            for (int i = 0; i < n; i++) {
                if (lastVolume + chapters[i] <= mid) { //пробуем класть элемент в текущий том
                    lastVolume += chapters[i];
                } else {
                    curVolumes++;//мы завершаем том и считаем его
                    lastVolume = chapters[i];
                    if (chapters[i] > mid) {
                        //присваиваем значение нужны что бы потом сдвинуть left
                        curVolumes = nVolumes;
                        break;
                    }
                }
            }

            curVolumes++;
            if (curVolumes <= nVolumes) {
                //томов больше страниц меньше
                right = mid;
            } else if (curVolumes > nVolumes) {
                //томов меньше страниц больше
                left = mid;
            }
        }

        System.out.println(right);
    }
}
