package MTE;

import java.util.Arrays;

public class o14_Longest_Common_Prefix {
   public static String longestCommonPrefix(String[] s) {
        Arrays.sort(s);
        String str1=s[0];
        String str2=s[s.length-1];
        int index=0;

        while (index <str1.length()){
            if (str1.charAt(index)==str2.charAt(index)){
                index++;
            }
            else {
                break;
            }
        }
        return index==0 ? "" :str1.substring(0,index);
    }
}
