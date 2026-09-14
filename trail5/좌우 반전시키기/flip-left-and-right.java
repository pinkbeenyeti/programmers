import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] values = new int[N + 2];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        int flip = 0;

        for (int i = 2; i <= N; i++) {
            if (values[i - 1] == 0) {
                flip++;
                values[i - 1] = 1 - values[i - 1];
                values[i] = 1 - values[i];
                values[i + 1] = 1 - values[i + 1];
            }
        }

        if (values[N] == 0) System.out.print(-1);
        else System.out.print(flip);
    }
}