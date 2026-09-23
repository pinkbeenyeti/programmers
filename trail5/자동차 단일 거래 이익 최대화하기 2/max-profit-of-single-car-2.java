import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] prices = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        int buy = prices[0];
        int answer = 0;

        for (int i = 1; i < N; i++) {
            if (prices[i] < buy)
                buy = prices[i];
            else
                answer = Math.max(answer, prices[i] - buy);
        }

        System.out.print(answer);
    }
}