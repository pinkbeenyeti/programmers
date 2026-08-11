import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        long l = 1, r = Long.MAX_VALUE - 2;
        long answer = Long.MAX_VALUE;

        while (l <= r) {
            long mid = (l + r) / 2;
            long order = find(N, mid);
            
            if (order < K)
                l = mid + 1;
            else {
                r = mid - 1;
                answer = Math.min(answer, mid);
            }
        }

        System.out.print(answer);
    }

    private static long find(int N, long value) {
        long result = 0;

        for (int i = 1; i <= N; i++) {
            result += Math.min(N, value / i);
        }

        return result;
    }
}