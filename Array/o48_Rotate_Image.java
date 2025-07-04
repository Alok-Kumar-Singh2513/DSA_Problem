public class o48_Rotate_Image {
  public void rotate(int[][] matrix) {
    int m=matrix[0].length;
    int n=m; 
//       Transpose
    for (int i = 0; i < n; i++) {
         for (int j = i + 1; j < n; j++) {
             // Swap elements matrix[i][j] and matrix[j][i]
             int temp = matrix[i][j];
             matrix[i][j] = matrix[j][i];
             matrix[j][i] = temp;
         }
     }

     for (int i = 0; i < n; i++) {
         int start = 0;
         int end = matrix[i].length - 1;

         while (start < end) {
             // Swap elements at start and end positions
             int temp = matrix[i][start];
             matrix[i][start] = matrix[i][end];
             matrix[i][end] = temp;

             start++;
             end--;
         }
     }
  }
}
