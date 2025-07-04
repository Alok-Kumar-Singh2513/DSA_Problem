public class o18_Max_Xor_Of_Two_number_In_Array {
  public static int findMaximumXOR(int[] nums) {
    int maxXor = 0;
    int n=nums.length;
    
    for(int i=0;i<n;i++){
      for(int j=i+1;j<n;j++){
        int xor = nums[i] ^ nums[j];
        maxXor = Math.max(maxXor, xor);
      }
    }
    
    return maxXor;
  }
  public static void main(String[] args) {
    int[] nums = {3, 10, 5, 25, 2, 8};
    System.out.println("Maximum XOR of two numbers in the array: " + findMaximumXOR(nums));
    
  }
}
