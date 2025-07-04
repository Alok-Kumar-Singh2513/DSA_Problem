public class o1_Prefix_Sum {
  public static int[] calculatePrefixSum(int[] arr) {
    int n = arr.length;
    int[] prefix = new int[n];
    
    // Initialize the first element
    prefix[0] = arr[0];
    
    // Fill the prefix sum array
    for (int i = 1; i < n; i++) {
        prefix[i] = prefix[i - 1] + arr[i];
    }
    
    return prefix;
}

// Function to get sum of elements between indices l and r using prefix sum
public static int getRangeSum(int[] prefix, int l, int r) {
    if (l == 0) {
        return prefix[r];
    } else {
        return prefix[r] - prefix[l - 1];
    }
}

public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    
    // Calculate the prefix sum array
    int[] prefix = calculatePrefixSum(arr);
    
    // Display the prefix sum array
    System.out.println("Prefix Sum Array: ");
    for (int i : prefix) {
        System.out.print(i + " ");
    }
    
    System.out.println();

    // Example queries
    System.out.println("Sum of elements from index 1 to 3: " + getRangeSum(prefix, 1, 3)); // 2 + 3 + 4 = 9
    System.out.println("Sum of elements from index 0 to 4: " + getRangeSum(prefix, 0, 4)); // 1 + 2 + 3 + 4 + 5 = 15
}
}
