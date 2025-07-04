package String;
// Description: Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise. A string is represented by an array if the array elements concatenated in order forms the string.
public class o1662_Check_If_Two_String_Arrays_are_Equivalent {
  public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
    StringBuilder str1 = new StringBuilder();
    StringBuilder str2 = new StringBuilder();

    for (String word : word1) {
      str1.append(word);
    }

    for (String word : word2) {
      str2.append(word);
    }

    return str1.toString().equals(str2.toString());
  }

  // Second method
  public static boolean arrayStringsAreEqual2(String[] word1, String[] word2) {
    int i1 = 0, j1 = 0; // i1: index for word1[], j1: index within word1[i1]
    int i2 = 0, j2 = 0; // i2: index for word2[], j2: index within word2[i2]

    while (i1 < word1.length && i2 < word2.length) {
        if (word1[i1].charAt(j1) != word2[i2].charAt(j2)) {
            return false;
        }

        j1++;
        j2++;

        if (j1 == word1[i1].length()) {
            j1 = 0;
            i1++;
        }

        if (j2 == word2[i2].length()) {
            j2 = 0;
            i2++;
        }
    }

    return i1 == word1.length && i2 == word2.length;
}
public static void main(String[] args) {
    String[] word1 = {"ab", "c"};
    String[] word2 = {"a", "bc"};

    boolean result1 = arrayStringsAreEqual(word1, word2);
    boolean result2 = arrayStringsAreEqual2(word1, word2);

    System.out.println("Result using first method: " + result1); // Output: true
    System.out.println("Result using second method: " + result2); // Output: true
}

}
