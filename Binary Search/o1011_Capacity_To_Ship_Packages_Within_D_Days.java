public class o1011_Capacity_To_Ship_Packages_Within_D_Days {
   public static int shipWithinDays(int[] w, int days) {
        int max = 0, sum = 0;
        for (int weight : w) {
            max = Math.max(max, weight);
            sum += weight;
        }

        int low = max, high = sum;
        while (low < high) {
            int mid = (low + high) / 2;
            if (canShip(w, days, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private static boolean canShip(int[] w, int days, int capacity) {
        int dayCount = 1;
        int currentWeight = 0;

        for (int weight : w) {
            if (currentWeight + weight > capacity) {
                dayCount++;
                currentWeight = 0;
            }
            currentWeight += weight;
        }

        return dayCount <= days;
    }
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        int result = shipWithinDays(weights, days);
        System.out.println("Minimum capacity to ship packages within " + days + " days: " + result); // Output: 15
    }
}
