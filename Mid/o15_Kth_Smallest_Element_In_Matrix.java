import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class o15_Kth_Smallest_Element_In_Matrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        List<Integer> list = new ArrayList<>();

        // Convert 2D matrix to 1D list
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                list.add(matrix[i][j]);
            }
        }

        Collections.sort(list);
        return list.get(k - 1);
    }

    // second method using binary search
    public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];

        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = countLessEqual(matrix, mid);
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    private int countLessEqual(int[][] matrix, int mid) {
        int count = 0;
        int n = matrix.length;
        int row = n - 1, col = 0;

        while (row >= 0 && col < n) {
            if (matrix[row][col] <= mid) {
                count += row + 1; // All elements in this column are less than or equal to mid
                col++;
            } else {
                row--;
            }
        }
        return count;
    }
    
}
