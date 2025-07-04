public class o50_equilibrium_index {
  public int equilibriumIndex(int[] arr) {
    int n = arr.length;
    int totalSum = 0;
    for (int i = 0; i < n; i++) {
      totalSum += arr[i];
    }
    int leftSum = 0;
    for (int i = 0; i < n; i++) {
      if (leftSum == totalSum - leftSum - arr[i]) {
        return i;
      }
      leftSum += arr[i];
    }
    return -1; 
  }
  public static void main(String[] args) {
    o50_equilibrium_index obj = new o50_equilibrium_index();
    int[] arr = {1, 2, 3, 4, 5, 6};
    int index = obj.equilibriumIndex(arr);
    System.out.println("Equilibrium index: " + index); 
  }
}
