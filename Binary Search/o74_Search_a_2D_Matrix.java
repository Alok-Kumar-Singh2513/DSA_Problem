
public class o74_Search_a_2D_Matrix {
  public static boolean searchMatrix(int[][] matrix, int target) {
    int n = matrix.length;
    int m = matrix[0].length;
    int left = 0;
    int right = n * m - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      int row = mid / m;
      int col = mid % m;

      if (matrix[row][col] == target) {
        return true;
      } else if (matrix[row][col] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    int[][] matrix = {
        { 1, 3, 5, 7 },
        { 10, 11, 16, 20 },
        { 23, 30, 34, 50 }
    };
    int target = 3;
    boolean result = searchMatrix(matrix, target);
    System.out.println("Is the target " + target + " present in the matrix? " + result);
    // Output: true

  }
}
