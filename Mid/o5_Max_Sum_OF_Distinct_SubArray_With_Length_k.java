public class o5_Max_Sum_OF_Distinct_SubArray_With_Length_k {
  public static int maximumSubarraySum(int []nums,int key){
    int n=nums.length;
    int maxSum=0;
    int currentWindowSum=0;
    int left=0;
    int right=0;
    while(right<n){
      currentWindowSum+=nums[right];
      right++;
      if(right-left+1==key){
        maxSum=Math.max(maxSum,currentWindowSum);
        currentWindowSum-=nums[left];
        left++;
      }
    }
    return maxSum;
  }
}
