import java.util.*;

public class Leaders_in_an_Array_problem {
  public static int[] findLeaders(int[] arr) {
    int n = arr.length;
    int maxFromRight = arr[n - 1];
    List<Integer> leaders = new ArrayList<>();
    leaders.add(maxFromRight); 

    for (int i = n - 2; i >= 0; i--) {
        if (arr[i] > maxFromRight) {
            maxFromRight = arr[i];
            leaders.add(maxFromRight);
        }
    }

    Collections.reverse(leaders);
  
    return leaders.stream().mapToInt(i -> i).toArray();
  }

  // second method to find leaders in an array
  
  public static void main(String[] args) {
    int[] arr = {16, 17, 4, 3, 5, 2};
    int[] leaders = findLeaders(arr);
    System.out.println("Leaders in the array: " + Arrays.toString(leaders));
  }
}
