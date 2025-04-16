import java.util.PriorityQueue;

public class Minimum_Cost_of_ropes {
  public static int minCost(int arr[], int n) {
    if (n <= 1) {
      return 0;
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      pq.add(arr[i]);
    }
    int totalCost = 0;
    while (pq.size() > 1) {
      int first = pq.poll();
      int second = pq.poll();
      int cost = first + second;
      totalCost += cost;
      pq.add(cost);
    }
    return totalCost;
  }
  public static void main(String[] args) {
    int arr[] = { 4, 3, 2, 6 };
    int n = arr.length;
    int minCost = minCost(arr, n);
    System.out.println("The minimum cost of ropes is: " + minCost);
  }
}