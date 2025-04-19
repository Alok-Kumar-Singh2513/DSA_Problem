import java.util.Arrays;

public class o169_Majority_Element {

  // second method
  // Time complexity: O(nlogn)
  // Space complexity: O(1)
  public static int majorityElement2(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length / 2];
  }
  // first method
  // Time complexity: O(n)
  public static int majorityElement(int[] nums) {
    int count=0;
    int candidate=0;
    for(int i=0;i<nums.length;i++){
      if(count==0){
        candidate=nums[i];
        count=1;
      }else if(nums[i]==candidate){
        count++;
      }else{  
        count--;
      }
    } 
    return candidate;
  }
  public static void main(String[] args) {
    int[] nums = {2,2,1,1,1,2,2};
    System.out.println(majorityElement(nums)); 
  }
}
