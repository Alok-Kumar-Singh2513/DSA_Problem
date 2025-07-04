package String;
import java.util.Arrays;
// Description: Given a string s and an integer k, you can perform the following operation on the string: choose any two adjacent characters and swap them. If k is greater than 1, you can perform this operation any number of times. If k is equal to 1, you can only perform this operation once. The goal is to return the lexicographically smallest string that can be obtained by performing the operation.
public class o899_Orederly_Queue {
  public static String orderlyQueue(String s, int k) {
    if (k > 1) {
      char[] chars = s.toCharArray();
      Arrays.sort(chars);
      return new String(chars);
    } else {
      String min = s;  // Moved outside the for loop
      for (int i = 1; i < s.length(); i++) {
        String temp = s.substring(i) + s.substring(0, i);
        if (temp.compareTo(min) < 0) {
          min = temp;
        }
      }
      return min;
    }
  }
  public static void main(String[] args) {
    String s = "cba";
    int k = 1;
    System.out.println("Orderly Queue: " + orderlyQueue(s, k)); // Output: "acb"
    
    s = "baaca";
    k = 3;
    System.out.println("Orderly Queue: " + orderlyQueue(s, k)); // Output: "aaabc"
  }
}
