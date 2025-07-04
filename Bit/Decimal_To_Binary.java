package Bit;

public class Decimal_To_Binary {
  // logn is the time complexity for this method
  public static String decimalToBinary(int n) {
    if (n == 0) return "0"; 
    String result = "";
    while (n > 0) {
      result += (n % 2);
      n /= 2;
    }
    return new StringBuilder(result).reverse().toString(); 
  }

  public static void main(String[] args) {
    int n = 7; 
    
    String binaryRepresentation = decimalToBinary(n);
    System.out.println("Decimal: " + n + " in Binary: " + binaryRepresentation); 
  }
}
