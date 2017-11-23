package main;

import palayutm.InputReader;
import java.io.PrintWriter;

import static java.lang.Math.min;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt(), cnt = 0, mx = Integer.MAX_VALUE;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int t = in.nextInt();
            if (t % 2 > 0) {
                cnt++;
                mx = min(mx, t);
            }
            ans += t;
        }
        if (cnt % 2 > 0) {
            ans -= mx;
        }
        out.println(ans);
    }
}
