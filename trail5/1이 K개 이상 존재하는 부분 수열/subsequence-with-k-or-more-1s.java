import java.util.*;
import java.io.*;
  
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] nums = new int[N + 1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int l = 1, r = 1, count = (nums[1] == 1) ? 1 : 0;
        int answer = Integer.MAX_VALUE;

        while (l <= r && r <= N) {
            if (count >= K) {
                count = (nums[l] == 1) ? count - 1 : count;
                answer = Math.min(answer, r - l + 1);
                l++;
            }
            else {
                count = (r < N && nums[r + 1] == 1) ? count + 1 : count;
                r++;
            }

        }

        if (answer == Integer.MAX_VALUE)
            System.out.print(-1);
        else
            System.out.print(answer);
    }
}