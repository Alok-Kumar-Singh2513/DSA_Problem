package Stack;

public class Implement_Stack_using_Arrays {
  public static class Stack {
    private int top;
    private int maxSize;
    private int[] stackArray;

    public Stack(int size) {
      this.maxSize = size;
      this.stackArray = new int[maxSize];
      this.top = -1;
    }

    public void push(int value) {
      if (top == maxSize - 1) {
        System.out.println("Stack is full. Cannot push " + value);
        return;
      }
      stackArray[++top] = value;
    }

    public int pop() {
      if (top == -1) {
        System.out.println("Stack is empty. Cannot pop.");
        return -1; 
      }
      return stackArray[top--];
    }

    public int peek() {
      if (top == -1) {
        System.out.println("Stack is empty. Cannot peek.");
        return -1; // or throw an exception
      }
      return stackArray[top];
    }

    public boolean isEmpty() {
      return top == -1;
    }

    public boolean isFull() {
      return top == maxSize - 1;
    }
  
    
  }
  public static void main(String[] args) {
    

  }
}
