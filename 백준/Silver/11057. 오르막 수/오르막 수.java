import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static long normalize = 10_007;
    private static long[][] dp = new long[1001][11];
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
    }
    
    private static void process() {
        for (int col=0; col<10; col++) {
            dp[1][col] = 1;
            dp[2][col] = col + 1;
        }
        
        for (int row=3; row<=1000; row++) {
            for (int col=0; col<10; col++) {
                if (col == 0) dp[row][col] = 1;
                else dp[row][col] = (dp[row][col - 1] + dp[row - 1][col]) % normalize;
            }
        }
        
        for (int row=1; row<=1000; row++) {
            long sum = 0;
            
            for (int col=0; col<10; col++) {
                sum = (sum + dp[row][col]) % normalize;
            }
            
            dp[row][10] = sum;
        }
        
        System.out.println(dp[N][10]);
    }
    
    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
