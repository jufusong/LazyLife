package main;

import palayutm.util.io.InputReader;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int now = 3;
        for (int i = 0; i < n; i++) {
            int t = in.nextInt();
            if (t == now) {
                out.println("NO");
                return;
            }
            for (int j = 1; j <= 3; j++) {
                if (j != now && j != t) {
                    now = j;
                    break;
                }
            }
        }
        out.println("YES");
    }
}
