package Stack;
import java.util.Stack;
public class Postfix_To_Prefix {
  static String postfixToPrefix(String exp) {
    Stack<String> stack = new Stack<>();
    for (int i = 0; i < exp.length(); i++) {
        char c = exp.charAt(i);
        if (Character.isLetterOrDigit(c)) {
            stack.push(String.valueOf(c));
        }
        else {
            String operand2 = stack.pop();
            String operand1 = stack.pop();
            // Form a prefix expression by placing the operator before the operands
            String prefix = c + operand1 + operand2;
            stack.push(prefix);
        }
    }

    return stack.peek();
}

public static void main(String[] args) {
    String exp = "ABC*+DE/F-*";
    System.out.println("Postfix expression: " + exp);
    System.out.println("Prefix expression: " + postfixToPrefix(exp));
}
}
