import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] lines = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lines[i][0] = Math.min(a, b);
            lines[i][1] = Math.max(a, b);
        } 

        Arrays.sort(lines, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        int l = 1, r = 1_000_000_000;
        int answer = 0;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (find(lines, mid)) {
                l = mid + 1;
                answer = Math.max(answer, mid);
            } else {
                r = mid - 1;
            }
        }

        System.out.print(answer);
    }

    private static boolean find(int[][] lines, int diff) {
        int prev = lines[0][0] - diff;

        for (int[] line : lines) {
            int temp = Math.max(prev + diff, line[0]);

            if (temp <= line[1]) 
                prev = temp;
            else 
                return false;
        }

        return true;
    }
}