import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int SUM = 0;

        double answer = Double.MIN_VALUE;

        int[] nums = new int[N + 1];
        int[] mins = new int[N + 1];
        int[] sums = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int target = Integer.parseInt(st.nextToken());

            nums[i] = target;
            mins[i] = target;
            sums[i] = sums[i - 1] + target;
            
            SUM += target;
        }

        for (int i = N - 1; i >= 1; i--) {
            mins[i] = Math.min(mins[i], mins[i + 1]);
        }

        for (int i = 1; i <= N - 2; i++) {
            double result = (SUM - sums[i] - mins[i + 1]) / (double) (N - i - 1);
            answer = Math.max(answer, result);
        }

        System.out.print(String.format("%.2f", answer));
    }
}