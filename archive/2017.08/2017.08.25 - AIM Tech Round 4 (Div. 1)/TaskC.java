package main;

import palayutm.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TaskC {
    ArrayList<Integer>[] g = new ArrayList[200001];
    int[] msz = new int[200001];
    int[] sz = new int[200001];
    int n;
    ArrayList<int[]> ans = new ArrayList<>();

    void add(int x, int y, int z) {
        int[] t = {x, y, z};
        ans.add(t);
    }

    void dfs1(int u, int fa) {
        sz[u] = 1;
        for (int v : g[u]) {
            if (v != fa) {
                dfs1(v, u);
                sz[u] += sz[v];
                msz[u] = Math.max(msz[u], sz[v]);
            }
        }
        msz[u] = Math.max(msz[u], n - sz[u]);
    }

    int goal, root, last;

    void dfs2(int u, int fa) {
        if (u != goal) {
            add(root, last, u);
            add(u, fa, goal);
            last = u;
        }
        for (int v : g[u]) {
            if (v != fa) {
                dfs2(v, u);
            }
        }
    }

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt(), v = in.nextInt();
            g[u].add(v);
            g[v].add(u);
        }
        dfs1(1, -1);
        int[] a = new int[2];
        int mx = n + 1;
        for (int i = 1; i <= n; i++) {
            if (msz[i] < mx) {
                mx = msz[i];
                a[0] = i;
                a[1] = -1;
            } else if (msz[i] == mx) {
                a[1] = i;
            }
        }
        root = a[0];
        for (int v : g[a[0]]) {
            if (v != a[1]) {
                goal = last = v;
                dfs2(v, a[0]);
                add(a[0], last, v);
            }
        }
        if (a[1] != -1) {
            root = a[1];
            for (int v : g[a[1]]) {
                if (v != a[0]) {
                    goal = last = v;
                    dfs2(v, a[1]);
                    add(a[1], last, v);
                }
            }
        }
        out.println(ans.size());
        for (int[] arr : ans) {
            out.println(arr[0] + " " + arr[1] + " " + arr[2]);
        }
    }
}
