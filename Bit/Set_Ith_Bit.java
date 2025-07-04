package Bit;

public class Set_Ith_Bit {
  public static int setIthBit(int n, int i) {
    return n | (1 << i);
  }
  public static void main(String[] args) {
    int n = 5; // 0101 in binary
    int i = 1; // Set the 1st bit
    int result = setIthBit(n, i);
    System.out.println("Number after setting the " + i + "th bit: " + result); // Should print 7 (0111 in binary)
  }
}
