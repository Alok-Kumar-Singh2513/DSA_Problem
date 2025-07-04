
import java.util.*;

public class o127_Word_Ladder {
  public static class Pair {
        String first;
        int second;
        Pair(String _first, int _second) {
            this.first = _first;
            this.second = _second;
        }
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Queue to store the word and the number of transformations
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        // Set to store the words for fast lookup
        Set<String> st = new HashSet<>(wordList);
        st.remove(beginWord);  // We can ignore the start word

        while (!q.isEmpty()) {
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();

            // If we reach the end word, return the number of steps
            if (word.equals(endWord)) return steps;

            // Try replacing each character of the word with 'a' to 'z'
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    // If the replaced word exists in the set, process it
                    if (st.contains(replacedWord)) {
                        st.remove(replacedWord);  // Remove from set to avoid cycles
                        q.add(new Pair(replacedWord, steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}
