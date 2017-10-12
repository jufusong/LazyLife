package main;

import template.InputReader;
import java.io.PrintWriter;

public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt(), P = in.nextInt();
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            int L = in.nextInt(), R = in.nextInt();
            a[i] = (R / P - (L - 1) / P) * 1.0 / (R - L + 1);
        }
        double ans = 0.0;
        for (int i = 0; i < n; i++) {
            double x = a[i], y = a[(i + 1) % n];
            ans += (x + y - x * y) * 2000;
        }
        out.printf("%.14f", ans);
    }
}
