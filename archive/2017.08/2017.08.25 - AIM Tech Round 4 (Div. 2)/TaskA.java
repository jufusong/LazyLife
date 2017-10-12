package main;

import template.InputReader;
import java.io.PrintWriter;
import java.util.HashSet;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String s = in.next();
        int n = in.nextInt();
        if (n > s.length()) {
            out.println("impossible");
            return;
        }
        HashSet<Character> hs = new HashSet<>();
        for (char c : s.toCharArray()) {
            hs.add(c);
        }
        out.println(Math.max(0, n - hs.size()));
    }
}
