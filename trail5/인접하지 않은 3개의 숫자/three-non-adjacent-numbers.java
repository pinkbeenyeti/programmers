import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N + 2];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] l = new int[N + 2];
        int[] r = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            l[i] = Math.max(numbers[i], l[i - 1]);
        }

        for (int i = N; i >= 1; i--) {
            r[i] = Math.max(numbers[i], r[i + 1]);
        }

        int answer = 0;

        for (int i = 3; i <= (N - 2); i++) {
            answer = Math.max(answer, l[i - 2] + numbers[i] + r[i + 2]);
        }

        System.out.print(answer);
    }
}