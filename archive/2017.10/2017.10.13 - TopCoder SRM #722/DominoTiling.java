package main;

import java.util.ArrayList;

public class DominoTiling {
    ArrayList<Integer>[] g;

    void dfs(int n, int S1, int S2) {
        if (n == 0) {
            g[S1].add(S2);
            return;
        }
        dfs(n - 1, S1 ^ (1 << (n - 1)), S2);
        dfs(n - 1, S1, S2 ^ (1 << (n - 1)));
        if (n >= 2) {
            dfs(n - 2, S1, S2);
        }
    }

    public long count(String[] grid) {
        int n = grid.length, m = grid[0].length();
        g = new ArrayList[1 << n];
        for (int i = 0; i < 1 << n; i++) {
            g[i] = new ArrayList<>();
        }
        dfs(n, 0, 0);
        long[][] f = new long[m + 1][1 << n];
        f[0][0] = 1;
        for (int i = 0; i < m; i++) {
            int mask = 0;
            for (int j = 0; j < n; j++) {
                if (grid[j].charAt(i) == 'X') {
                    mask ^= (1 << j);
                }
            }
            for (int S = 0; S < 1 << n; S++) {
                if ((S & mask) == 0) {
                    for (int x : g[S | mask]) {
                        f[i + 1][x] += f[i][S];
                    }
                }
            }
        }
        return f[m][0];
    }
}
