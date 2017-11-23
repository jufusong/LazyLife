package palayutm.combinatorics;

import static palayutm.numbers.IntegerUtils.preInverse;

public class Binomial {
    private int n, md;
    public long[] factorial, inv_factorial;

    public Binomial(int n, int mod) {
        this.n = n;
        this.md = mod;
        factorial = new long[n + 1];
        inv_factorial = preInverse(n, md);
        factorial[0] = inv_factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i % md;
            inv_factorial[i] = inv_factorial[i - 1] * inv_factorial[i] % md;
        }
    }

    public long choose(int n, int k) {
        if (k > n) return 0;
        return factorial[n] * inv_factorial[k] % md * inv_factorial[n - k] % md;
    }
}
