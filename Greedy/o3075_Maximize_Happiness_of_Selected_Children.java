package Greedy;
import java.util.*;

public class o3075_Maximize_Happiness_of_Selected_Children {
   public static long maximumHappinessSum(int[] happiness, int k) {
       int count=0;
       long result=0;
      //  Array.sort(happiness);
      Arrays.sort(happiness);

       for(int i=happiness.length-1;i>=0;i--){
        if(count==k){
            break;
        }else{
          result+=Math.max(happiness[i]-count,0);
          count++;
        }
       }
       return result;
    }
    public static void main(String[] args) {
        int[] happiness = {1, 2, 3, 4, 5};
        int k = 3;
        long result = maximumHappinessSum(happiness, k);
        System.out.println("Maximum happiness sum of selected children: " + result); // Output: 12
    }
}
