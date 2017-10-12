package main;

import template.InputReader;
import java.io.PrintWriter;
import java.util.Random;

public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt(), start = in.nextInt(), x = in.nextInt();
        out.println("? " + start);
        out.flush();
        int mx = in.nextInt(), next = in.nextInt();
        if (mx >= x) {
            out.println("! " + mx);
            return;
        }
        for (int i = 0; i < 1200; i++) {
            int p = (int)(Math.random() * n) + 1;
            out.println("? " + p);
            out.flush();
            int v = in.nextInt(), y = in.nextInt();
            if (v < x && v > mx) {
                mx = v;
                next = y;
            }
        }
        for (int now = next; ;) {
            if (now == -1) {
                out.println("! -1");
                break;
            }
            out.println("? " + now);
            out.flush();
            int v = in.nextInt(), y = in.nextInt();
            if (v >= x) {
                out.println("! " + v);
                break;
            }
            now = y;
        }
    }
}
