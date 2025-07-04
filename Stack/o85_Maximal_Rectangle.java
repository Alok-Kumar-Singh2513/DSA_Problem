package Stack;

import java.util.Stack;

public class o85_Maximal_Rectangle {
  public int maximalRectangle(char[][] matrix) {
    int row= matrix.length;
    if(row==0) return 0;
    int col= matrix[0].length;
    int[] height= new int[col];
    int maxArea=0;
    for(int i=0;i<row;i++){
      for(int j=0;j<col;j++){
        if(matrix[i][j]=='1'){
          height[j]++;
        }else{
          height[j]=0;
        }
      }
      maxArea= Math.max(maxArea, largestRectangleArea(height));
    }
    return maxArea;
       
  }
  public int largestRectangleArea(int[] heights) {
    Stack<Integer> stack = new Stack<>();
    int maxArea = 0;
    int index = 0;

    while (index < heights.length) {
        // If this bar is higher than the bar at stack top, push it to the stack
        if (stack.isEmpty() || heights[index] >= heights[stack.peek()]) {
            stack.push(index++);
        } else {
            // Pop the top
            int top = stack.pop();
            // Calculate the area with heights[top] as the smallest (or minimum height) bar 'h'
            int area = heights[top] * (stack.isEmpty() ? index : index - stack.peek() - 1);
            // Update max area, if needed
            maxArea = Math.max(maxArea, area);
        }
    }

    // Now pop the remaining bars from the stack and calculate area
    while (!stack.isEmpty()) {
        int top = stack.pop();
        int area = heights[top] * (stack.isEmpty() ? index : index - stack.peek() - 1);
        maxArea = Math.max(maxArea, area);
    }

    return maxArea;
  }
}
