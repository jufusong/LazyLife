package main;

import template.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        ArrayList<Integer>[] g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList();
        }
        for (int i = 0; i < m; i++) {
            int u = in.nextInt(), v = in.nextInt();
            g[u].add(v);
            g[v].add(u);
        }
        int[] a = new int[n + 1];
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = 1;
            for (int v : g[i]) {
                if (v < i) {
                    a[i] = Integer.max(a[i], a[v] + 1);
                }
            }
            ans = Long.max(ans, (long)a[i] * g[i].size());
        }
        out.println(ans);
    }
}
