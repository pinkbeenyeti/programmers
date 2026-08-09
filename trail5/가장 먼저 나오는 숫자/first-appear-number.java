import java.util.*;
import java.io.*;

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

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            answer.append(lowerBound(nums, N, target)).append("\n");
        }

        System.out.print(answer);
    }

    private static int lowerBound(int[] nums, int n, int target) {
        int l = 1, r = n;
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

        if (nums[index] != target) return -1;
        else return index;
    }
}