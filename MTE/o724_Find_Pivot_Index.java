package MTE;

public class o724_Find_Pivot_Index {
  public static int pivotIndex(int[] nums) {
    int totalSum=0;
    for(int i=0;i<nums.length;i++){
        totalSum+=nums[i];
    }
    int left=0;
    for(int i=0;i<nums.length;i++){
        if(left==totalSum-left-nums[i]){
            return i;
        }
        left+=nums[i];
    }
    return -1;
}
}
