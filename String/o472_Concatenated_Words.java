package String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
// Description:
// A concatenated word is defined as a string that can be formed by concatenating at least two shorter words in the given dictionary. 
// For example, "applebanana" can be formed by concatenating "apple", "banana", and "applebananapples" can be formed by concatenating "apple", "banana", and "apples".
// Given an array of strings words, return all the concatenated words in the given dictionary that can be formed by concatenating at least two shorter words in the dictionary.
public class o472_Concatenated_Words {
     public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> wordSet = new HashSet<>();
        for (String word : words) {
            wordSet.add(word);
        }
        
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (isConcatenated(word, wordSet)) {
                result.add(word);
            }
        }
        
        return result;
    }

    private static boolean isConcatenated(String word, HashSet<String> wordSet) {
        int n = word.length();
       for(int i=0;i<n;i++){
        String prefix=word.substring(0,i+1);
        String suffix=word.substring(i+1);
        if(wordSet.contains(prefix)){
            if(wordSet.contains(suffix) || isConcatenated(suffix,wordSet)){
                return true;
            }
        }
       }
        return false;
    }
    public static void main(String[] args) {
        String[] words = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        List<String> result = findAllConcatenatedWordsInADict(words);
        System.out.println("Concatenated words: " + result);
        // Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
    }
}
