import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        long l = 1, r = Long.MAX_VALUE - 2;
        long answer = 0;

        while (l <= r) {
            long mid = (l + r) / 2;
            long result = find(mid, N);

            if (result == 1) r = mid -1;
            else if (result == -1) l = mid + 1;
            else {
                answer = mid;
                break;
            }
        }

        System.out.print(answer);
    }

    private static int find(long value, long N) {
        long index = value - (value / 3) - (value / 5) + (value / 15);

        if (index > N) return 1;
        else if (index < N) return -1;
        else {
            if (value % 3 == 0 || value % 5 == 0) return 1;
            else return 0;
        }
    }
}