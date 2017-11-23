package main;

import palayutm.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        ArrayList<Integer>[] g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < 2 * n; i++) {
            int u = in.nextInt(), v = in.nextInt();
            g[u].add(v);
            g[v].add(u);
        }
        for (int i = 1; i <= n; i++) {
            if (g[i].size() != 4) {
                out.println(-1);
                return;
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i != j) {
                    int[] a = new int[n];
                    a[0] = 1;
                    a[1] = g[1].get(i);
                    a[2] = g[1].get(j);
                    boolean ok = true;
                    for (int k = 3; k < n; k++) {
                        boolean flag = false;
                        for (int ii = 0; ii < 4 && !flag; ii++) {
                            for (int jj = 0; jj < 4 && !flag; jj++) {
                                int tx = g[a[k - 1]].get(ii), ty = g[a[k - 2]].get(jj);
                                if (tx == ty && tx != a[k - 3] && tx != a[0]) {
                                    a[k] = tx;
                                    flag = true;
                                }
                            }
                        }
                        if (!flag) {
                            ok = false;
                            break;
                        }
                    }
                    for (int k = 0; k < n && ok; k++) {
                        for (int ii = 0; ii < 4; ii++) {
                            boolean flag = false;
                            int t = g[a[k]].get(ii);
                            for (int jj = -2; jj <= 2; jj++) {
                                flag |= (a[(k + jj + n) % n] == t);
                            }
                            ok &= flag;
                        }
                    }
                    if (ok) {
                        for (int x : a) {
                            out.print(x + " ");
                        }
                        return;
                    }
                }
            }
        }
        out.println(-1);
    }
}
