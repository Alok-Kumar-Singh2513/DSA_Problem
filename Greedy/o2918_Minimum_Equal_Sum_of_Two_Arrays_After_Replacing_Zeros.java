package Greedy;

public class o2918_Minimum_Equal_Sum_of_Two_Arrays_After_Replacing_Zeros {
   public static long minSum(int[] nums1, int[] nums2) {
      long sum1=0;
      long sum2=0;
      long zero1=0;
      long zero2=0;
      for(int sum:nums1){
         if(sum==0){
            sum1+=1;
            zero1+=1;
         }
         sum1+=sum;
      }
         for(int sum:nums2){
         if(sum==0){
            sum2+=1;
            zero2+=1;
         }
         sum2+=sum;
      }

      if(sum1 < sum2 &&  zero1==0){
         return -1;
      }
      if(sum2 < sum1 && zero2==0){
         return -1;
      }
      return Math.max(sum1,sum2);
    }
}
