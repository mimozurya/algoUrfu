package _6LR.taskNumTwo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    static class Passenger implements Comparable<Passenger> {
        int id;
        int entry;
        int exit;
        public Passenger(int id, int entry, int exit) {
            this.id = id;
            this.entry = entry;
            this.exit = exit;
        }

        @Override
        public int compareTo(Passenger other) {
            return Integer.compare(this.entry, other.entry);
        }
        @Override
        public String toString(){
            return "id: " + this.id + " entry: " + this.entry + " exit: " + this.exit;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();
        int P = scanner.nextInt();
        Passenger[] passengers = new Passenger[K];
        for (int i = 0; i < K; i++) {
            passengers[i] = new Passenger(i + 1, scanner.nextInt(), scanner.nextInt());
        }
        ArrayList<Passenger> satPassengers = getSatPassengers(M, K, passengers);
        System.out.println(satPassengers.size() * P);
        for(Passenger passenger : satPassengers){
            System.out.print(passenger.id + " ");
        }
    }

    public static ArrayList<Passenger> getSatPassengers(int M, int K, Passenger[] passengers){
        quickSort(passengers, 0, K - 1);
        int countFreeSeat = M;
        ArrayList<Passenger> satPassengers = new ArrayList<>();
        Set<Passenger> exitPassengers = new HashSet<>();
        for(Passenger passenger : passengers){
            for(Passenger satPassenger : satPassengers){
                if(!exitPassengers.contains(satPassenger) && satPassenger.exit <= passenger.entry){
                    countFreeSeat++;
                    exitPassengers.add(satPassenger);
                }
            }
            if(countFreeSeat > 0){
                satPassengers.add(passenger);
                countFreeSeat--;
            }
        }
        return satPassengers;
    }

    private static void quickSort(Passenger[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(Passenger[] arr, int low, int high) {
        Passenger pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j].exit < pivot.exit || (arr[j].exit == pivot.exit && arr[j].entry < pivot.entry)) {
                i++;
                Passenger temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        Passenger temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }
}
