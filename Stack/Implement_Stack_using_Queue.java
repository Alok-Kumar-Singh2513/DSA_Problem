package Stack;

import java.util.LinkedList;
import java.util.Queue;

public class Implement_Stack_using_Queue {
    
    class Stack {
        Queue<Integer> queue = new LinkedList<>();

        public void push(int x) {
            queue.add(x);
            int size = queue.size();
            // Rotate the queue to bring new element to the front
            for (int i = 0; i < size - 1; i++) {
                queue.add(queue.remove());
            }
        }

        public int pop() {
            if (queue.isEmpty()) {
                System.out.println("Stack underflow");
                return -1;
            }
            return queue.remove();
        }

        public int top() {
            if (queue.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return queue.peek();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }

        public int size() {
            return queue.size();
        }

        public void printStack() {
            System.out.println(queue);  // Not true stack order, but shows contents
        }
    }

    public static void main(String[] args) {
        Implement_Stack_using_Queue outer = new Implement_Stack_using_Queue();
        Stack stack = outer.new Stack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.printStack(); // Output: [30, 20, 10]

        System.out.println("Top: " + stack.top());   // Output: 30
        System.out.println("Popped: " + stack.pop()); // Output: 30
        System.out.println("Top: " + stack.top());   // Output: 20
        System.out.println("Is empty: " + stack.isEmpty()); // false
    }
}
