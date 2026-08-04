import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long answer = 0;

        Map<Integer, Integer> map = new HashMap<>();       

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (map.containsKey(x)) map.put(x, Math.min(y, map.get(x)));
            else map.put(x, y);
        } 

        for (int key : map.keySet()) {
            answer += map.get(key);
        }

        System.out.print(answer);
    }
}