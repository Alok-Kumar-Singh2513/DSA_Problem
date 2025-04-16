public class o26_Remove_Duplicates_from_Sorted_Array {
  public static int removeDuplicates(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int uniqueCount = 1; 
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[uniqueCount - 1]) {
        nums[uniqueCount] = nums[i];
        uniqueCount++;
      }
    }
    return uniqueCount;
  }
  public static void main(String[] args) {
    
    int arr[] = { 1, 1, 2, 2, 3, 4, 5 };
    
    int uniqueCount = removeDuplicates(arr);
    System.out.println("The number of unique elements is: " + uniqueCount);
    System.out.print("The array after removing duplicates: ");
    for (int i = 0; i < uniqueCount; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();

  }
}
