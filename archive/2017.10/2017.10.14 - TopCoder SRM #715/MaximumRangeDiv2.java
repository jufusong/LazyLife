package main;

import static java.lang.Math.max;

public class MaximumRangeDiv2 {
    public int findMax(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+') {
                cnt++;
            }
        }
        return max(cnt, s.length() - cnt);
    }
}
