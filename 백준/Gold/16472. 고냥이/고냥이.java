import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static String language;

    private static Map<Character, Integer> count;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        language = br.readLine();
        count = new HashMap<>();
    }

    private static void process() {
        int L = 0, answer = 0;
        int len = language.length();

        for (int R=0; R<len; R++) {
            char rightCh = language.charAt(R);
            count.put(rightCh, count.getOrDefault(rightCh, 0) + 1);

            while (count.size() > N) {
                char leftCh = language.charAt(L);
                count.put(leftCh, count.get(leftCh) - 1);

                if (count.get(leftCh) == 0) {
                    count.remove(leftCh);
                }

                L++;
            }

            answer = Math.max(answer, R - L + 1);;
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
