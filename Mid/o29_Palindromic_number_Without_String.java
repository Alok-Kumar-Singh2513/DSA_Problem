public class o29_Palindromic_number_Without_String {
  public static boolean isPalindrome(int x) {
    if (x == 0)
      return true;
    int c = x;
    int sum = 0;
    while (c > 0) {
      int rem = x % 10;
      sum = (sum * 10) + rem;
      x = x / 10;

    }
    if (c == sum) {
      return true;
    } else {
      return false;
    }

  }

}
