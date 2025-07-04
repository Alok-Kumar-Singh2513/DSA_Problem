
public class o540_Single_Element_in_a_Sorted_Array {
  public int singleNonDuplicate(int[] nums) {
    int result = 0;
    for (int num : nums) {
      result ^= num; 
    }
    return result; 
  }
}
