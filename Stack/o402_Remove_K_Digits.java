package Stack;

import java.util.Stack;

public class o402_Remove_K_Digits {
  public String removeKdigits(String num, int k) {
    Stack<Character> stack = new Stack<>();

   for (char ch : num.toCharArray()) {
       while (!stack.isEmpty() && stack.peek() > ch && k > 0) {
           stack.pop();
           k--;
       }
       stack.push(ch);
   }


   while (k > 0) {
       stack.pop();
       k--;
   }


   StringBuilder sb = new StringBuilder();
   for (char ch : stack) {
       sb.append(ch);
   }

   // Remove leading zeros
   while (sb.length() > 1 && sb.charAt(0) == '0') {
       sb.deleteCharAt(0);
   }

   // Handle empty case
   return sb.length() == 0 ? "0" : sb.toString();
  
}
}
