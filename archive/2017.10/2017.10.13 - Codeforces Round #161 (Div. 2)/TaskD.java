package main;

import template.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TaskD {
    int N = 100005, K;

    ArrayList<Integer>[] g = new ArrayList[N];
    int[] dep = new int[N];
    int[] pre = new int[N];

    void dfs(int u, int fa) {
        dep[u] = dep[fa] + 1;
        pre[u] = fa;
        for (int v : g[u]) {
            if (dep[v] > 0) {
                if (dep[u] - dep[v] >= K) {
                    System.out.println(dep[u] - dep[v] + 1);
                    for (int t = u; ; t = pre[t]) {
                        System.out.print(t + " ");
                        if (t == v) break;
                    }
                    System.exit(0);
                }
            } else {
                dfs(v, u);
            }
        }
    }

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        K = in.nextInt();
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = in.nextInt(), v = in.nextInt();
            g[u].add(v);
            g[v].add(u);
        }
        dfs(1,0);
    }
}
