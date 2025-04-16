public class o283_Move_Zeroes {
  // method 1
  public static void moveZeroes(int[] nums){
    int n=nums.length;
    System.out.println(n);
    int temp[]=new int[n];
    int i=0;

    for(int num:nums){
      if(num!=0){
        temp[i++]=num;
      }
    }


  }
  
  // method 2
  public static void swap(int arr[], int start, int end) {
    int temp = arr[start];
    arr[start] = arr[end];
    arr[end] = temp;
}

public static void moveZeroes2(int[] arr) {
    int n = arr.length;
    int j = 0; 
   
    for (int i = 0; i < n; i++) {
        if (arr[i] != 0) {
            swap(arr, i, j);
            j++; 
        }
    }

}
  public static void main(String[] args) {
    
  }
}
