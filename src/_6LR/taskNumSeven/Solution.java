package _6LR.taskNumSeven;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line1 = scanner.nextLine().split(" ");
        String[] line2 = scanner.nextLine().split(" ");
        int l = Integer.parseInt(line1[0]); // на сколько можно изменить
        int n = Integer.parseInt(line1[1]); // кол-во чисел
        int[] nums = new int[n]; // сами числа
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(line2[i]);
        }

        nums = bubbleSort(nums);
        int answer = compressCount(nums , l);
        System.out.println(answer);
    }

    public static int compressCount(int[] nums, int L) {
        // если минимальноe и максимальное числа можно сжать, считаем их как одно число
        if (nums[nums.length - 1] - nums[0] <= L) {
            return 1;
        }
        int i = 1;
        // двигаем указатель пока L позволяет нам сжать 2 числа
        while (nums[i] - nums[0] <= L) {
            i++;
        }
        // заходим в сжатый подмассив прибавляя то, что схлопнули
        return 1 + compressCount(Arrays.copyOfRange(nums, i, nums.length), L);
    }

    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array;
    }
}
