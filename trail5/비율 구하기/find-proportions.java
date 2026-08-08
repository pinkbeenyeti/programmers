import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int sum = 0;

        Map<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            String target = br.readLine();
            map.put(target, map.getOrDefault(target, 0) + 1);
        }

        for (String key : map.keySet()) {
            sum += map.get(key);
        }

        for (String key : map.keySet()) {
            double value = (double) map.get(key) / sum * 100;
            answer.append(key).append(" ");
            answer.append(String.format("%.4f", value));
            answer.append("\n");
        }

        System.out.print(answer);
    }
}