import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] groups = new int[N + 1];
        int[][] sums = new int[4][N + 1];

        for (int i = 1; i <= N; i++) {
            groups[i] = Integer.parseInt(br.readLine()); 
        }

        for (int i = 1; i <= N; i++) {
            int group = groups[i];

            for (int j = 1; j <= 3; j++) {
                if (group == j) sums[j][i] = sums[j][i - 1] + 1;
                else sums[j][i] = sums[j][i - 1];
            }
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for (int j = 1; j <= 3; j++) {
                answer.append(sums[j][b] - sums[j][a - 1]);
                answer.append(" ");
            }
            
            answer.append("\n");
        }

        System.out.print(answer);
    }
}