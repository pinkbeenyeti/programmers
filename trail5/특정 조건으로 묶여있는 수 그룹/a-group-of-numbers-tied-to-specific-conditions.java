import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] nums = new int[N + 1];
        for (int i = 1; i <= N; i++) nums[i] = Integer.parseInt(br.readLine());
        Arrays.sort(nums, 1, N + 1);

        int[] size = new int[N + 1];
        int r = 1;
        for (int l = 1; l <= N; l++) {
            while (r <= N && nums[r] - nums[l] <= K) {
                r++;
            }
            size[l] = r - l; 
        }

        int[] rightMax = new int[N + 2];
        for (int i = N; i >= 1; i--) {
            rightMax[i] = Math.max(size[i], rightMax[i + 1]);
        }

        int answer = 0;
        for (int l = 1; l <= N; l++) {
            int firstGroup = size[l];
            int nextStart = l + firstGroup;
            
            int secondGroup = (nextStart <= N) ? rightMax[nextStart] : 0;
            answer = Math.max(answer, firstGroup + secondGroup);
        }

        System.out.print(answer);
    }
}