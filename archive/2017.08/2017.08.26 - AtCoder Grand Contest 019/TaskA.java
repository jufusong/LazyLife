package main;

import palayutm.InputReader;
import java.io.PrintWriter;

import static java.lang.Math.min;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int q = in.nextInt(), h = in.nextInt(), s = in.nextInt(), d = in.nextInt();
        h = min(h, q * 2);
        s = min(s, h * 2);
        d = min(d, s * 2);
        int n = in.nextInt();
        out.println((long)n / 2 * d + (long) (n % 2) * s);
    }
}
