package Bit;

public class Check_If_The_Ith_Bit_Is_Set_Or_not {
  public static boolean isIthBitSet(int n, int i) {
    return (n & (1 << i)) != 0;
  }
  public static void main(String[] args) {
    int n = 5; // 0101 in binary
    int i = 2;
    System.out.println("Is the " + i + "th bit set in " + n + "? " + isIthBitSet(n, i));
  }

}
