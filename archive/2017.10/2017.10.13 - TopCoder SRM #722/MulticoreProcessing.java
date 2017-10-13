package main;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.sqrt;

public class MulticoreProcessing {
    public long fastestTime(long jobLength, int corePenalty, int[] speed, int[] cores) {
        long ans = jobLength;
        for (int i = 0; i < speed.length; i++) {
            long x;
            if (corePenalty > 0) {
                x = (long)sqrt(jobLength / ((long)speed[i] * corePenalty));
            } else {
                x = cores[i];
            }
            x = max(x, 1);
            x = min(cores[i], x);
            for (long j = max(1, x - 100000); j <= min(cores[i], x + 100000); j++) {
                ans = min(ans, (jobLength - 1) / j / speed[i] + corePenalty * (j - 1) + 1);
            }
        }
        return ans;
    }
}
