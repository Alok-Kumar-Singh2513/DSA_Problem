package String;

import java.util.*;
// Description:
// A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
// For example, "01", "1.01", "
// 1.1.01" and "256.256.256.256" are invalid IP addresses, while "0", "10", "255", and "

public class o93_Restore_IP_Addresses {
    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        result.clear();
        int n = s.length();
        if (n > 12) {
            return new ArrayList<>();
        }
        int part = 0;
        String curren = "";
        return solve(s, 0, part, curren, result);

    }

    public static List<String> solve(String s, int index, int part, String curren, List<String> result) {
        if (part == 4 && index == s.length()) {
            result.add(curren.substring(0, curren.length() - 1));
            return result;
        }
        if (part > 4 || index >= s.length()) {
            return result;
        }

        if (index < s.length()) {
            String sub = s.substring(index, 1);

            solve(s, index + 1, part + 1, curren + sub + ".", result);

        }

        if (index < s.length()) {
            String sub = s.substring(index, 2);
            if (isValid(sub)) {
                solve(s, index + 1, part + 1, curren + sub + ".", result);
            }
        }
        if (index < s.length()) {
            String sub = s.substring(index, 3);
            if (isValid(sub)) {
                solve(s, index + 1, part + 1, curren + sub + ".", result);
            }
        }
        return result;
    }

    public static boolean isValid(String s) {
        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }

    public static void main(String[] args) {
        String s = "25525511135";
        List<String> result = restoreIpAddresses(s);
        System.out.println("Valid IP addresses: " + result);
        // Output: ["
        // "
    }

}
