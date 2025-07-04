

public class o1639_Number_Of_Ways_To_From_Target_String_Given_A_Dictionary {
  public static int m;
  public static int k;
  public static int numWays(String[] words, String target) {
    m = target.length();
    k = words[0].length(); // assuming all words have the same length

    // Frequency array to count occurrences of each character in the words
    int[][] freq = new int[26][k];
    for (int col = 0; col < k; col++) {
        for (String word : words) {
            freq[word.charAt(col) - 'a'][col]++;
        }
    }

    // Create a memoization table
    Integer[][] memo = new Integer[m + 1][k + 1];
    return solve(0, 0, freq, target, memo);
}

public static int solve(int i, int j, int[][] freq, String target, Integer[][] memo) {
    if (i == m) return 1; // Reached the end of the target
    if (j == k) return 0; // Reached the end of words' columns

    if (memo[i][j] != null) return memo[i][j]; // Return already computed value

    // Option 1: Skip the current column
    int not_taken = solve(i, j + 1, freq, target, memo);

    // Option 2: Take the current character (if it matches the target character)
    int taken = 0;
    if (target.charAt(i) - 'a' >= 0) {
        taken = (int)((long)freq[target.charAt(i) - 'a'][j] * solve(i + 1, j + 1, freq, target, memo) % 1000000007);
    }

    // Save result in memo table
    memo[i][j] = (not_taken + taken) % 1000000007;
    return memo[i][j];
}
}
