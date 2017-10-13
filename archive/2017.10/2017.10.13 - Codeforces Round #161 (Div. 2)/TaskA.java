package main;

import template.InputReader;
import java.io.PrintWriter;

import static java.lang.Math.abs;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int x = 0, y = 0;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                if (in.nextInt() > 0) {
                    x = i;
                    y = j;
                }
            }
        }
        out.println(abs(x - 3) + abs(y - 3));
    }
}
