package palayutm.numbers;

public class IntegerUtils {
    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int gcd(int a, int b) {
        return (int) gcd((long) a, (long) b);
    }

    public static long[] preInverse(int n, int md) {
        long[] inv = new long[n + 1];
        inv[1] = 1;
        for (int i = 2; i <= n; ++i) {
            inv[i] = (md - md / i) * inv[md % i] % md;
        }
        return inv;
    }

    public static long powMod(long x, long y, int mod) {
        long ret = 1;
        x %= mod;
        while (y > 0) {
            if (y % 2 > 0) {
                ret = ret * x % mod;
            }
            x = x * x % mod;
            y >>= 1;
        }
        return ret;
    }
}
