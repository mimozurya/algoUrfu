package _1LR.taskNumberSeven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int bsize, pieces;

    public static void main(String[] args) {
        if (args.length != 2 || (bsize = Integer.parseInt(args[0])) <= 0 || (pieces = Integer.parseInt(args[1])) <= 0) {
            System.out.println("Invalid input arguments.");
            return;
        }

        Board b = new Board();
        if (!b.solve(0, pieces))
            System.out.println("No solution!");
    }

    static class Board {
        List<Integer> hor = new ArrayList<>(Collections.nCopies(bsize, -1));
        List<Boolean> ver = new ArrayList<>(Collections.nCopies(bsize, false));
        List<Boolean> diag1 = new ArrayList<>(Collections.nCopies(bsize * 2, false));
        List<Boolean> diag2 = new ArrayList<>(Collections.nCopies(bsize * 2, false));

        public boolean solve(int row, int pieces) {
            if (pieces == 0)
                return print();
            if (row == bsize - pieces)
                return false;

            for (int col = 0; col < bsize; col++) {
                if (tryPut(row, col)) {
                    if (solve(row + 1, pieces - 1))
                        return true;
                    unput(row, col);
                } else {
                    if (solve(row + 1, pieces))
                        return true;
                }
            }
            return false;
        }

        private boolean tryPut(int row, int col) {
            if (ver.get(col) || diag1.get(row + col) || diag2.get(row - col + bsize - 1))
                return false;

            for (int i = 0; i < row; i++) {
                if (hor.get(i) >= 0 && Math.abs(i - row) + Math.abs(hor.get(i) - col) == 3)
                    return false;
            }

            ver.set(col, true);
            diag1.set(row + col, true);
            diag2.set(row - col + bsize - 1, true);
            hor.set(row, col);
            return true;
        }

        private void unput(int row, int col) {
            ver.set(col, false);
            diag1.set(row + col, false);
            diag2.set(row - col + bsize - 1, false);
            hor.set(row, -1);
        }

        private boolean print() {
            for (int i = 0; i < bsize; i++) {
                for (int j = 0; j < bsize; j++) {
                    if (j == hor.get(i))
                        System.out.print("M");
                    else
                        System.out.print(".");
                }
                System.out.println();
            }
            return true;
        }
    }
}