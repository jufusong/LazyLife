package main;

import palayutm.InputReader;
import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[3001];
        int[] X = new int[200001], Y = new int[200001];
        for (int i = 0; i < n; i++) {
            X[i] = in.nextInt();
            Y[i] = in.nextInt();
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += a[X[i] - Y[i] + 1000];
            a[X[i] - Y[i] + 1000]++;
        }
        a = new int[3001];
        for (int i = 0; i < n; i++) {
            ans += a[X[i] + Y[i] + 1000];
            a[X[i] + Y[i] + 1000]++;
        }
        out.println(ans);
    }
}
