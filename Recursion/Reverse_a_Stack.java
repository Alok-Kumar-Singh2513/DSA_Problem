package Recursion;

import java.util.Stack;

public class Reverse_a_Stack {
  // using recusion to reverse a stack
  static void reverse(Stack<Integer> s)
  {
      // add your code here
      if(s.isEmpty()){
          return;
      }
      int x = s.pop();
      reverse(s);
      insertAtBottom(s, x);


  }
  static void insertAtBottom(Stack<Integer> s, int x)
  {
      // add your code here
      if(s.isEmpty()){
          s.push(x);
          return;
      }
      int a = s.pop();
      insertAtBottom(s, x);
      s.push(a);
  }
  public static void main(String[] args) {
      Stack<Integer> s = new Stack<>();
      s.push(1);
      s.push(2);
      s.push(3);
      s.push(4);
      s.push(5);
      System.out.println("Original Stack: " + s);
      reverse(s);
      System.out.println("Reversed Stack: " + s);
  }

}
