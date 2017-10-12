package main;

import java.util.ArrayList;

public class RainbowGraph {
    final long mod = (long)1e9 + 7;
    public int countWays(int[] color, int[] a, int[] b) {
        ArrayList<Integer>[] data = new ArrayList[10];
        for (int i = 0; i < 10; i++) {
            data[i] = new ArrayList<>();
        }
        int n = color.length;
        for (int i = 0; i < n; i++) {
            data[color[i]].add(i);
        }
        boolean[][] g = new boolean[n][n];
        for (int i = 0; i < a.length; i++) {
            g[a[i]][b[i]] = g[b[i]][a[i]] = true;
        }
        long[][] cnt = new long[n][n];
        for (int i = 0; i < 10; i++) {
            long[][][] dp = new long[1 << data[i].size()][data[i].size()][data[i].size()];
            for (int j = 0; j < data[i].size(); j++) {
                dp[1 << j][j][j] = 1;
            }
            for (int j = 1; j < (1 << data[i].size()); j++) {
                for (int k = 0; k < data[i].size(); k++) {
                    for (int h = 0; h < data[i].size(); h++) {
                        for (int v = 0; v < data[i].size(); v++) {
                            if (((1 << v) & j) == 0 && g[data[i].get(h)][data[i].get(v)]) {
                                dp[(1 << v) | j][k][v] = (dp[(1 << v) | j][k][v] + dp[j][k][h]) % mod;
                            }
                        }
                    }
                }
            }
            for (int j = 0; j < data[i].size(); j++) {
                for (int k = 0; k < data[i].size(); k++) {
                    cnt[data[i].get(j)][data[i].get(k)] = dp[(1 << data[i].size()) - 1][j][k];
                }
            }
        }
        long[][][] dp = new long[1 << 10][2][n];
        for (int i = 0; i < n; i++) {
            dp[1 << color[i]][0][i] = 1;
        }
        for (int i = 1; i < (1 << 10); i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][1][k] = (dp[i][1][k] + dp[i][0][j] * cnt[j][k]) % mod;
                }
            }
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (((1 << color[k]) & i) == 0 && g[j][k]) {
                        dp[(1 << color[k]) | i][0][k] = (dp[(1 << color[k]) | i][0][k] + dp[i][1][j]) % mod;
                    }
                }
            }
        }
        int sta = 0;
        for (int i = 0; i < 10; i++) {
            if (data[i].size() > 0) {
                sta ^= (1 << i);
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + dp[sta][1][i]) % mod;
        }
        return (int)ans;
    }
}
