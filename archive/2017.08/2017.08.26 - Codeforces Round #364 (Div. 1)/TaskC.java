package main;



import palayutm.InputReader;

import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;

import static java.lang.Math.min;

public class TaskC {
    class Edge{
        int u, v, w, id;
        public Edge(int u, int v, int w, int id) {
            this.u = u;
            this.v = v;
            this.w = w;
            this.id = id;
        }
    };

    ArrayList<Edge>[] g;
    int ban = -1;


    public ArrayList<Integer> getPath(ArrayList<Edge> edge, int s, int t, int n, int ban) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        boolean[] vis = new boolean[n + 1];
        int[] pre = new int[n + 1];
        vis[s] = true;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (Edge e : g[u]) {
                if (!vis[e.v] && e.id != ban) {
                    vis[e.v] = true;
                    pre[e.v] = e.id;
                    q.add(e.v);
                }
            }
        }
        if (!vis[t]) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = t; i != s; ) {
            int p = pre[i];
            ret.add(p);
            if (edge.get(p).u == i) {
                i = edge.get(p).v;
            } else {
                i = edge.get(p).u;
            }
        }
        return ret;
    }

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        ArrayList<Edge> edge = new ArrayList<>();
        int n = in.nextInt(), m = in.nextInt();
        int s = in.nextInt(), t = in.nextInt();
        g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = in.nextInt(), v = in.nextInt(), w = in.nextInt();
            edge.add(new Edge(u, v, w, i));
            g[u].add(new Edge(u, v, w, i));
            g[v].add(new Edge(v, u, w, i));
        }
        ArrayList<Integer> path = getPath(edge, s, t, n, -1);
        if (path.size() == 0) {
            out.println("0\n0");
            return;
        }
        long ans = Long.MAX_VALUE;
        int idx = -1, idy = -1;
        ArrayList<int[]> newedge = new ArrayList<>();
        for (Edge e : edge) {
            newedge.add(new int[]{e.u, e.v});
        }
        for (int id : path) {
            newedge.remove(id);
            int[] dcc = TarjanDCC.getDCC(g, n, id);
            ArrayList<Integer> newpath = getPath(edge, s, t, n, id);
            if (newpath.size() == 0) {
                int w = edge.get(id).w;
                if (w < ans) {
                    ans = w;
                    idx = id + 1;
                    idy = -1;
                }
            } else {
                for (int x : newpath) {
                    if (dcc[edge.get(x).u] != dcc[edge.get(x).v]) {
                        int w = edge.get(id).w + edge.get(x).w;
                        if (w < ans) {
                            ans = w;
                            idx = id + 1;
                            idy = x + 1;
                        }
                    }
                }
            }
            newedge.add(id, new int[]{edge.get(id).u, edge.get(id).v});
        }
        if (ans == Long.MAX_VALUE) {
            out.println(-1);
        } else {
            out.println(ans);
            if (idy == -1) {
                out.println(1);
                out.println(idx);
            } else {
                out.println(2);
                out.println(idx + " " + idy);
            }
        }
    }
}

class TarjanDCC {
    static int[] sta, dfn, low;
    static int lay, scc;
    static ArrayList<TaskC.Edge>[] g;
    static Stack<Integer> st;
    static int ban;

    private static void dfs(int u, int pre) {
        sta[u] = 1;
        dfn[u] = low[u] = ++lay;
        st.add(u);
        for (TaskC.Edge e : g[u]) {
            int v = e.v, id = e.id;
            if (id != pre && id != ban) {
                if (sta[v] == 0) {
                    dfs(v, id);
                }
                if (sta[v] == 1) {
                    low[u] = min(low[u], low[v]);
                }
            }
        }
        if (low[u] == dfn[u]) {
            scc++;
            while (true) {
                int v = st.pop();
                low[v] = scc;
                sta[v] = 2;
                if (v == u) {
                    break;
                }
            }
        }
    }

    public static int[] getDCC(ArrayList<TaskC.Edge>[] g, int n, int ban) {
        sta = new int[n + 1];
        dfn = new int[n + 1];
        low = new int[n + 1];
        lay = scc = 0;
        st = new Stack<>();
        TarjanDCC.g = g;
        TarjanDCC.ban = ban;
        for (int i = 1; i <= n; i++) {
            if (sta[i] == 0) {
                dfs(i, -1);
            }
        }
        return low.clone();
    }
}
