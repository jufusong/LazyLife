package main;

import palayutm.numbers.IntegerUtils;
import palayutm.util.io.InputReader;
import java.io.PrintWriter;

import static java.lang.Math.min;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt(), cnt = 0;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int x : a) {
            cnt += (x == 1 ? 1 : 0);
        }
        if (cnt > 0) {
            out.println(n - cnt);
            return;
        }
        int d = n;
        for (int i = 0; i < n; i++) {
            int g = a[i];
            for (int j = i; j < n; j++) {
                g = IntegerUtils.gcd(g, a[j]);
                if (g == 1) {
                    d = min(d, j - i);
                }
            }
        }
        if (d == n) {
            out.println(-1);
            return;
        }
        out.println(n + d - 1);
    }
}
