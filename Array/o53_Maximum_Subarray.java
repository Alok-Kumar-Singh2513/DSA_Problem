public class o53_Maximum_Subarray {
  public static int maxSubArray(int[] arr) {
    long maxi = Long.MIN_VALUE;
    long sum = 0;
    int n = arr.length;

    for (int i = 0; i < n; i++) {
        sum += arr[i];

        if (sum > maxi) {
            maxi = sum;
        }
        if (sum < 0) {
            sum = 0;
        }
    }
  
    return (int) maxi;
  }
  public static void main(String[] args) {
    int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
    System.out.println(maxSubArray(arr)); 
  }
}
