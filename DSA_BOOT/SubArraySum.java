package DSA_BOOT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SubArraySum {
    static long solve(int arr[], long k) {
        Map<Long, Integer> mp = new HashMap<>();
        long count = 0;
        long sum = 0;
        mp.put(0L, 1);

        for (int num : arr) {
            sum += num;
            if (mp.containsKey(sum - k)) {
                count += mp.get(sum - k);
            }
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        int arr[] = new int[n];
        
        st = new StringTokenizer(br.readLine()); 

        for (int i = 0; i < n; i++) {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long result = solve(arr, k);
        pw.println(result);
        pw.flush();
        pw.close();
        br.close();
    }
}