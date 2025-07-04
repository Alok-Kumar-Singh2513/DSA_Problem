package Greedy;

import java.util.Arrays;

public class o948_Bag_Of_Token {
  public static int bagOfTokensScore(int[] tokens, int power) {
    int right = tokens.length - 1;
    int left = 0;
    int score = 0;
    int maxScore = 0;
    Arrays.sort(tokens);
    while(left<=right){
      if(power>=tokens[left]){
        power-=tokens[left];
        score++;
        maxScore=Math.max(maxScore,score);
        left++;
      }else if(score>0){
        power+=tokens[right];
        score--;
        right--;
      }else{
        break;
      }
    }
    return maxScore;
  }
  public static void main(String[] args) {
    int[] tokens = {100, 200, 300, 400};
    int power = 200;
    System.out.println("Maximum score: " + bagOfTokensScore(tokens, power)); // Output: 2
    tokens = new int[]{100};
    power = 50;
    System.out.println("Maximum score: " + bagOfTokensScore(tokens, power)); // Output: 0
    tokens = new int[]{100, 200};
    power = 150;
    System.out.println("Maximum score: " + bagOfTokensScore(tokens, power)); // Output: 1
  }
}
