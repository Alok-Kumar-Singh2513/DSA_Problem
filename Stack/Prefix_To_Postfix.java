package Stack;
import java.util.Stack;
public class Prefix_To_Postfix {
  static String postfixToPrefix(String exp) {
    Stack<String> stack = new Stack<>();
    for (int i = exp.length() - 1; i >= 0; i--) {
        char c = exp.charAt(i);
        if (Character.isLetterOrDigit(c)) {
            stack.push(String.valueOf(c));
        }

        else {
            String operand1 = stack.pop();
            String operand2 = stack.pop();
            // Form a postfix expression by placing the operands before the operator
            String postfix = operand1 + operand2 + c;
            stack.push(postfix);
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
