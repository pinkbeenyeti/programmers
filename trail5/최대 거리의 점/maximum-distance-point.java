import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] nums = new long[N];
        for (int i = 0; i < N; i++) nums[i] = Long.parseLong(br.readLine());

        int l = 1, r = 200_000;
        int answer = 0;

        Arrays.sort(nums);

        while (l <= r) {
            int mid = (l + r) / 2;

            if (find(nums, M, mid)) {
                l = mid + 1;
                answer = Math.max(mid, answer);
            } else {
                r = mid - 1;
            }
        }

        System.out.print(answer);
    }

    private static boolean find(long[] nums, int M, int value) {
        long prev = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - prev >= value) {
                prev = nums[i];
                count++;
            }
        }

        if (count >= M) return true;
        else return false;
    }
}