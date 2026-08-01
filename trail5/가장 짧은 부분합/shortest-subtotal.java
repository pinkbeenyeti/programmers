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

        int answer = Integer.MAX_VALUE, sum = 0;
        int l = 0;

        for (int r = 0; r < N; r++) {
            sum += nums[r];

            while (l <= r && sum >= S) {
                answer = Math.min(answer, r - l + 1);
                sum -= nums[l];
                l++;
            }
        }

        if (answer == Integer.MAX_VALUE) System.out.print(-1);
        else System.out.print(answer);
    }
}