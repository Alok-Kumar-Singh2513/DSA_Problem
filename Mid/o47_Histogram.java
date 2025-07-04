public class o47_Histogram {
  // find the largest rectangle that can be formed in a histogram
  public static int largestRectangleArea(int[] heights) {
    int n = heights.length;
    if (n == 0)
      return 0;

    int maxArea = 0;
    int[] left = new int[n];
    int[] right = new int[n];

    // Fill left array
    for (int i = 0; i < n; i++) {
      left[i] = i;
      while (left[i] > 0 && heights[left[i] - 1] >= heights[i]) {
        left[i]--;
      }
    }

    // Fill right array
    for (int i = n - 1; i >= 0; i--) {
      right[i] = i;
      while (right[i] < n - 1 && heights[right[i] + 1] >= heights[i]) {
        right[i]++;
      }
    }

    // Calculate max area
    for (int i = 0; i < n; i++) {
      int width = right[i] - left[i] + 1;
      maxArea = Math.max(maxArea, heights[i] * width);
    }

    return maxArea;
  }

  public static void main(String[] args) {
    int[] heights = { 2, 1, 5, 6, 2, 3 };
    System.out.println("Largest rectangle area in histogram: " + largestRectangleArea(heights));

  }
}
