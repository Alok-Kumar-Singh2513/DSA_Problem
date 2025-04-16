package Sliding_Window;

public class o1423_Maximum_Points_You_Can_Obtain_from_Cards {
  public static int maxScore(int[] cardPoints, int k) {
    int leftSum=0;
    int rightSum=0;
    int maxSum=0;
    for(int i=0;i<k;i++){
        leftSum+=cardPoints[i];
    }

    maxSum=leftSum;
    int lastIndex=cardPoints.length-1;

    for(int i=k-1;i>=0;i--){
        leftSum-=cardPoints[i];
        rightSum+=cardPoints[lastIndex];
        lastIndex--;
        maxSum=Math.max(maxSum,leftSum+rightSum);
        
    }
 return maxSum;
}
public static void main(String[] args) {
    int[] cardPoints = {1,2,3,4,5,6,1};
    int k = 3;
    int maxPoints = maxScore(cardPoints, k);
    System.out.println("Maximum points you can obtain from cards: " + maxPoints);
}
}
