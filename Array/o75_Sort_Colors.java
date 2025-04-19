import java.util.HashMap;

public class o75_Sort_Colors {
  // First method
  public static void sortColors1(int[] a) {
    int n = a.length;
    int[] count = new int[3];
    for (int i = 0; i < n; i++) {
        count[a[i]]++;
    }
    int index = 0;
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < count[i]; j++) {
            a[index++] = i;
        }
    }
  }

  // second method
  // Dutch National Flag Problem
  public static void sortColors(int[] a) {
    int L=0;
    int M=0;
    int H=a.length-1;
    while (M<=H){
        int x=a[M];
        if (x==0){
            int temp=a[L];
            a[L]=a[M];
            a[M]=temp;
            L++;
            M++;

        } else if (x==1) {
            M++;
        }
        else {
            int temp=a[M];
            a[M]=a[H];
            a[H]=temp;
            H--;
        }
    }
  }
    // third method By HashMap
    public static void SortColors(int[] a) {
   
      HashMap<Integer, Integer> map = new HashMap<>();
      for (int num : a) {
          map.put(num, map.getOrDefault(num, 0) + 1);
      }

      int index = 0;
      for (int i = 0; i < 3; i++) {
          int count = map.getOrDefault(i, 0);
          for (int j = 0; j < count; j++) {
              a[index++] = i;
          }
      }
  }
  public static void main(String[] args) {
    int[] a = { 2, 0, 2, 1, 1, 0 };
    sortColors(a);
    for (int num : a) {
        System.out.print(num + " ");
    }
    System.out.println();
    
    int[] b = { 2, 0, 2, 1, 1, 0 };
    sortColors1(b);
    for (int num : b) {
        System.out.print(num + " ");
    }
    System.out.println();
    
    int[] c = { 2, 0, 2, 1, 1, 0 };
    SortColors(c);
    for (int num : c) {
        System.out.print(num + " ");
    }
  

}
}
