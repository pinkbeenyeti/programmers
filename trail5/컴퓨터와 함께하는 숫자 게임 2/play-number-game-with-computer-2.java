import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (long i = A; i <= B; i++) {
            int result = find(N, i);
            min = Math.min(min, result);
            max = Math.max(max, result);
        }

        System.out.print(min + " " + max);
    }

    private static int find(long n, long target) {
        long l = 1, r = n;
        int count = 0;

        while (l <= r) {
            long mid = (l + r) / 2;
            count++;

            if (target > mid) 
                l = mid + 1;
            else if (target == mid) 
                break;
            else 
                r = mid - 1;
        }

        return count;
    }
}