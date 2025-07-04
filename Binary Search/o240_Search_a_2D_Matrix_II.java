// package Binary Search;

public class o240_Search_a_2D_Matrix_II {
  public static boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int row=0;
        int col=m-1;
        while(row<n && col>=0){
            if(matrix[row][col]==target){
                return true;
            }
            else if(matrix[row][col]<target){
                row++;
            }
            else{
                col--;
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
