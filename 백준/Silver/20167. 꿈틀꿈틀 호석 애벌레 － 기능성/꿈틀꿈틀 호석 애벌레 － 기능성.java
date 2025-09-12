import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    private static int N, K;
    private static int stf0, stf1, acm0, acm1;

    private static int[] foods;
    private static int[][] satisfaction;
    private static int[][] accumulation;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        foods = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            foods[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void includePrevious(int index) {
        if (foods[index] + satisfaction[0][index-1] >= K) {
            stf0 = 0;
            acm0 = foods[index] + satisfaction[0][index-1] - K;
        } else {
            stf0 =  foods[index] + satisfaction[0][index-1];
            acm0 = 0;
        }

        if (foods[index] + satisfaction[1][index-1] >= K) {
            stf1 = 0;
            acm1 = foods[index] + satisfaction[1][index-1] - K;
        } else {
            stf1 =  foods[index] + satisfaction[1][index-1];
            acm1 = 0;
        }

        if (acm0 + accumulation[0][index-1] > acm1 + accumulation[1][index-1]) {
            satisfaction[1][index] = stf0;
            accumulation[1][index] = acm0 + accumulation[0][index-1];
        } else if (acm0 + accumulation[0][index-1] == acm1 + accumulation[1][index-1]) {
            accumulation[1][index] = acm0 + accumulation[0][index-1];
            satisfaction[1][index] = Math.max(stf0, stf1);
        } else {
            satisfaction[1][index] = stf1;
            accumulation[1][index] = acm1 + accumulation[1][index-1];
        }
    }

    private static void excludePrevious(int index) {
        if (foods[index] + satisfaction[0][index-2] >= K) {
            stf0 = 0;
            acm0 = foods[index] + satisfaction[0][index-2] - K;
        } else {
            stf0 =  foods[index] + satisfaction[0][index-2];
            acm0 = 0;
        }

        if (foods[index] + satisfaction[1][index-2] >= K) {
            stf1 = 0;
            acm1 = foods[index] + satisfaction[1][index-2] - K;
        } else {
            stf1 =  foods[index] + satisfaction[1][index-2];
            acm1 = 0;
        }

        if (acm0 + accumulation[0][index-2] > acm1 + accumulation[1][index-2]) {
            satisfaction[0][index]= stf0;
            accumulation[0][index] = acm0 + accumulation[0][index-2];
        } else if (acm0 + accumulation[0][index-2] == acm1 + accumulation[1][index-2]) {
            accumulation[0][index] = acm0 + accumulation[0][index-2];
            satisfaction[0][index] = Math.max(stf0, stf1);
        } else {
            satisfaction[0][index] = stf1;
            accumulation[0][index] = acm1 + accumulation[1][index-2];
        }
    }

    private static void process() {
        satisfaction = new int[2][N+1];
        accumulation = new int[2][N+1];

        satisfaction[0][1] = foods[1];
        satisfaction[1][1] = foods[1];

        for (int i=2; i<=N; i++) {
            excludePrevious(i);
            includePrevious(i);
        }

        System.out.println(Math.max(accumulation[0][N], accumulation[1][N]));
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
