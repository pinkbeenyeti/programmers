import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> si = new HashMap<>();
        Map<Integer, String> is = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            si.put(s, i);
            is.put(i, s);
        }

        for (int i = 0; i < M; i++) {
            String key = br.readLine();
            
            try {
                int num = Integer.parseInt(key);
                answer.append(is.get(num)).append("\n");
            } catch(Exception e) {
                answer.append(si.get(key)).append("\n");
            }
        }

        System.out.print(answer);
    }
}