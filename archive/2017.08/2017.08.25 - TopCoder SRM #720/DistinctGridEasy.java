package main;

import java.util.HashSet;

public class DistinctGridEasy {
    public String checkGrid(int n, int k, int[] grid) {
        for (int i = 0; i < n; i++) {
            HashSet<Integer> se1 = new HashSet(), se2 = new HashSet();
            for (int j = 0; j < n; j++) {
                se1.add(grid[i * n + j]);
                se2.add(grid[j * n + i]);
            }
            if (se1.size() != k || se2.size() != k) {
                return "Bad";
            }
        }
        return "Good";
    }
}
