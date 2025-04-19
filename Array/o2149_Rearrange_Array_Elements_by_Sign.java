public class o2149_Rearrange_Array_Elements_by_Sign {
  public static int[] rearrangeArray(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    int posIndex = 0; 
    int negIndex = 1; 

    for (int num : nums) {
        if (num > 0) {
            result[posIndex] = num;
            posIndex += 2; // Move to the next even index
        } else {
            result[negIndex] = num;
            negIndex += 2; // Move to the next odd index
        }
    }

    return result;
  }

  // Second method
  public static int[] rearrangeArray2(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    int postiveArray[]=new int[n/2];
    int negativeArray[]=new int[n/2];
    int posIndex = 0;
    int negIndex = 0;
    for (int num : nums) {
        if (num > 0) {
            postiveArray[posIndex] = num;
            posIndex++;
        } else {
            negativeArray[negIndex] = num;
            negIndex++;
        }
    }
    posIndex = 0;
    negIndex = 0;
    for (int i = 0; i < n; i++) {
        if (i % 2 == 0) {
            result[i] = postiveArray[posIndex];
            posIndex++;
        } else {
            result[i] = negativeArray[negIndex];
            negIndex++;
        }
    }
   
    while (posIndex < postiveArray.length) {
        result[posIndex] = postiveArray[posIndex];
        posIndex++;
    }
    while (negIndex < negativeArray.length) {
        result[negIndex] = negativeArray[negIndex];
        negIndex++;
    }


    return result;
  }
  public static void main(String[] args) {
    int[] nums = {3, 1, -2, -5, 2, -4};
    int[] rearranged = rearrangeArray(nums);
    for (int num : rearranged) {
        System.out.print(num + " ");
    }
  }
  
}
