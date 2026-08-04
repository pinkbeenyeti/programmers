import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int key = Integer.parseInt(st.nextToken());
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            answer.append(map.getOrDefault(key, 0)).append(" ");
        }

        System.out.print(answer);
    }
}