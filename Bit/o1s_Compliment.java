package Bit;

public class o1s_Compliment {
  public static int onesComplement(int n) {
    int numBits = Integer.toBinaryString(n).length();
    int mask = (1 << numBits) - 1;
    
    
    // XOR n with the mask to get the one's complement
    return n ^ mask;
  }
  
}
