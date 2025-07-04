package Bit;

public class Binary_To_Decimal {
  // bit * 2^power

  public static int binaryToDecimal(String binary) {
    int result = 0;
    int power = 0;

    // Traverse from right to left (least significant bit to most significant)
    for (int i = binary.length() - 1; i >= 0; i--) {
      char bit = binary.charAt(i);
      if (bit == '1') {
        result += Math.pow(2, power);
      }
      power++;
    }

    return result;
  }

  public static void main(String[] args) {
    String binary = "1010";
    int decimal = binaryToDecimal(binary);
    System.out.println("Binary: " + binary + " in Decimal: " + decimal);
  }
}
