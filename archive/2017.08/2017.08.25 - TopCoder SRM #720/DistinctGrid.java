package main;

public class DistinctGrid {
    public int[] findGrid(int n, int k) {
        int[] a = new int[n * n];
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k - 1; j++) {
                a[i * n + (i + j) % n] = cnt++;
            }
        }
        return a;
    }
}
