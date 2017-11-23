package main;

import palayutm.util.io.InputReader;
import java.io.PrintWriter;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class TaskD {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt(), D = in.nextInt(), nowh = 0, nowl = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            if (x > 0) {
                if (nowl + x > D) {
                    out.println(-1);
                    return;
                }
                nowh = min(nowh + x, D);
                nowl += x;
            } else if (x < 0) {
                nowh += x;
                nowl += x;
            } else {
                if (nowh < 0) {
                    nowh = D;
                    nowl = 0;
                    ans++;
                } else {
                    nowl = max(nowl, 0);
                }
            }
        }
        out.println(ans);
    }
}
