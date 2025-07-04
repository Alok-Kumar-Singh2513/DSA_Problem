public class Implement_Queue_using_Arrays {
    
  static class Queue {
      int[] arr;
      int front;
      int rear;
      int size;
      int capacity;

      public Queue(int capacity) {
          this.capacity = capacity;
          arr = new int[capacity];
          front = 0;
          rear = 0;
          size = 0;
      }

      public void enqueue(int data) {
          if (isFull()) {
              System.out.println("Queue overflow");
              return;
          }
          arr[rear] = data;
          rear = (rear + 1) % capacity;
          size++;
      }

      public int dequeue() {
          if (isEmpty()) {
              System.out.println("Queue underflow");
              return -1;
          }
          int data = arr[front];
          front = (front + 1) % capacity;
          size--;
          return data;
      }

      public int peek() {
          if (isEmpty()) {
              System.out.println("Queue is empty");
              return -1;
          }
          return arr[front];
      }

      public boolean isEmpty() {
          return size == 0;
      }

      public boolean isFull() {
          return size == capacity;
      }

      public int getSize() {
          return size;
      }

      public void printQueue() {
          if (isEmpty()) {
              System.out.println("Queue is empty");
              return;
          }
          System.out.print("Queue: ");
          for (int i = 0; i < size; i++) {
              System.out.print(arr[(front + i) % capacity] + " ");
          }
          System.out.println();
      }
  }

  // Main method to test
  public static void main(String[] args) {
      Queue queue = new Queue(5);

      queue.enqueue(10);
      queue.enqueue(20);
      queue.enqueue(30);
      queue.printQueue(); // Output: Queue: 10 20 30

      System.out.println("Dequeued: " + queue.dequeue()); // Output: 10
      System.out.println("Front: " + queue.peek()); // Output: 20

      queue.enqueue(40);
      queue.enqueue(50);
      queue.enqueue(60); // Should work
      queue.enqueue(70); // Should print overflow

      queue.printQueue(); // Output: Queue: 20 30 40 50 60
  }
}
