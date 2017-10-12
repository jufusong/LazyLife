package main;

import static java.lang.Math.min;

public class MulticoreProcessingEasy {
    public int fastestTime(int jobLength, int corePenalty, int[] speed, int[] cores) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < speed.length; i++) {
            for (int j = 1; j <= cores[i]; j++) {
                int x = (jobLength - 1) / j / speed[i] + 1 + corePenalty * (j - 1);
                ans = min(ans, x);
            }
        }
        return ans;
    }
}
