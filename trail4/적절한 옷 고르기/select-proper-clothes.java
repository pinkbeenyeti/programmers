import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;

        Set<Integer>[] clothes = new Set[M + 1];
        for (int i = 1; i <= M; i++) clothes[i] = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            for (int j = s; j <= e; j++) {
                clothes[j].add(value);
            }
        }


        int[][] dp = new int[M + 1][1001];
        for (int i = 0; i <= 1000; i++) dp[0][i] = -1;
        for (int value : clothes[1]) dp[1][value] = 0;

        for (int i = 2; i <= M; i++) {
            for (int value1 : clothes[i]) {
                for (int value2 : clothes[i - 1]) {
                    dp[i][value1] = Math.max(
                                            dp[i][value1], 
                                            dp[i - 1][value2] + (int) Math.abs(value2 - value1)
                                            );
                }
            }
        }

        for (int i = 1; i <= 1000; i++) {
            answer = Math.max(dp[M][i], answer);
        }

        System.out.print(answer);
    }
}