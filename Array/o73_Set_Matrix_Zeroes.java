public class o73_Set_Matrix_Zeroes {
  public static void setZeroes(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    boolean firstRowZero = false;
    boolean firstColZero = false;

    // Check if the first row has any zeroes
    for (int j = 0; j < cols; j++) {
        if (matrix[0][j] == 0) {
            firstRowZero = true;
            break;
        }
    }

    // Check if the first column has any zeroes
    for (int i = 0; i < rows; i++) {
        if (matrix[i][0] == 0) {
            firstColZero = true;
            break;
        }
    }

    // Use the first row and column to mark zeroes
    for (int i = 1; i < rows; i++) {
        for (int j = 1; j < cols; j++) {
            if (matrix[i][j] == 0) {
                matrix[i][0] = 0;
                matrix[0][j] = 0;
            }
        }
    }

    // Set the marked cells to zero
    for (int i = 1; i < rows; i++) {
        for (int j = 1; j < cols; j++) {
            if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                matrix[i][j] = 0;
            }
        }
    }

    // Set the first row to zero if needed
    if (firstRowZero) {
        for (int j = 0; j < cols; j++) {
            matrix[0][j] = 0;
        }
    }

    // Set the first column to zero if needed
    if (firstColZero) {
        for (int i = 0; i < rows; i++) {
            matrix[i][0] = 0;
        }
    }
  }

  // by bruce
  // Time complexity: O(m*n)
  // Space complexity: O(1)
  public static void setZeroes2(int[][] matrix){
    int rows = matrix.length;
    int cols = matrix[0].length;
    for(int i=0;i<rows;i++){
      for(int j=0;j<cols;j++){
        if(matrix[i][j]==0){
         markRow(matrix,i,cols);
         markCol(matrix,j,rows);
        }
      }
    }
    for(int i=0;i<rows;i++){
      for(int j=0;j<cols;j++){
        if(matrix[i][j]==-1){
          matrix[i][j]=0;
        }
      }
    }
  }
  public static void markRow(int[][] matrix,int row,int cols){
    for(int j=0;j<cols;j++){
      if(matrix[row][j]!=0){
        matrix[row][j]=-1;
      }
    }
  }
  public static void markCol(int[][] matrix,int col,int rows){
    for(int i=0;i<rows;i++){
      if(matrix[i][col]!=0){
        matrix[i][col]=-1;
      }
    }
  }
  public static void main(String[] args) {
    int[][] matrix = {
        {1, 1, 1},
        {1, 0, 1},
        {1, 1, 1}
    };

    setZeroes(matrix);

    // Print the modified matrix
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[0].length; j++) {
            System.out.print(matrix[i][j] + " ");
        }
        System.out.println();
    }
  }
}
