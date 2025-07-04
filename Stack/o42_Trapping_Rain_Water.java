package Stack;

import java.util.Stack;

public class o42_Trapping_Rain_Water {
  public static int trap(int[] height) {
    Stack<Integer> stack = new Stack<>();
    int waterTrapped = 0;
    int n = height.length;
    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
        int top = stack.pop();
        if (stack.isEmpty()) {
          break;
        }
        int distance = i - stack.peek() - 1;
        int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[top];
        waterTrapped += distance * boundedHeight;
      }
      stack.push(i);
    }
    return waterTrapped;
  }
}
