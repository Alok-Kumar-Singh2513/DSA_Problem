package Bit;

public class Toggle_Ith_Bit {
  public static int toggleIthBit(int n, int i) {
    return n ^ (1 << i);
  }

  public static void main(String[] args) {
    int n = 5; // 0101 in binary
    int i = 1; // Toggle the 1st bit
    int result = toggleIthBit(n, i);
    System.out.println("Number after toggling the " + i + "th bit: " + result); // Should print 7 (0111 in binary)
  }

}
