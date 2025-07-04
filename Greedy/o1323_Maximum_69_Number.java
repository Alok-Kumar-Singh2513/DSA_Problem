package Greedy;

public class o1323_Maximum_69_Number {
  public static int maximum69Number(int num) {
    int placeValue = 0;
    int placeValueSix = -1;
    int temp = num;

    // Find the position of the highest-place 6
    while (temp > 0) {
        int remainder = temp % 10;
        if (remainder == 6) {
            placeValueSix = placeValue;
        }
        temp = temp / 10;
        placeValue++;
    }

    if (placeValueSix == -1) {
        return num;  // No 6 to change
    }

    // Convert 6 to 9: just add 3 * 10^placeValueSix
    return (int)(num + 3 * Math.pow(10, placeValueSix));
}


// Second method
public static int maximum69Number1(int num) {
  char[] digits = String.valueOf(num).toCharArray();

  for (int i = 0; i < digits.length; i++) {
      if (digits[i] == '6') {
          digits[i] = '9';  
          break;
      }
  }

  return Integer.parseInt(new String(digits));
}

// Two make largest number from digits  swap 6 to 9 or 9 to 6

  public static void main(String[] args) {
    System.out.println(maximum69Number(9669));

  }
}
