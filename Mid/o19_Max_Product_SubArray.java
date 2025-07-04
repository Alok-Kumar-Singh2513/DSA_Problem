public class o19_Max_Product_SubArray {
  public static int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0)
      return 0;

    int prefixProduct = 1;
    int suffixProduct = 1;
    int maxProduct = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      prefixProduct *= nums[i];
      suffixProduct *= nums[nums.length - 1 - i];
      maxProduct = Math.max(maxProduct, Math.max(prefixProduct, suffixProduct));
      if (prefixProduct == 0)
        prefixProduct = 1; // reset if product is zero
      if (suffixProduct == 0)
        suffixProduct = 1; // reset if product is zero
    }
    return maxProduct;
  }
}
