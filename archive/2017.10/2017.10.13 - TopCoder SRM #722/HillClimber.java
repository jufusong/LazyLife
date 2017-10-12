package main;

import static java.lang.Math.max;

public class HillClimber {
    public int longest(int[] height) {
        int mx = 0;
        for (int i = 1, now = 0; i < height.length; i++) {
            if (height[i] > height[i - 1]) {
                now++;
            } else {
                now = 0;
            }
            mx = max(mx, now);
        }
        return mx;
    }
}
