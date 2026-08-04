import java.io.*;
import java.util.*;

public class Main {

    private static class Number {
        int num, count;

        public Number(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        List<Number> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int key = Integer.parseInt(st.nextToken());
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int key : map.keySet()) {
            list.add(new Number(key, map.get(key)));
        }

        Collections.sort(list, (a, b) -> {
            if (a.count == b.count) return Integer.compare(b.num, a.num);
            return Integer.compare(b.count, a.count);
        });

        for (int i = 0; i < K; i++) {
            answer.append(list.get(i).num).append(" ");
        }

        System.out.print(answer);
    }
}