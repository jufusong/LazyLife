package main;

import template.InputReader;
import template.Util;

import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        Util.shrinkX(a);
        boolean[] vis = new boolean[n];
        ArrayList<ArrayList<Integer>> c = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                ArrayList<Integer> b = new ArrayList<>();
                vis[i] = true;
                b.add(i + 1);
                for (int j = a[i]; j != i; j = a[j]) {
                    vis[j] = true;
                    b.add(j + 1);
                }
                c.add(b);
            }
        }
        out.println(c.size());
        for (ArrayList<Integer> b : c) {
            out.print(b.size());
            for (int x : b) {
                out.print(" " + x);
            }
            out.println();
        }
    }
}
