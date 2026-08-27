import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static double[] spots;
    static double[] speeds;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        spots = new double[N];
        speeds = new double[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            spots[i] = Double.parseDouble(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            speeds[i] = Double.parseDouble(st.nextToken());
        }

        double left = 0.0;
        double right = 1_000_000_000.0;

        for (int iter = 0; iter < 100; iter++) {
            double mid = (left + right) / 2.0;

            if (isPossible(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        System.out.printf(Locale.US, "%.4f\n", right);
    }

    private static boolean isPossible(double time) {
        double maxLeft = -Double.MAX_VALUE;
        double minRight = Double.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            double cl = spots[i] - speeds[i] * time;
            double cr = spots[i] + speeds[i] * time;

            maxLeft = Math.max(maxLeft, cl);
            minRight = Math.min(minRight, cr);
        }

        return maxLeft <= minRight;
    }
}