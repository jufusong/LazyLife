package main;

import palayutm.InputReader;
import palayutm.Matrix;

import java.io.PrintWriter;

public class TaskE {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt(), b = in.nextInt(), k = in.nextInt(), x = in.nextInt();
        int[] a = new int[10];
        for (int i = 0; i < n; i++) {
            a[in.nextInt()]++;
        }
        Matrix m = new Matrix(x, x);
        for (int i = 0; i < x; i++) {
            for (int j = 1; j < 10; j++) {
                m.a[i][(i * 10 + j) % x] += a[j];
            }
        }
        m = m.pow(b);
        out.println(m.a[0][k]);
    }
}
