package main;

public class TCPhoneHome {
    long cnt = 0;
    long[] P10 = new long[19];
    int[][] ch = new int[1006][10];
    int[] val = new int[1005];
    int top = 0;

    void dfs(int len, int p) {
        if (p == -1) {
            cnt += P10[len];
            return;
        }
        if (len == 0) {
            cnt++;
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (val[ch[p][i]] == 0) {
                if (ch[p][i] == 0) {
                    dfs(len - 1, -1);
                } else {
                    dfs(len - 1, ch[p][i]);
                }
            }
        }
    }
    public long validNumbers(int digits, String[] specialPrefixes) {
        P10[0] = 1;
        for (int i = 1; i < 19; i++) {
            P10[i] = P10[i - 1] * 10;
        }
        for (String x : specialPrefixes) {
            int now = 0;
            for (int i = 0; i < x.length(); i++) {
                int c = x.charAt(i) - '0';
                if (ch[now][c] == 0) {
                    ch[now][c] = ++top;
                }
                now = ch[now][c];
            }
            val[now] = 1;
        }
        dfs(digits, 0);
        return cnt;
    }
}
