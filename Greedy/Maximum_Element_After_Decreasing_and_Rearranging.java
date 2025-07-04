package Greedy;

import java.util.Arrays;

public class Maximum_Element_After_Decreasing_and_Rearranging {
   public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
    int n= arr.length;
    Arrays.sort(arr);
    int maxElement=-1;
    for(int i=0;i<n;i++){
      if(i==0){
        arr[0]=1;
      }else if(arr[i]-arr[i-1]>1){
        arr[i]=arr[i-1]+1;
      }
      maxElement= Math.max(maxElement,arr[i]);
    }

    return maxElement;
  }
  public static void main(String[] args) {
    int[] arr = {3, 2, 1, 4, 5};
    int result = maximumElementAfterDecrementingAndRearranging(arr);
    System.out.println("Maximum element after decrementing and rearranging: " + result); // Output: 5
  }
}
