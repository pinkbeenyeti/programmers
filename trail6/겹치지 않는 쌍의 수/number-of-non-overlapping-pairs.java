import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int answer = 0;

        int[] groups = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int group = 0;

            for (int j = 0; j < m; j++) {
                group |= 1 << Integer.parseInt(st.nextToken());
            }

            groups[i] = group;
        }

        for (int i = 0; i < (N - 1); i++) {
            for  (int j = (i + 1); j < N; j++) {
                if ((groups[i] & groups[j]) == 0) {
                    answer++;
                }
            }
        }

        System.out.print(answer);

    }
}