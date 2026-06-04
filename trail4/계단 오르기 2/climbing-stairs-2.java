import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N, answer = 0;
    private static int[] numbers;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        numbers = new int[N + 1];
        // 1칸 오르기는 최대 3번까지 가능하므로, j 인덱스는 0, 1, 2, 3이 필요합니다. (크기 4)
        dp = new int[N + 1][4];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 최댓값을 구해야 하므로 도달할 수 없는 상태는 -1로 초기화
        for (int[] array : dp) {
            Arrays.fill(array, -1);
        }

        // 1. 초기값 설정
        dp[0][0] = 0; // 0번 계단, 1칸 오르기 0번 사용 = 0점
        
        if (N >= 1) {
            dp[1][1] = numbers[1]; // 1번 계단은 0번에서 1칸 오르는 수밖에 없음 (1칸 오르기 1회 누적)
        }

        // 2. 2번 계단부터 N번 계단까지 Pull 방식으로 채우기
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 3; j++) {
                
                // 선택지 A: 2칸 전(i-2)에서 2칸 점프해서 현재 칸(i)으로 온 경우 (j 유지)
                if (dp[i - 2][j] != -1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 2][j] + numbers[i]);
                }

                // 선택지 B: 1칸 전(i-1)에서 1칸 올라서 현재 칸(i)으로 온 경우 (j가 1회 늘어난 상태이므로 과거엔 j-1)
                if (j > 0 && dp[i - 1][j - 1] != -1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + numbers[i]);
                }
            }
        }

        // 3. 최종 정답 확인: 정확히 N번째 계단에 도달했을 때의 모든 j 조건 중 최댓값 선택
        for (int j = 0; j <= 3; j++) {
            answer = Math.max(answer, dp[N][j]);
        }

        System.out.print(answer);
    }
}