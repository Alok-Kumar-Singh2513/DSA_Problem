package Bit;

public class Clear_Ith_Bit {
  public static int clearIthBit(int n, int i) {
    return n & ~(1 << i);
  }

  public static void main(String[] args) {
    int n = 5; // 0101 in binary
    int i = 1; // Clear the 1st bit
    int result = clearIthBit(n, i);
    System.out.println("Number after clearing the " + i + "th bit: " + result); // Should print 4 (0100 in binary)
  }
}
