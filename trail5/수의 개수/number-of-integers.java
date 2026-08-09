import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] nums = new int[N + 1];
        for (int i = 1; i <= N; i++) nums[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(br.readLine());

            int l = lowerBound(nums, N, target);
            int r = upperBound(nums, N, target);

            if (nums[l] != target || nums[r] != target) answer.append(0);
            else answer.append(r - l + 1);

            answer.append("\n");
        }

        System.out.print(answer);

    }

    private static int lowerBound(int[] nums, int n, int target) {
        int l = 0, r = n;
        int index = n;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (nums[mid] >= target) {
                r = mid - 1;
                index = Math.min(index, mid);
            }
            else {
                l = mid + 1;
            }
        }

        return index;
    }

    private static int upperBound(int[] nums, int n, int target) {
        int l = 0, r = n;
        int index = 0;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (nums[mid] <= target) {
                l = mid + 1;
                index = Math.max(index, mid);
            }
            else {
                r = mid - 1;
            }
        }

        return index;
    }
}