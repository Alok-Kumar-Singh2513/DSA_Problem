package DSA_BOOT;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class StaticRangeSumQueries {

    public static long[] calculatePrefixSums(long[] arr) {
        int n = arr.length;
        long[] prefixSum = new long[n + 1];
        prefixSum[0] = 0;

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }
        return prefixSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken()); 

        long[] arr = new long[n]; 
        st = new StringTokenizer(br.readLine()); 

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        long[] precomputedSums = calculatePrefixSums(arr);

    
        for (int i = 0; i < q; i++) { 
            st = new StringTokenizer(br.readLine()); 
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            pw.println(precomputedSums[b] - precomputedSums[a - 1]);
        }

        pw.flush();
        pw.close();
        br.close();
    }
}