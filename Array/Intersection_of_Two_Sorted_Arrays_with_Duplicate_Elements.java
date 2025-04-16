import java.util.ArrayList;

public class Intersection_of_Two_Sorted_Arrays_with_Duplicate_Elements {
    public static ArrayList<Integer> intersection(int[] a, int[] b) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                // Avoid duplicates in result
                if (result.isEmpty() || result.get(result.size() - 1) != a[i]) {
                    result.add(a[i]);
                }
                i++;
                j++;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3, 4};
        int[] b = {2, 2, 3, 5};

        ArrayList<Integer> res = intersection(a, b);
        System.out.println("Intersection: " + res);  
    }
}
