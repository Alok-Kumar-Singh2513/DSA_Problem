import java.lang.reflect.Array;
import java.util.*;

public class o25_FInd_next_greater_element  {
  public static int [] nextGreaterElement(int nums[]){
    Stack<Integer> stack = new Stack<>();
    int n = nums.length;
    int [] result = new int[n];
    // Arrays.fill(result, -1); // Initialize result with -1
    for(int i=0;i<n;i++){
      while(!stack.isEmpty() && stack.peek() <= nums[i]){
        stack.pop(); // Pop elements from the stack until we find a greater element
      }
     
      if(stack.isEmpty()){
        result[i] = -1; // If stack is empty, no greater element found
      }else{
        result[i] = stack.peek(); // The top of the stack is the next greater element
      }
      stack.push(nums[i]); // Push the current element onto the stack
    }
    return result; // Return the result array containing next greater elements

  }
}
