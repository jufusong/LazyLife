package main;

import java.util.Arrays;

public class SRMCards {
    public int maxTurns(int[] cards) {
        Arrays.sort(cards);
        int cnt = 0;
        for (int i = 0; i < cards.length; i++) {
            cnt++;
            if (i + 1 < cards.length && cards[i + 1] == cards[i] + 1) {
                i++;
            }
        }
        return cnt;
    }
}
