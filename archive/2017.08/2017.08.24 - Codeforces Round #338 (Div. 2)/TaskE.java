package main;

import template.InputReader;
import java.io.PrintWriter;

import static java.lang.Math.min;

public class TaskE {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        long n = in.nextLong();
        long low = 0, high = (long)1e9;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (mid * 5 + mid * (mid - 1) / 2 * 6 > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        int[] dx = {1, -1, -2, -1, 1, 2};
        int[] dy = {2, 2, 0, -2, -2, 0};
        long x = high, y = high * -2;
        n -= high * 5 + high * (high - 1) / 2 * 6;
        for (int i = 0; i < 6 && n > 0; i++) {
            long b = min((i == 1 ? low - 1 : low), n);
            x += b * dx[i];
            y += b * dy[i];
            n -= b;
        }
        out.println(x + " " + y);
    }
}
