import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder answer = new StringBuilder();
    private static int N, R;

    private static Map<Integer, Integer> numbers;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        numbers = new HashMap<>();
        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            int number = Integer.parseInt(st.nextToken());
            numbers.put(number, numbers.getOrDefault(number, 0) + 1);
        }

        R = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i=0; i<R; i++) {
            answer.append(numbers.getOrDefault(Integer.parseInt(st.nextToken()), 0));
            answer.append(" ");
        }
    }

    private static void process() {
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
