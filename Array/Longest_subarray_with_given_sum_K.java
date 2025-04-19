import java.util.HashMap;

public class Longest_subarray_with_given_sum_K {
  public static int longestSubarray(int[] arr, int k) {
    int maxLength = 0;
    int sum = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, -1); // To handle the case when the subarray starts from index 0

    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];

      if (map.containsKey(sum - k)) {
        maxLength = Math.max(maxLength, i - map.get(sum - k));
      }

      if (!map.containsKey(sum)) {
        map.put(sum, i);
      }
    }

    return maxLength;
  }
  // second method
  public static int longestSubarray2(int[] arr, int k) {      
   int left=0;
   int right=0;
    int sum=0;
    int maxLength=0;
    while (right<arr.length){
        sum+=arr[right];
        while (sum>k){
            sum-=arr[left];
            left++;
        }
        if (sum==k){
            maxLength=Math.max(maxLength,right-left+1);
        }
        right++;
    }
    return maxLength;
  }
  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5 };
    int k = 5;
    System.out.println(longestSubarray(arr, k)); // Output: 2 (subarray [2, 3])
    System.out.println(longestSubarray2(arr, k)); // Output: 2 (subarray [2, 3])
  }
}
