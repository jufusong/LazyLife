package main;

public class MafiaGame {
    public double probabilityToLose(int N, int[] decisions) {
        int mx = 0, cnt = 0;
        int[] a = new int[N];
        for (int x : decisions) {
            a[x]++;
        }
        for (int x : a) {
            if (x > mx) {
                mx = x;
                cnt = 1;
            } else if (x == mx) {
                cnt++;
            }
        }
        if (mx == 1) return 0D;
        int now = cnt;
        while (true) {
            if (now == 0) return 0D;
            if (now == 1) return 1.0 / cnt;
            now = N % now;
        }
    }
}
