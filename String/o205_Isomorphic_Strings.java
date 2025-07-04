package String;

import java.util.HashMap;

public class o205_Isomorphic_Strings {
    public static boolean isIsomorphic(String s, String t) {
        int ss=s.length();
        int tt=t.length();
        if (ss != tt) {
            return false;
        }
        HashMap<Character, Character> mapS = new HashMap<>();
        HashMap<Character, Character> mapT = new HashMap<>();
        for (int i = 0; i < ss; i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (mapS.containsKey(charS) && mapS.get(charS) != charT) {
                return false;
            }
            if (mapT.containsKey(charT) && mapT.get(charT) != charS) {
                return false;
            }

            mapS.put(charS, charT);
            mapT.put(charT, charS);
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println("Test 1 (egg, add): " + isIsomorphic("egg", "add")); // Expected: true
        System.out.println("Test 2 (foo, bar): " + isIsomorphic("foo", "bar")); // Expected: false
        
    }
}
