package main;

import template.InputReader;
import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = in.nextInt();
            }
        }
        long ans = n * m;
        for (int i = 0; i < n; i++) {
            int x = 0;
            for (int j = 0; j < m; j++) {
                x += a[i][j];
            }
            ans += (1L << x) - 1 - x;
            ans += (1L << (m - x)) - 1 - (m - x);
        }
        for (int j = 0; j < m; j++) {
            int x = 0;
            for (int i = 0; i < n; i++) {
                x += a[i][j];
            }
            ans += (1L << x) - 1 - x;
            ans += (1L << (n - x)) - 1 - (n - x);
        }
        out.println(ans);
    }
}
