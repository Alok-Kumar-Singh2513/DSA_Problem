package Stack;
import java.util.Stack;
public class Infix_To_Prefix  {
  static int Prec(char ch) {
    switch (ch) {
        case '+':
        case '-':
            return 1;
        case '*':
        case '/':
            return 2;
        case '^':
            return 3;
    }
    return -1;
}


static String reverse(String exp) {
    StringBuilder reversed = new StringBuilder(exp);
    return reversed.reverse().toString();
}
static String infixToPrefix(String exp) {
    exp = reverse(exp);
    String result = "";
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < exp.length(); ++i) {
        char c = exp.charAt(i);

        if (Character.isLetterOrDigit(c)) {
            result += c;
        } else if (c == '(') {
            stack.push(c);
        } else if (c == ')') {
            while (!stack.isEmpty() && stack.peek() != '(') {
                result += stack.pop();
            }
            stack.pop();
        } else {
            while (!stack.isEmpty() && Prec(c) < Prec(stack.peek())) {
                result += stack.pop();
            }
            stack.push(c);
        }
    }

    while (!stack.isEmpty()) {
        result += stack.pop();
    }

    return reverse(result);
}

public static void main(String[] args) {
    String exp = "(p+q)*(m-n)";
    System.out.println("Infix expression: " + exp);
    System.out.println("Prefix expression: " + infixToPrefix(exp));
}
}
