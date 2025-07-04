package Stack;

public class Implement_stack_using_Linkedlist {

    // Node class
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Stack class using Linked List
    public static class Stack {
        private Node head; // Top of the stack
        private int size;

        public Stack() {
            head = null;
            size = 0;
        }

        public void push(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
            size++;
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack underflow");
                return -1;
            }
            int data = head.data;
            head = head.next;
            size--;
            return data;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return head.data;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public int size() {
            return size;
        }

        public void printStack() {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    // Main method to test the stack
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.printStack(); // Output: 30 20 10

        System.out.println("Top: " + stack.peek());  // Output: 30
        System.out.println("Popped: " + stack.pop()); // Output: 30
        System.out.println("New Top: " + stack.peek()); // Output: 20
        System.out.println("Is empty: " + stack.isEmpty()); // Output: false
        System.out.println("Size: " + stack.size()); // Output: 2
    }
}
