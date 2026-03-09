import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static Map<String, Integer> bookName = new HashMap<>();
    private static String[] bookNumber;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        bookNumber = new String[N + 1];

        for (int i=1; i<=N; i++) {
            String target = br.readLine();

            bookName.put(target, i);
            bookNumber[i] = target;
        }

        for (int i=1; i<=M; i++) {
            String target = br.readLine();

            try {
                int number = Integer.parseInt(target);
                answer.append(bookNumber[number]).append("\n");
            } catch (Exception e) {
                answer.append(bookName.get(target)).append("\n");
            }
        }

        System.out.print(answer);
    }
}
