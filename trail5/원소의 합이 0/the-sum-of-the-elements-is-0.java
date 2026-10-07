import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] nums = new int[4][N];

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map1.put(nums[0][i] + nums[1][j], map1.getOrDefault(nums[0][i] + nums[1][j], 0) + 1);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map2.put(nums[2][i] + nums[3][j], map2.getOrDefault(nums[2][i] + nums[3][j], 0) + 1);
            }
        }

        int answer = 0;

        for (int num : map1.keySet()) {
            if (map2.containsKey(-num)) {
                answer += (map1.get(num) * map2.get(-num));
            }
        }

        System.out.print(answer);
    }
}