import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = -1;

        Map<Integer, Integer> map = new HashMap<>();
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        } 

        for (int i = 0; i <= K; i++) {
            if (i >= N) break;
            answer = map.containsKey(nums[i]) ? Math.max(answer, nums[i]) : Math.max(answer, -1);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = (K + 1); i < N; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            map.put(nums[i - K - 1], Math.max(map.get(nums[i - K - 1]) - 1, 0));

            if (map.get(nums[i]) > 1) {
                answer = Math.max(answer, nums[i]);
            }
        }

        System.out.print(answer);
    }
}