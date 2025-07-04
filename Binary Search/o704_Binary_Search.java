
public class o704_Binary_Search {
  public static int search(int[] nums, int target) {
    int lefft = 0;
    int right = nums.length - 1;
    while (lefft <= right) {
      int mid = lefft + (right - lefft) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        lefft = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;

  }

  public static void main(String[] args) {

    int[] nums = {-1, 0, 3, 5, 9, 12};
    int target = 9;
    int result = search(nums, target);
    System.out.println("The index of the target " + target + " is: " + result);
    // Output: 4
  }
}
