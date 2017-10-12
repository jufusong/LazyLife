package main;

public class TCPhoneHomeEasy {
    int cnt = 0;

    int[][] ch = new int[1006][10];
    int[] val = new int[1005];
    int top = 0;

    void dfs(int len, int p) {
        if (len == 0) {
            cnt++;
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (p == -1 || val[ch[p][i]] == 0) {
                if (p == -1 || ch[p][i] == 0) {
                    dfs(len - 1, -1);
                } else {
                    dfs(len - 1, ch[p][i]);
                }
            }
        }
    }

    public int validNumbers(int digits, String[] specialPrefixes) {
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
