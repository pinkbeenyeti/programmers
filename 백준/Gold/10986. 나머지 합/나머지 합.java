import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static long[] cnt;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        cnt = new long[M];
        long next = 0;

        for (int i=1; i<=N; i++) {
            next = (next + Integer.parseInt(st.nextToken())) % M;
            cnt[(int) next]++;
        }
    }

    private static void process() {
        long answer = cnt[0];

        for (int i=0; i<M; i++) {
            if (cnt[i] > 1) answer += (cnt[i] * (cnt[i] - 1)) / 2;
        }

        System.out.print(answer);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
