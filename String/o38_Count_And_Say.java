package String;
// Description: The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
// countAndSay(1) = "1" countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1). To generate the next term in the sequence, we need to read the previous term and count the number of digits in groups of the same digit. For example, the previous term "21" is read as "one 2, then one 1", which is written as "1211". The following is the sequence: 1.     1 2.     11 3.     21 4.     1211 5.     111221 6.     312211
// Given a positive integer n, return the nth term of the count-and-say sequence.
public class o38_Count_And_Say {
  public static String countAndSay(int n) {
    if (n == 1) return "1";
    String say = countAndSay(n - 1);
    StringBuilder result = new StringBuilder();

    int count = 1;
    for (int i = 1; i < say.length(); i++) {
        if (say.charAt(i) == say.charAt(i - 1)) {
            count++;
        } else {
            result.append(count).append(say.charAt(i - 1));
            count = 1;
        }
    }

    // append the last group
    result.append(count).append(say.charAt(say.length() - 1));
    return result.toString();
}
public static void main(String[] args) {
    int n = 5; // Example input
    String result = countAndSay(n);
    System.out.println("The " + n + "th term in the count-and-say sequence is: " + result);
    // Output: The 5th term in the count-and-say sequence is: 111221
}
}
