package Greedy;

public class o1578_Minimum_Time_to_Make_Rope_Colorful {
  public static int minCost(String colors, int[] neededTime) {
        int n=colors.length();
        int time=0;
        int prevMax=0;
        for(int i=0;i<n;i++){
      // This for the odd colors
            if(i> 0 && colors.charAt(i)!=colors.charAt(i-1)){
              prevMax=0;
            }
            // This for the even colors
            int current=neededTime[i];
            time+=Math.min(prevMax,current);
            prevMax=Math.max(prevMax,current);
        }
        return time;
  }
}
