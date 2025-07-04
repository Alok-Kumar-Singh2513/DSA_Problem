public class Row_with_max_1s {
  public static int lowerBound(int[] arr, int n, int target) {
    int left = 0;
    int right = n - 1;
    int answer = n;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] >= target) {
            answer = mid;
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    return answer;
}

public static int rowWithMax1s(int arr[][]) {
    int n = arr.length;
    int m = arr[0].length;
    int maxOne = 0;
    int index = -1;

    for (int i = 0; i < n; i++) {
        int pos = lowerBound(arr[i], m, 1);
        int count_one = m - pos;
        if (count_one > maxOne) {
            maxOne = count_one;
            index = i;
        }
    }
    return index;
}

}
