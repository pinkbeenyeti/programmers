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
        for (int i = 1; i <= N; i++) nums[i] = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[1], 1);

        int l = 1, r = 1;
        int answer = 1;
        
        while (r < N) {
            if (map.getOrDefault(nums[r + 1], 0) == K) {
                map.put(nums[r + 1], map.get(nums[r + 1]) + 1);

                while (map.get(nums[r + 1]) > K) {
                    map.put(nums[l], map.get(nums[l]) - 1);
                    l++;
                }
                
                r++;
            }
            else {
                map.put(nums[r + 1], map.getOrDefault(nums[r + 1], 0) + 1);
                r++;
            }

            answer = Math.max(answer, r - l + 1);
        }

        System.out.print(answer);
    }
}