package main;

import palayutm.util.io.InputReader;
import java.io.PrintWriter;

import static java.lang.Math.min;

public class TaskC {
    final int N = 100005;
    int[] pre = new int[N];
    int[] val = new int[N];

    int find(int u) {
        return pre[u] == u ? u : (pre[u] = find(pre[u]));
    }

    void merge(int u, int v) {
        int fu = find(u), fv = find(v);
        pre[fu] = fv;
        val[fv] = min(val[fv], val[fu]);
    }

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        for (int i = 1; i <= n; i++) {
            pre[i] = i;
            val[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int u = in.nextInt(), v = in.nextInt();
            merge(u, v);
        }
        boolean[] vis = new boolean[n + 1];
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            int f = find(i);
            if (!vis[f]) {
                vis[f] = true;
                ans += val[f];
            }
        }
        out.println(ans);
    }
}
