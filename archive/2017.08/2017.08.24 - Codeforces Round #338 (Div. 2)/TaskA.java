package main;

import palayutm.InputReader;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        int[] a = new int[m];
        for (int i = 0; i < n; i++) {
            int t = in.nextInt();
            for (int j = 0; j < t; j++) {
                int x = in.nextInt() - 1;
                if (a[x] == 0) {
                    a[x] = 1;
                    m--;
                }
            }
        }
        out.println(m == 0 ? "YES" : "NO");
    }
}
