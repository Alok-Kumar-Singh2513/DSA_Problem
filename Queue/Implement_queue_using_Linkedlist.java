public class Implement_queue_using_Linkedlist {

  // Node class for linked list
  static class Node {
      int data;
      Node next;

      Node(int data) {
          this.data = data;
          this.next = null;
      }
  }

  // Queue class using linked list
  static class Queue {
      private Node front;
      private Node rear;
      private int size;

      public Queue() {
          front = null;
          rear = null;
          size = 0;
      }

      // Enqueue - add at rear
      public void enqueue(int data) {
          Node newNode = new Node(data);
          if (rear == null) {
              front = rear = newNode;
          } else {
              rear.next = newNode;
              rear = newNode;
          }
          size++;
      }

      // Dequeue - remove from front
      public int dequeue() {
          if (isEmpty()) {
              System.out.println("Queue underflow");
              return -1;
          }
          int data = front.data;
          front = front.next;
          if (front == null) {
              rear = null;
          }
          size--;
          return data;
      }

      // Peek - front element
      public int peek() {
          if (isEmpty()) {
              System.out.println("Queue is empty");
              return -1;
          }
          return front.data;
      }

      // Check if empty
      public boolean isEmpty() {
          return front == null;
      }

      // Get size
      public int size() {
          return size;
      }

      // Print queue
      public void printQueue() {
          Node current = front;
          System.out.print("Queue: ");
          while (current != null) {
              System.out.print(current.data + " ");
              current = current.next;
          }
          System.out.println();
      }
  }

  // Test the queue
  public static void main(String[] args) {
      Queue queue = new Queue();

      queue.enqueue(10);
      queue.enqueue(20);
      queue.enqueue(30);

      queue.printQueue(); // Output: Queue: 10 20 30

      System.out.println("Dequeued: " + queue.dequeue()); // Output: 10
      System.out.println("Front: " + queue.peek());        // Output: 20
      System.out.println("Is empty: " + queue.isEmpty());  // false
      System.out.println("Size: " + queue.size());         // 2

      queue.printQueue(); // Output: Queue: 20 30
  }
}
