import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, LIMIT, ANSWER = Integer.MAX_VALUE;
    private static int[][] board;
    private static boolean[] visited; // ★ 조합 리스트 대신 방문 배열 사용

    private static void dfs(int depth, int start) {
        // 1. 기저 사례: 팀원 N/2명을 모두 뽑았을 때
        if (depth == LIMIT) {
            int startTeamScore = 0;
            int linkTeamScore = 0;

            // 2. 모든 N*N을 순회하며 점수 계산
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    // i와 j가 둘 다 스타트 팀일 때
                    if (visited[i] && visited[j]) {
                        startTeamScore += board[i][j] + board[j][i];
                    }
                    // i와 j가 둘 다 링크 팀일 때
                    else if (!visited[i] && !visited[j]) {
                        linkTeamScore += board[i][j] + board[j][i];
                    }
                }
            }

            // 3. 점수 차이의 최솟값 갱신
            ANSWER = Math.min(ANSWER, Math.abs(startTeamScore - linkTeamScore));
            return;
        }

        // 4. 재귀: 조합 뽑기
        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false; // 백트래킹
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        LIMIT = N / 2;
        board = new int[N][N];
        visited = new boolean[N]; // ★ 방문 배열 초기화
        // combinations 리스트는 이제 필요 없음

        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void process() {
        dfs(0, 0); // ★ 새로운 dfs 호출
        System.out.println(ANSWER);
    }

    // main 메서드는 동일
    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
