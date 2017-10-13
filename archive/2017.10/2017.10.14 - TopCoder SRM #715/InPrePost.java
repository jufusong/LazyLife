package main;

import java.util.Arrays;

public class InPrePost {

    boolean equal(int[] a1, int[] a2) {
        Arrays.sort(a1);
        Arrays.sort(a2);
        return Arrays.equals(a1, a2);
    }

    boolean check(String[] s, int[] a1, int[] a2, int[] a3, String md1, String md2, String md3) {
        if (md2.equals("pre")) {
            String t = md2; md2 = md1; md1 = t;
            int[] x = a2; a2 = a1;a1 = x;
        }
        if (md3.equals("pre")) {
            String t = md3; md3 = md1; md1 = t;
            int[] x = a3; a3 = a1; a1 = x;
        }
        if (md3.equals("in")) {
            String t = md3; md3 = md2; md2 = t;
            int[] x = a3; a3 = a2; a2 = x;
        }
        if (a1.length == 0) return true;
        if (a1[0] != a3[a3.length - 1]) return false;
        int root = 0;
        for (int i = 0; i < a1.length; i++) {
            if (a2[i] == a1[0]) {
                root = i;
            }
        }
        int[] a1l = Arrays.copyOfRange(a1, 1, 1 + root);
        int[] a2l = Arrays.copyOf(a2, root);
        int[] a3l = Arrays.copyOf(a3, root);
        int[] a1r = Arrays.copyOfRange(a1, 1 + root, a1.length);
        int[] a2r = Arrays.copyOfRange(a2, root + 1, a2.length);
        int[] a3r = Arrays.copyOfRange(a3, root, a3.length - 1);
        return equal(a1l.clone(), a2l.clone()) && equal(a1l.clone(), a3l.clone()) && check(s, a1l, a2l, a3l, s[0], s[2], s[4]) && check(s, a1r, a2r, a3r, s[1], s[3], s[5]);
    }

    public String isPossible(String[] s, int[] a1, int[] a2, int[] a3) {
        return check(s, a1, a2, a3, "pre", "in", "post") ? "Possible" : "Impossible";
    }
}
