// package Stack;

import java.util.*;

public class o503_Next_Greater_Element_II {
   public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1); 
        Stack<Integer> stk = new Stack<>();

        // Traverse the array twice to simulate circular behavior
        for (int i = 2 * n - 1; i >= 0; --i) {
            int idx = i % n;
            while (!stk.isEmpty() && stk.peek() <= nums[idx]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                ans[idx] = stk.peek();
            }
            stk.push(nums[idx]);
        }
        
        return ans;
    }
}
