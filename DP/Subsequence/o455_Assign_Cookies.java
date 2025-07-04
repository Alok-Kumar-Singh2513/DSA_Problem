package Subsequence;

import java.util.Arrays;

public class o455_Assign_Cookies {
  public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int child = 0;
        int cookie = 0;

        while (child < g.length && cookie < s.length) {
            if (s[cookie] >= g[child]) {
                child++; // assign cookie to child
            }
            cookie++; // move to next cookie
        }

        return child; // total content children
    }
}
