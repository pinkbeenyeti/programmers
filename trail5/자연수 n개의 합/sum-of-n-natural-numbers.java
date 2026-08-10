import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long S = Long.parseLong(br.readLine());

        long l = 1, r = 2_000_000_000;
        long maxIndex = 0;

        while (l <= r) {
            long mid = (l + r) / 2;
            long sum = mid * (mid + 1) / 2;

            if (sum <= S) {
                l = mid + 1;
                maxIndex = Math.max(mid, maxIndex);
            }
            else {
                r = mid - 1;
            }
        }

        System.out.print(maxIndex);
    }
}