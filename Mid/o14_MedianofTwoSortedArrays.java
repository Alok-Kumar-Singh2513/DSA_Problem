public class o14_MedianofTwoSortedArrays {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int n = nums1.length + nums2.length;
    int[] merged = new int[n];
    int i = 0, j = 0, k = 0;
    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] < nums2[j]) {
        merged[k++] = nums1[i++];
      } else {
        merged[k++] = nums2[j++];

      }
    }
    while (i < nums1.length) {
      merged[k++] = nums1[i++];
    }
    while (j < nums2.length) {
      merged[k++] = nums2[j++];
    }
    if (n % 2 == 0) {
      return (merged[n / 2 - 1] + merged[n / 2]) / 2.0;
    } else {
      return merged[n / 2];
    }

  }
}
