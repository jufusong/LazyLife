package main;

import template.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TaskB {
    int[] a = new int[200001];
    int[] b = new int[200001];
    int n, k;
    ArrayList<Integer>[] g = new ArrayList[200001];
    long ans = 0;

    void dfs(int u, int fa) {
        b[u] += a[u];
        for (int v : g[u]) {
            if (v != fa) {
                dfs(v, u);
                ans += Math.min(b[v], 2 * k - b[v]);
                b[u] += b[v];
            }
        }
    }

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        k = in.nextInt();
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < 2 * k; i++) {
            a[in.nextInt()] = 1;
        }
        for (int i = 1; i < n; i++) {
            int u = in.nextInt(), v = in.nextInt();
            g[u].add(v);
            g[v].add(u);
        }
        dfs(1, 0);
        out.println(ans);
    }
}
