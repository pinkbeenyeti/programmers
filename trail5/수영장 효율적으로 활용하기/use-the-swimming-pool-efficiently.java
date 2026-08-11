import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        long[] people = new long[N];

        long l = 1, r = 2_000_000_000;
        long answer = Long.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            people[i] = Long.parseLong(st.nextToken());
            l = Math.max(l, people[i]);
        }

        while (l <= r) {
            long mid = (l + r) / 2;

            if (find(people, M, mid)) {
                r = mid - 1;
                answer = Math.min(answer, mid);
            } else {
                l = mid + 1;
            }
        }

        System.out.print(answer);

    }

    private static boolean find(long[] people, int M, long value) {
        long sum = 0;
        int count = 0;

        for (int i = 0; i < people.length; i++) {
            sum += people[i];

            if (sum > value) {
                count++;
                sum = people[i];
            }
        }

        if (sum <= value) {
            count++;
        }

        if (count > M) return false;
        else return true;
    }
}