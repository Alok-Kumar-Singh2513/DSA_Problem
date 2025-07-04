package String;
// Description: Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
// Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M. Symbol       Value  I             1  V             5  X             10  L             50  C             100  D             500  M             1000
// For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
public class o12_Integer_To_Roman {
  public static String intToRoman(int num) {
    int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    String[] symbols = {
        "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    };
    StringBuilder roman = new StringBuilder();
    for(int i=0;i<values.length;i++){
      while(num>=values[i]){
        roman.append(symbols[i]);
        num-=values[i];
      }

    }
    return roman.toString();

  }
  // Second method
  public static String intToRoman2(int num) {
    int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    String[] symbols = {
        "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    };
    StringBuilder roman = new StringBuilder();
    // By modulus and division
    for(int i=0;i<values.length;i++){
      int count = num / values[i];
      num %= values[i];
      for(int j=0;j<count;j++){
        roman.append(symbols[i]);
      }
    }
    return roman.toString();
  }
}
