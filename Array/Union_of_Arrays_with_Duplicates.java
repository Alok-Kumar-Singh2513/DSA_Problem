import java.util.HashSet;
import java.util.Set;

public class Union_of_Arrays_with_Duplicates {
 public static int findUnion(int[] a, int[] b) {
        Set<Integer> unionSet = new HashSet<>();
        for (int num : a) {
            unionSet.add(num);
        }
        for (int num : b) {
            unionSet.add(num);
        }
        return unionSet.size();
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3};
        int[] b = {2, 3, 4, 5};

        int count = findUnion(a, b);
        System.out.println("Number of elements in union: " + count);  
    }
}
