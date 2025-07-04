public class o41_Kadane_algorithm {
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
}
