import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        int[] A = new int[N];
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }        

        Arrays.sort(A);
        Arrays.sort(B);

        long low = (long) A[0] + B[0];
        long high = (long) A[N - 1] + B[M - 1];
        long answer = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (countPairs(A, B, mid) >= K) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.print(answer);
    }

    private static long countPairs(int[] A, int[] B, long targetSum) {
        long count = 0;
        int j = B.length - 1;

        for (int i = 0; i < A.length; i++) {
            while (j >= 0 && (long) A[i] + B[j] > targetSum) {
                j--;
            }

            if (j < 0) break; 

            count += (j + 1);
        }

        return count;
    }
}