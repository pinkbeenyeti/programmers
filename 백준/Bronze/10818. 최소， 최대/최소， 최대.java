import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    private static int N, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            int target = Integer.parseInt(st.nextToken());

            if (min > target) min = target;
            if (max < target) max = target;
        }

        System.out.print(min + " " + max);
    }

    public static void main(String[] args) throws IOException {
        process();
    }
}
