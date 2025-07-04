package String;
// Description: Given a string word, you need to judge whether the usage of capitals in it is right or not. We define the usage of capitals in a word to be right when one of the following cases holds:
// 1. All letters in this word are lowercase letters, like "word".
// 2. All letters in this word are uppercase letters, like "WORD".
// 3. Only the first letter in this word is upper case, like "Word".
// 4. There is no uppercase letter in this word, like "word".

public class o520_Detect_Capital {
  public static boolean allCapital(String word){
    for (char ch:word.toCharArray()){
        if (ch <'A' || ch > 'Z'){
            return false;
        }
    }
    return true;
}
public static boolean allSmall(String word){
    for (char ch:word.toCharArray()){
        if (ch <'a' || ch > 'z'){
            return false;
        }
    }
    return true;
}
public boolean detectCapitalUse(String word) {
        if (allCapital(word) || allSmall(word) || allSmall(word.substring(1))){
        return true;
    }
    return false;
    
}
public static void main(String[] args) {
    o520_Detect_Capital solution = new o520_Detect_Capital();
    String word = "Google";
    boolean result = solution.detectCapitalUse(word);
    System.out.println("The usage of capitals in the word is: " + result); // Output: true
}
}
