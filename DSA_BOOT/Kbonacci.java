
import java.io.*;

public class Kbonacci {
    public static int getKBonacci(int N, int K) {
        if (K > N) return 1;
        int MOD = 1000000000;
        int[] A = new int[N + 1];
        long slid = 0;
        for (int i = 0; i <= N; i++) {
            if (i < K) {
                A[i] = 1;
                slid += A[i];
            } else {
                A[i] = (int)(slid % MOD);
                slid += A[i];
                slid -= A[i - K];
            }
        }
        return A[N];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        System.out.println(getKBonacci(N, K));
    }
}
