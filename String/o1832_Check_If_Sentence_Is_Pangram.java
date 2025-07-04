package String;

public class o1832_Check_If_Sentence_Is_Pangram {
  public static boolean checkIfPangram(String sentence) {
    //  "a"+32="A"
    // "A"-32="a"
    // "a"-'a' = 0
    // "b"-'a' = 1
    int[] arr = new int[26];
    for (char ch : sentence.toCharArray()) {
      int index = ch - 'a';
      // System.out.println(index);
      arr[index]++;
    }
    for (int count : arr) {
      if (count == 0)
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    boolean result = checkIfPangram("thequickbrownfoxjumpsoverthelazydog");
    System.out.println("The sentence is a pangram: " + result);
  }
}
