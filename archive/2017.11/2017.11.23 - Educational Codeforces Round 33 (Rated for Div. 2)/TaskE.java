package main;

import palayutm.combinatorics.Binomial;
import palayutm.util.io.InputReader;

import java.io.PrintWriter;
import java.util.ArrayList;

import static palayutm.numbers.IntegerUtils.powMod;

public class TaskE {
    final int mod = (int) (1e9 + 7);

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        Binomial bn = new Binomial(2000005, mod);
        ArrayList<Integer>[] a = new ArrayList[1000005];
        for (int i = 1; i <= 1000000; i++) {
            a[i] = new ArrayList<>();
        }
        for (int i = 2; i <= 1000000; i++) {
            if (a[i].isEmpty()) {
                for (int j = i + i; j <= 1000000; j += i) {
                    if (j % i == 0) {
                        int cnt = 0, t = j;
                        while (t % i == 0) {
                            t /= i;
                            cnt++;
                        }
                        a[j].add(cnt);
                    }
                }
                a[i].add(1);
            }
        }
        int T = in.nextInt();
        while (T-- > 0) {
            int x = in.nextInt(), y = in.nextInt();
            long ans = powMod(2, y - 1, mod);
            for (int k : a[x]) {
                ans = ans * bn.choose(k + y - 1, y - 1) % mod;
            }
            out.println(ans);
        }
    }
}
