package palayutm;

import java.util.Arrays;

public class Util {

    public static int[] shrink(int[] a) {
        int n = a.length;
        long[] b = new long[n];
        for (int i = 0; i < n; i++) {
            b[i] = (long) a[i] << 32 | i;
        }
        Arrays.sort(b);
        int[] ret = new int[n];
        int p = 0;
        ret[0] = (int) (b[0] >> 32);
        for (int i = 0; i < n; i++) {
            if (i > 0 && (b[i] ^ b[i - 1]) >> 32 != 0) {
                p++;
                ret[p] = (int) (b[i] >> 32);
            }
            a[(int) b[i]] = p;
        }
        return Arrays.copyOf(ret, p + 1);
    }
}
