package DSA_BOOT;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class D_CountInterval {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken()); 

        long[] A = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken()); 
        }

        Map<Long, Integer> prefixSumCounts = new HashMap<>();
        prefixSumCounts.put(0L, 1); // Initialize with prefix sum 0 occurring once
        
        long currentSum = 0;
        long count = 0; // The total count of valid subarrays

        for (int i = 0; i < N; i++) {
            currentSum += A[i];
            if (prefixSumCounts.containsKey(currentSum - K)) {
                count += prefixSumCounts.get(currentSum - K);
            }
            prefixSumCounts.put(currentSum, prefixSumCounts.getOrDefault(currentSum, 0) + 1);
        }

        pw.println(count);

        pw.flush();
        pw.close();
        br.close();
    }

}
