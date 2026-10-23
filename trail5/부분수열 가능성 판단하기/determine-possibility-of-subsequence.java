import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N + 1];
        int[] B = new int[M + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) B[i] = Integer.parseInt(st.nextToken());

        int[] prefix = new int[M + 2];
        int[] suffix = new int[M + 2];

        Arrays.fill(prefix, 2_000_000);
        Arrays.fill(suffix, 0);

        prefix[0] = 0;
        suffix[M + 1] = 2_000_000;

        int Aindex = 1;
        for (int i = 1; i <= M; i++) {
            while (Aindex <= N && A[Aindex] != B[i]) {
                Aindex++;
            }

            if (Aindex <= N) {
                prefix[i] = Aindex;
            }

            Aindex++;
        }

        Aindex = N;
        for (int i = M; i >= 1; i--) {
            while (Aindex > 0 && A[Aindex] != B[i]) {
                Aindex--;
            }

            if (Aindex > 0) {
                suffix[i] = Aindex;
            }

            Aindex--;
        }

        int answer = 0;
        for (int i = 1; i <= M; i++) {
            if (prefix[i - 1] < suffix[i + 1]) {
                answer++;
            }
        }
        
        System.out.print(answer);
    }
}