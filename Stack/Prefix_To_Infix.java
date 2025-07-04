package Stack;
import java.util.Stack;
public class Prefix_To_Infix {
  static String prefixToInfix(String exp) {
    Stack<String> stack = new Stack<>();

    for (int i = exp.length() - 1; i >= 0; i--) {
        char c = exp.charAt(i);

        if (Character.isLetterOrDigit(c)) {
            stack.push(String.valueOf(c));
        } else {
            String operand1 = stack.pop();
            String operand2 = stack.pop();
//                top to bottom
            String infix = "(" + operand1 + c + operand2 + ")";
            stack.push(infix);
        }
    }

    return stack.peek();
}

public static void main(String[] args) {
    String exp = "*-A/BC-/AKL";
    System.out.println("Prefix expression: " + exp);
    System.out.println("Infix expression: " + prefixToInfix(exp));
}
}
