import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int l = 0, r = N - 1;
        int answer = Integer.MAX_VALUE;

        while (l < r) {
            int sum = nums[l] + nums[r];
            answer = Math.min(answer, Math.abs(sum));

            if (sum > 0) r--;
            else l++;
        }

        System.out.print(answer);
    }
}