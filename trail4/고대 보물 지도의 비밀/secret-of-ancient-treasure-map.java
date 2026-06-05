import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = Integer.MIN_VALUE;

        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int sum = 0;
            int count = 0;

            for (int j = i; j < N; j++) {
                if (j > i) count += (numbers[j] < 0) ? 1 : 0;
                else count = (numbers[j] < 0) ? 1 : 0;

                if (count > K) break;
                else {
                    sum += numbers[j];
                    answer = Math.max(answer, sum);
                }
            }
        }

        System.out.print(answer);
    }
}