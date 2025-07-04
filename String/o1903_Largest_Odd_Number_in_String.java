package String;

public class o1903_Largest_Odd_Number_in_String {
   public static String largestOddNumber(String num) {
      int n = num.length();
      StringBuilder result = new StringBuilder();

      // Traverse the string from the end to find the last odd digit
      for (int i = n - 1; i >= 0; i--) {
         if ((num.charAt(i) - '0') % 2 != 0) {
            // If we find an odd digit, append all digits up to and including this one
            result.append(num.substring(0, i + 1));
            return result.toString();
         }
        }
      return "";
        
    }
}
