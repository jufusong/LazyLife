package main;

public class SumProduct {
    final long mod = (long)1e9 + 7;
    public int findSum(int[] amount, int blank1, int blank2) {
        long[][] C = new long[201][201];
        for (int i = 0; i <= 200; i++) {
            C[i][0] = C[i][i] = 1;
            for (int j = 1; j < i; j++) {
                C[i][j] = (C[i - 1][j] + C[i - 1][j - 1]) % mod;
            }
        }
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += amount[i];
        }
        long[][] a = new long[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                amount[i]--;
                amount[j]--;
                if (amount[i] >= 0 && amount[j] >= 0) {
                    int len = blank1 + blank2 - 2;
                    long[][] dp = new long[11][len + 1];
                    dp[0][0] = 1;
                    for (int k = 0; k <= 9; k++) {
                        for (int h = 0; h <= len; h++) {
                            for (int o = 0; o <= amount[k] && o + h <= len; o++) {
                                dp[k + 1][h + o] = (dp[k + 1][h + o] + dp[k][h] * C[len - h][o]) % mod;
                            }
                        }
                    }
                    a[i][j] = dp[10][len];
                }
                amount[i]++;
                amount[j]++;
            }
        }
        System.out.println(a[2][3]);
        long[] P = new long[101];
        P[0] = 1;
        for (int i = 1; i <= 100; i++) {
            P[i] = P[i - 1] * 10 % mod;
        }
        long ans = 0;
        for (int i = 0; i < blank1; i++) {
            for (int j = 0; j < blank2; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int h = 0; h < 10; h++) {
                        ans = (ans + k * h * a[k][h] % mod * P[i] % mod * P[j]) % mod;
                    }
                }
            }
        }
        return (int)ans;
    }
}
