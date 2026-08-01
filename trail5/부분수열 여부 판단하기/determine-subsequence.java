import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int big = 1;

        int[] arr1 = new int[N + 1];
        int[] arr2 = new int[M + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        boolean isSub = true;

        for (int small = 1; small <= M; small++) {
            while (big <= N && arr1[big] != arr2[small]) {
                big++;
            }

            if (big > N) {
                isSub = false;
                break;
            } else {
                big++;
            }
        }

        if (isSub) System.out.print("Yes");
        else System.out.print("No");
    }
}