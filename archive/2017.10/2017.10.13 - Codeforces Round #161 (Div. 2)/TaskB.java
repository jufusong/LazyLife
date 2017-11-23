package main;

import palayutm.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;

public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        if (k <= n) {
            out.println(a[n - k] + " " + a[n - k]);
        } else {
            out.println(-1);
        }
    }
}
