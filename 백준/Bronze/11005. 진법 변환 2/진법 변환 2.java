import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int number = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        while (number > 0) {
            int target = number % N;

            if (target > 9) answer.append((char) (target - 10 + 'A'));
            else answer.append(target);

            number = number / N;
        }

        System.out.print(answer.reverse());
    }
}
