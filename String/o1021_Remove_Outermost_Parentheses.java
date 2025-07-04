package String;

public class o1021_Remove_Outermost_Parentheses {
   public static String removeOuterParentheses(String s) {
      StringBuilder result = new StringBuilder();
      int depth = 0;

      for (int i = 0; i < s.length(); i++) {
         char c = s.charAt(i);
         if (c == '(') {
            if (depth > 0) {
               result.append(c);
            }
            depth++;
         } else if (c == ')') {
            depth--;
            if (depth > 0) {
               result.append(c);
            }
         }
      }

      return result.toString();
        
    }
    public static void main(String[] args) {
        String s = "(()())(())";
        String result = removeOuterParentheses(s);
        System.out.println("Result: " + result); // Output: "()()()"
        
        s = "(()())(())(()(()))";
        result = removeOuterParentheses(s);
        System.out.println("Result: " + result); // Output: "()()()()(())"
        
        s = "()()";
        result = removeOuterParentheses(s);
        System.out.println("Result: " + result); // Output: ""
    }
}
