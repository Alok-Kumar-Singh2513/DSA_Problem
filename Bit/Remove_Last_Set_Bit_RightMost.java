package Bit;

public class Remove_Last_Set_Bit_RightMost {
  public static int removeLastSetBit(int n) {
    return n & (n - 1);
  }

  public static void main(String[] args) {
    int n = 5; // 0101 in binary
    int result = removeLastSetBit(n);
    System.out.println("Number after removing the last set bit: " + result); // Should print 4 (0100 in binary)
  }
}
