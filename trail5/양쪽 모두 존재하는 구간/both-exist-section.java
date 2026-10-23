import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nums = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) nums[i] = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> inner = new HashMap<>();
        Map<Integer, Integer> outter = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            if (i == 1) inner.put(nums[i], 1);
            else outter.put(nums[i], outter.getOrDefault(nums[i], 0) + 1);
        }

        int l = 1, r = 1;
        int answer = 1_000_000;

        while (r <= N) {
            if (inner.size() < M) {
                if (r < N) {
                    inner.put(nums[r + 1], inner.getOrDefault(nums[r + 1], 0) + 1);
                    outter.put(nums[r + 1], outter.get(nums[r + 1]) - 1);
                    if (outter.get(nums[r + 1]) == 0) outter.remove(nums[r + 1]);
                }
                r++;
            }
            else {
                inner.put(nums[l], inner.get(nums[l]) - 1);
                outter.put(nums[l], outter.getOrDefault(nums[l], 0) + 1);
                if (inner.get(nums[l]) == 0) inner.remove(nums[l]);
                l++;
            }

            if (inner.size() >= M && outter.size() >= M) {
                answer = Math.min(answer, r - l + 1);
            }
        }

        if (answer == 1_000_000) System.out.print(-1);
        else System.out.print(answer);
    }
}