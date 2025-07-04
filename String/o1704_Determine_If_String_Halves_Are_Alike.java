package String;
// Description: Given a string s of even length, return true if it can be partitioned into two equal parts such that the number of vowels in both halves is the same. Otherwise, return false.
public class o1704_Determine_If_String_Halves_Are_Alike {
  public static boolean isVowel(char ch) {
    return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
        || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
  }
  public static boolean halvesAreAlike(String s) {
    int n=s.length();
    int left=0;
    int right=n/2;
    int leftCount=0;
    int rightCount=0;
    while(left<n/2 && right<n){
      char leftChar=s.charAt(left);
      char rightChar=s.charAt(right);
      if(isVowel(leftChar)){
        leftCount++;
      }
      if(isVowel(rightChar)){
        rightCount++;
      }
      left++;
      right++;
    }
    return leftCount==rightCount;
  }
}
