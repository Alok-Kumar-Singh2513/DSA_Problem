public class Allocate_Minimum_Pages {
    public static int findPages(int[] arr, int k) {
        // code here
        int n = arr.length;
        if (k > n) return -1; // If there are more students than books, it's not possible to allocate
        int low = arr[0], high = 0;
        for (int pages : arr) {
            low = Math.max(low, pages); // The minimum possible pages is the max of single book
            high += pages; // The maximum possible pages is the sum of all books
        }
        int result = high;
        while (low <= high) {
            int mid = (low + high) / 2; 
            if (isPossible(arr, n, k, mid)) {
                result = Math.min(result, mid); // If it's possible to allocate with mid pages, update result
                high = mid - 1; // Try for a smaller maximum
            } else {
                low = mid + 1; // Increase the minimum limit
            }
        }
        return result; 
        
    }
    private static boolean isPossible(int[] arr, int n, int k, int mid) {
        int studentCount = 1; 
        int pagesAllocated = 0; 

        for (int i = 0; i < n; i++) {
            if (pagesAllocated + arr[i] > mid) { // If adding this book exceeds mid
                studentCount++; // Allocate to the next student
                pagesAllocated = arr[i]; // Start allocating this book to the new student
                if (studentCount > k) return false; // If we exceed the number of students, return false
            } else {
                pagesAllocated += arr[i]; // Otherwise, allocate this book to the current student
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        int k = 2;
        int result = findPages(arr, k);
        System.out.println("The minimum number of pages is: " + result); // Output: 113
    }
}
