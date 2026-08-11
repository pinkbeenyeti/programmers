import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[][] lines = new long[M][2];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            lines[i][0] = Math.min(a, b);
            lines[i][1] = Math.max(a, b);
        }

        Arrays.sort(lines, (a, b) -> {
            if (a[0] == b[0]) return Long.compare(a[1], b[1]);
            return Long.compare(a[0], b[0]);
        });

        long l = 1, r = Long.MAX_VALUE - 2;
        long answer = 0;

        while (l <= r) {
            long mid = (l + r) / 2;

            if (find(lines, N, mid)) {
                l = mid + 1;
                answer = Math.max(answer, mid);
            } else {
                r = mid - 1;
            }
        }

        System.out.print(answer);
    }

    private static boolean find(long[][] lines, int N, long diff) {
        long prev = lines[0][0];
        int count = 1;

        for (long[] line : lines) {
            while (true) {
                long temp = Math.max(line[0], prev + diff);

                if (temp > line[1]) break;
                else {
                    prev = temp;
                    count++;
                }
            }
        }

        if (count >= N) return true;
        else return false;
    }
}