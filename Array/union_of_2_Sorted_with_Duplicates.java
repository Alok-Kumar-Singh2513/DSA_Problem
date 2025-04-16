import java.util.*;

public class union_of_2_Sorted_with_Duplicates {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        Set<Integer> set = new TreeSet<>(); 

        for (int num : a) {
            set.add(num);
        }
        for (int num : b) {
            set.add(num);
        }

        return new ArrayList<>(set); 
    }
    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3, 4};
        int[] b = {2, 3, 5, 6};

        ArrayList<Integer> result = findUnion(a, b);
        System.out.println(result);  
    }
}
