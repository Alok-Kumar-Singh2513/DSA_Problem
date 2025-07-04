package Stack;

import java.util.Stack;

public class o907_Sum_of_Subarray_Minimums {
  public static int sumSubarrayMins(int[] arr) {
   Stack<Integer> stack = new Stack<>();
    int n = arr.length;
    int mod = 1000000007;
    long result = 0;
    long[] left = new long[n];
    long[] right = new long[n];

    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
        stack.pop();
      }
      left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
      stack.push(i);
    }

    stack.clear();

    for (int i = n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
        stack.pop();
      }
      right[i] = stack.isEmpty() ? n - i : stack.peek() - i;
      stack.push(i);
    }

    for (int i = 0; i < n; i++) {
      result += (arr[i] * left[i] * right[i]) % mod;
      result %= mod;
    }

    return (int) result;
  }

  // Second way
  public static int sumSubArrayMins2(int arr[]){
    int n=arr.length;
    int mod=1000000007;
    long ans=0;
    for(int i=0;i<n;i++){
      int min=arr[i];
      for(int j=i;j<n;j++){
        min=Math.min(min,arr[j]);
        ans=(ans+min)%mod;
      }
    }
    return (int)ans;
  }
  public static void main(String[] args) {
    // int[] arr = { 3, 1, 2, 4 };

                           
  }
}
