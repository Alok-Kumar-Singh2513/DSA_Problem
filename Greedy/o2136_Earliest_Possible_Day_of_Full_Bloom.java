package Greedy;

import java.util.Arrays;

public class o2136_Earliest_Possible_Day_of_Full_Bloom {
  public static int earliestFullBloom(int[] plantTime, int[] growTime) {
    int n=plantTime.length;
    int ans=0;
    int[][] arr=new int[n][2];
    for(int i=0;i<n;i++){
      arr[i][0]=plantTime[i];
      arr[i][1]=growTime[i];
    }
    // Sort the array based on growTime in descending order
    Arrays.sort(arr, (a,b)->b[1]-a[1]);
    int time=0;
    for(int i=0;i<n;i++){
      time+=arr[i][0];
      ans=Math.max(ans,time+arr[i][1]); 
    }
    return ans; 


  }
  public static void main(String[] args) {
    int[] plantTime = {1, 4, 3};
    int[] growTime = {2, 3, 1};
    System.out.println(earliestFullBloom(plantTime, growTime)); // Output: 9
    int[] plantTime2 = {1, 2, 3, 2};
    int[] growTime2 = {2, 1, 2, 1};
    System.out.println(earliestFullBloom(plantTime2, growTime2)); // Output: 9
  }
}
