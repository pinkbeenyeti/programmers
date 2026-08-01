import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0, sum = 0;
        int l = 0;

        for (int r = 0; r < N; r++) {
            sum += nums[r];

            while (l <= r && sum > S) {
                sum -= nums[l];
                l++;
            }

            if (sum == S) {
                answer++;
            }
        }

        System.out.print(answer);
    }
}