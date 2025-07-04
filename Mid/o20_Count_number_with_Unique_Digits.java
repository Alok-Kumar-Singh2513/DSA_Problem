public class o20_Count_number_with_Unique_Digits {
  public static int countNumbersWithUniqueDigits(int n) {
    if (n == 0) return 1; // Only the number 0
    if (n == 1) return 10; // Numbers from 0 to 9

    int count = 10; // Start with numbers from 0 to 9
    int uniqueDigits = 9; // Digits available for the first position (1-9)
    int availablePositions = 9; // Remaining positions (0-9 excluding the first digit)

    for (int i = 2; i <= n; i++) {
      count += uniqueDigits * availablePositions;
      uniqueDigits--;
      availablePositions--;
    }

    return count;
  }
}
