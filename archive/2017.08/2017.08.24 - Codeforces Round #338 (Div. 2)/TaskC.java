package main;

import palayutm.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String s = in.next(), t = in.next();
        StringBuilder sb = new StringBuilder(s);
        s = s + "$" + sb.reverse().toString();
        int n = s.length(), m = t.length();
        int[][] a = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    a[i][j] = a[i - 1][j - 1] + 1;
                } else {
                    a[i][j] = 0;
                }
            }
        }
        ArrayList<int[]> b = new ArrayList<int[]>();
        boolean flag = true;
        for (int i = m; i >= 1; ) {
            int p = 1;
            for (int j = 1; j <= n; j++) {
                if (a[p][i] < a[j][i]) {
                    p = j;
                }
            }
            if (a[p][i] == 0) {
                flag = false;
                break;
            }
            int[] c = new int[2];
            if (p > n / 2 + 1) {
                c[0] = n + 1 - (p - a[p][i] + 1);
                c[1] = n + 1 - p;
            } else {
                c[0] = p - a[p][i] + 1;
                c[1] = p;
            }
            b.add(c);
            i -= a[p][i];
        }
        if (!flag) {
            out.println(-1);
        } else {
            Collections.reverse(b);
            out.println(b.size());
            for (int[] c : b) {
                out.println(c[0] + " " + c[1]);
            }
        }
    }
}
