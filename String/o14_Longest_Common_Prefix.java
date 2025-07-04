package String;

public class o14_Longest_Common_Prefix {
   public static String longestCommonPrefix(String[] s) {
    int n = s.length;
    if (n == 0) return "";
    if (n == 1) return s[0];
    String prefixAtFirstIndex = s[0];
    String prifixLastIndex=s[s.length-1];
    int index = 0;
    for(int i=0;i<n;i++){
      if(prefixAtFirstIndex.charAt(i) != prifixLastIndex.charAt(i)){
        index++;
      }else{
        break;
      }
    }
    return  index==0 ? "" :prefixAtFirstIndex.substring(0, index);

   }
}
