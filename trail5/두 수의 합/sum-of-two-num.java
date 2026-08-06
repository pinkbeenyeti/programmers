import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> isCalculated = new HashSet<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int key = Integer.parseInt(st.nextToken());
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int key : map.keySet()) {
            int opposite = K - key;

            if (!map.containsKey(opposite) || isCalculated.contains(key) || isCalculated.contains(opposite)) {
                continue;
            }

            if (key == opposite) answer += map.get(key) * (map.get(key) - 1) / 2;
            else answer += map.get(key) * map.get(opposite);

            isCalculated.add(key);
            isCalculated.add(opposite);
        }

        System.out.print(answer);
    }
}