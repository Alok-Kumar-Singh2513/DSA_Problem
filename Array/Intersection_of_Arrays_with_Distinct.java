import java.util.*;

public class Intersection_of_Arrays_with_Distinct {
    public static int numberofElementsInIntersection(int a[], int b[]) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();

        // Add all elements of array a to setA
        for (int num : a) {
            setA.add(num);
        }

        // Check if elements of b are in setA
        for (int num : b) {
            if (setA.contains(num)) {
                intersection.add(num);  // Only distinct elements
            }
        }

        return intersection.size(); // Number of distinct common elements
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3, 4};
        int[] b = {2, 3, 3, 5};

        int count = numberofElementsInIntersection(a, b);
        System.out.println("Number of distinct elements in intersection: " + count); 
    }
}
