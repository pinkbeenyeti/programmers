import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new TreeMap<>();

        st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i <= N; i++) {
            int target = Integer.parseInt(st.nextToken());

            if (!map.containsKey(target)) {
                map.put(target, i);
            }
        }

        for (int key : map.keySet()){
            answer.append(key).append(" ").append(map.get(key));
            answer.append("\n");
        }

        System.out.print(answer);
    }
}