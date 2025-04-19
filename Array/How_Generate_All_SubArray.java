import java.util.ArrayList;

public class How_Generate_All_SubArray {
    public static ArrayList<ArrayList<Integer>> generateSubArray(int[] arr) {
        ArrayList<ArrayList<Integer>> subArrays = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> current = new ArrayList<>();
            for (int j = i; j < arr.length; j++) {
                current.add(arr[j]);
                subArrays.add(new ArrayList<>(current)); 
            }
        }

        return subArrays;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        ArrayList<ArrayList<Integer>> result = generateSubArray(arr);

        for (ArrayList<Integer> subArray : result) {
            System.out.println(subArray);
        }
    }
}
