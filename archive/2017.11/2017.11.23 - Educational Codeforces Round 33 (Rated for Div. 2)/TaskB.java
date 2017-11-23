package main;

import palayutm.util.io.InputReader;
import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int mx = 1;
        int n = in.nextInt();
        for (int i = 1; 2 * i - 1 <= 20; i++) {
            if (n % (((1 << i) - 1) * (1 << (i - 1))) == 0) {
                mx = ((1 << i) - 1) * (1 << (i - 1));
            }
        }
        out.println(mx);
    }
}
