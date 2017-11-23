package palayutm;

import java.util.ArrayList;
import java.util.Stack;

import static java.lang.Math.min;


public class TarjanDCC {
    static int[] sta, dfn, low;
    static int lay, scc;
    static ArrayList<int[]>[] g;
    static Stack<Integer> st;

    private static void dfs(int u, int pre) {
        sta[u] = 1;
        dfn[u] = low[u] = ++lay;
        st.add(u);
        for (int[] e : g[u]) {
            int v = e[0], id = e[1];
            if (id != pre) {
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

    public static int[] getDCC(ArrayList<int[]> edge, int n) {
        sta = new int[n + 1];
        dfn = new int[n + 1];
        low = new int[n + 1];
        lay = scc = 0;
        g = new ArrayList[n + 1];
        st = new Stack<>();
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < edge.size(); i++) {
            int u = edge.get(i)[0], v = edge.get(i)[1];
            g[u].add(new int[]{v, i});
            g[v].add(new int[]{u, i});
        }
        for (int i = 1; i <= n; i++) {
            if (sta[i] == 0) {
                dfs(i, -1);
            }
        }
        return low.clone();
    }
}
