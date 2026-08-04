import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String target = br.readLine();

            char[] array = target.toCharArray();
            Arrays.sort(array);

            target = new String(array);
            map.put(target, map.getOrDefault(target, 0) + 1);
        }

        for (String key : map.keySet()) {
            answer = Math.max(answer, map.get(key));
        }

        System.out.print(answer);
    }
}