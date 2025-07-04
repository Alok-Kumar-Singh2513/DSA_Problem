package Stack;

import java.util.Stack;

public class o20_Valid_Parentheses {
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();

    for (char c : s.toCharArray()) {
      // Push opening brackets onto the stack
      if (c == '(' || c == '[' || c == '{') {
        stack.push(c);
      }
      // Check for closing brackets
      else if (c == ')' || c == ']' || c == '}') {
        // If stack is empty or top of stack doesn't match
        if (stack.isEmpty() || !isMatchingPair(stack.pop(), c)) {
          return false;
        }
      }
    }

    // If stack is empty, all parentheses matched correctly
    return stack.isEmpty();
  }

  private boolean isMatchingPair(char opening, char closing) {
    return (opening == '(' && closing == ')') ||
        (opening == '[' && closing == ']') ||
        (opening == '{' && closing == '}');
  }
}
