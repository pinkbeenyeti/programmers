import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    private static int N, X;
    private static StringBuilder answer = new StringBuilder();

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            int target = Integer.parseInt(st.nextToken());

            if (target < X) {
                answer.append(target).append(" ");
            }
        }

        System.out.print(answer.toString());
    }

    public static void main(String[] args) throws IOException {
        process();
    }
}
