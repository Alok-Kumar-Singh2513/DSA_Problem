import java.util.Stack;

public class Implement_Queue_using_Stack {

  static class Queue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    // Enqueue: Always O(1)
    public void enqueue(int data) {
      stack1.push(data);
    }

    // Dequeue: Amortized O(1), worst O(n) only when stack2 is empty
    public int dequeue() {
      if (isEmpty()) {
        System.out.println("Queue underflow");
        return -1;
      }

      if (stack2.isEmpty()) {
        // Transfer all from stack1 to stack2
        while (!stack1.isEmpty()) {
          stack2.push(stack1.pop());
        }
      }

      return stack2.pop();
    }

    // Peek: returns front element
    public int peek() {
      if (isEmpty()) {
        System.out.println("Queue is empty");
        return -1;
      }

      if (stack2.isEmpty()) {
        while (!stack1.isEmpty()) {
          stack2.push(stack1.pop());
        }
      }

      return stack2.peek();
    }

    public boolean isEmpty() {
      return stack1.isEmpty() && stack2.isEmpty();
    }

    public int size() {
      return stack1.size() + stack2.size();
    }

    public void printQueue() {
      // Not exact queue order without transferring, so optional
      Stack<Integer> temp = new Stack<>();
      while (!stack2.isEmpty()) {
        temp.push(stack2.pop());
      }

      for (int i = 0; i < stack1.size(); i++) {
        System.out.print(stack1.get(i) + " ");
      }

      while (!temp.isEmpty()) {
        int val = temp.pop();
        System.out.print(val + " ");
        stack2.push(val);
      }

      System.out.println();
    }
  }

  public static void main(String[] args) {
    Queue queue = new Queue();

    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);

    queue.printQueue(); // Output: 10 20 30 (order may vary slightly due to internal stack behavior)

    System.out.println("Dequeued: " + queue.dequeue()); // 10
    System.out.println("Front: " + queue.peek()); // 20
    System.out.println("Is empty: " + queue.isEmpty()); // false
    System.out.println("Size: " + queue.size()); // 2

    queue.printQueue(); // Output: 20 30
  }
}
