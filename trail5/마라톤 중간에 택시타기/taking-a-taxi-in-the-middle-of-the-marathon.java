import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        
        int[][] spots = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            spots[i][0] = Integer.parseInt(st.nextToken());
            spots[i][1] = Integer.parseInt(st.nextToken());
        }

        if (N <= 2) {
            System.out.print(0);
            return;
        }

        int[] L = new int[N + 1];
        int[] R = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            L[i] = L[i - 1] + Math.abs(spots[i][0] - spots[i - 1][0]) 
                            + Math.abs(spots[i][1] - spots[i - 1][1]);
        }

        for (int i = N - 1; i >= 1; i--) {
            R[i] = R[i + 1] + Math.abs(spots[i][0] - spots[i + 1][0]) 
                            + Math.abs(spots[i][1] - spots[i + 1][1]);
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 2; i < N; i++) {
            int dist = L[i - 1] + R[i + 1] 
                     + Math.abs(spots[i - 1][0] - spots[i + 1][0]) 
                     + Math.abs(spots[i - 1][1] - spots[i + 1][1]);
            
            answer = Math.min(answer, dist);
        }

        System.out.print(answer);
    }
}