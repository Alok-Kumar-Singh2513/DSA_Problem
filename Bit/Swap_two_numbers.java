package Bit;

public abstract class Swap_two_numbers {
  public static void swap(int a,int b) {
    if (a == b) return;
    b = a ^ b;
    a = a ^ b;
  }
  public static void main(String[] args) {
    int a = 5;
    int b = 10;
    
    System.out.println("Before swap: a = " + a + ", b = " + b);
    swap(a, b);
    System.out.println("After swap: a = " + a + ", b = " + b);
  }
}
