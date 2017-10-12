package main;

import template.InputReader;
import template.Util;

import java.io.PrintWriter;

public class TaskD {
    final long mod = (long) 1e9 + 7;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[200001];
        for (int i = 0; i < n; i++) {
            a[in.nextInt()]++;
        }
        long ans = 1, cnt = 1;
        for (int i = 1; i <= 200000; i++) {
            ans = Util.powMod(ans, a[i] + 1, mod) % mod * Util.powMod(i, (long) (1 + a[i]) * a[i] / 2 % (mod - 1) * cnt, mod) % mod;
            cnt = cnt * (a[i] + 1) % (mod - 1);
        }
        out.println(ans);
    }
}
