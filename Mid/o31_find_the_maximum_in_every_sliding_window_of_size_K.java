import java.util.*;

public class o31_find_the_maximum_in_every_sliding_window_of_size_K {
  public static int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k <= 0) {
        return new int[0];
    }

    int n = nums.length;
    int[] result = new int[n - k + 1];
    Deque<Integer,Integer> deque = new LinkedList<>(); 

    for (int i = 0; i < n; i++) {
        // Remove elements not in the current window
        if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
            deque.pollFirst();
        }

        // Remove elements smaller than the current element from the back of the deque
        while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
            deque.pollLast();
        }

        // Add the current element's index to the deque
        deque.offerLast(i);

        // The front of the deque is the maximum for the current window
        if (i >= k - 1) {
            result[i - k + 1] = nums[deque.peekFirst()];
        }
    }

    return result;
  }
}
