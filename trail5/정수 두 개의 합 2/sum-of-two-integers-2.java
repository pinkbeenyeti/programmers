import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] nums = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);

        int l = 1, r = N;
        long answer = 0;

        while (l < r) {
            long sum = nums[l] + nums[r];

            if (sum > K) r--;
            else {
                answer += (r - l);
                l++;
            }
        }

        System.out.print(answer);
    }
}