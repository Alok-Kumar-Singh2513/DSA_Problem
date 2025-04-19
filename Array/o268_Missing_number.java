import java.util.HashMap;

public class o268_Missing_number {
  public int missingNumber(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, true);
        }

        for (int i = 0; i <= n; i++) {
            if (!map.containsKey(i)) {
                return i;
            }
        }

        return -1; 
    }
    public static void main(String[] args) {
      
        o268_Missing_number obj = new o268_Missing_number();
            int[] nums = { 3, 0, 1 };
            System.out.println(obj.missingNumber(nums)); 
    }
}
