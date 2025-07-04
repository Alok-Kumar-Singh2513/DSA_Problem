package Greedy;

public class o135_Candy {
    public static int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0)
            return 0;
        int[] candiesLeft = new int[n];
        // Initialize each child with 1 candy
        for (int i = 0; i < n; i++) {
            candiesLeft[i] = 1;
        }
        // First pass: left to right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candiesLeft[i] = candiesLeft[i - 1] + 1;
            }
        }
        int[] candiesRight = new int[n];
        // Initialize each child with 1 candy
        for (int i = 0; i < n; i++) {
            candiesRight[i] = 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candiesRight[i] = candiesRight[i + 1] + 1;
            }
        }
        // Calculate the total candies needed
        int totalCandies = 0;
        for (int i = 0; i < n; i++) {
            totalCandies += Math.max(candiesLeft[i], candiesRight[i]);
        }
        return totalCandies;
    }

    public static void main(String[] args) {
        int[] ratings = { 1, 0, 2 };
        int result = candy(ratings);
        System.out.println("Minimum candies required: " + result);
    }
}
