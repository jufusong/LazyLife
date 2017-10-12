package main;



import template.InputReader;
import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String s = in.next();
        long ans = 1;
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            for (int j = 0; j < 26; j++) {
                if (j != c) {
                    ans += cnt[j];
                }
            }
            cnt[c]++;
        }
        out.println(ans);
    }
}
