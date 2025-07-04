public class o1482_Minimum_Number_of_Days_to_Make_m_Bouquets {
   public static int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k) {
            return -1; // Not enough flowers to make m bouquets
        }

        int left = Integer.MIN_VALUE, right = Integer.MAX_VALUE;
        left=findMin(bloomDay);
        right=findMax(bloomDay);
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canMakeBouquets(bloomDay, m, k, mid)) {
                result = mid; // Found a valid number of days
                right = mid - 1; // Try to find a smaller number of days
            } else {
                left = mid + 1; // Increase the number of days
            }
        }
        return result; // Return the minimum number of days found
                      
        
    }
    private static boolean canMakeBouquets(int[] bloomDay, int m, int k, int days) {
        int bouquets = 0;
        int flowers = 0;

        for (int bloom : bloomDay) {
            if (bloom <= days) {
                flowers++; // Count the number of flowers that can bloom in 'days'
                if (flowers == k) {
                    bouquets++; // Form a bouquet
                    flowers = 0; // Reset for the next bouquet
                }
            } else {
                flowers = 0; // Reset if the flower cannot bloom in 'days'
            }
        }

        return bouquets >= m; // Check if we can make at least m bouquets
    }
    private static int findMin(int[] bloomDay) {
        int min = Integer.MAX_VALUE;
        for (int bloom : bloomDay) {
            if (bloom < min) {
                min = bloom;
            }
        }
        return min;
    }
    private static int findMax(int[] bloomDay) {
        int max = Integer.MIN_VALUE;
        for (int bloom : bloomDay) {
            if (bloom > max) {
                max = bloom;
            }
        }
        return max;
    }
   
    public static void main(String[] args) {
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3;
        int k = 1;
        int result = minDays(bloomDay, m, k);
        System.out.println("Minimum number of days to make " + m + " bouquets: " + result); // Output: 3
    }
}
