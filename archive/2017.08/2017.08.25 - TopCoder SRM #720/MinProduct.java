package main;

import java.util.ArrayList;

public class MinProduct {
    public long findMin(int[] amount, int blank1, int blank2) {
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j < amount[i] && a.size() < blank1 + blank2; j++) {
                a.add(i);
            }
        }
        long ret = Long.MAX_VALUE;
        for (int i = 0; i < (1 << a.size()); i++) {
            int cnt = 0;
            long x = 0, y = 0;
            for (int j = 0; j < a.size(); j++) {
                if (((1 << j) & i) > 0) {
                    cnt++;
                    x = x * 10 + a.get(j);
                } else {
                    y = y * 10 + a.get(j);
                }
            }
            if (cnt == blank1) {
                ret = Math.min(ret, x * y);
            }
        }
        return ret;
    }
}
