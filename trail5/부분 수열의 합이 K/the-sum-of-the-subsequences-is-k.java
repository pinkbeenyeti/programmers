import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0;

        int[] nums = new int[N + 1];
        int[] sums = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            sums[i] = nums[i] + sums[i - 1];
        }

        for (int step = 1; step <= N; step++) {
            for (int start = 1; start <= (N - step + 1); start++) {
                if ((sums[start + step - 1] - sums[start - 1]) == K) {
                    count++;
                }
            }
        }

        System.out.print(count);
    }
}