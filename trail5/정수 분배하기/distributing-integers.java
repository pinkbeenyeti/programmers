import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        int l = 1, r = 100_000;
        int maxNum = 0;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (find(nums, M, mid)) {
                l = mid + 1;
                maxNum = Math.max(maxNum, mid);
            } else {
                r = mid - 1;
            }
        }

        System.out.print(maxNum);
    }

    private static boolean find(int[] nums, int M, int value) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            count += nums[i] / value;
        }

        if (count >= M) return true;
        else return false;
    }
}