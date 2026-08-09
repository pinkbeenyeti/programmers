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

            int l = 1, r = N;
            int index = -1;

            while (l <= r) {
                int mid = (l + r) / 2;

                if (nums[mid] > target) 
                    r = mid - 1;
                else if (nums[mid] == target) {
                    index = mid;
                    break;
                }
                else
                    l = mid + 1; 
            }

            answer.append(index).append("\n");
        }

        System.out.print(answer);
    }
}