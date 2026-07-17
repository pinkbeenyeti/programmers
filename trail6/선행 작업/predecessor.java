import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int answer = 0;

        int[] degrees = new int[N + 1];
        int[] times = new int[N + 1];
        int[] dp = new int[N + 1];

        // preTasks -> nextTasks (선행 노드 완료 후 갈 수 있는 '후행 노드 목록'으로 변경)
        List<Integer>[] nextTasks = new List[N + 1];
        for (int i = 1; i <= N; i++) nextTasks[i] = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            int preTaskCount = Integer.parseInt(st.nextToken());

            times[i] = time;
            degrees[i] = preTaskCount;

            for (int j = 1; j <= preTaskCount; j++) {
                int pre = Integer.parseInt(st.nextToken());
                // 핵심: pre(선행)가 끝나면 i(후행)로 갈 수 있다는 방향성 설정
                nextTasks[pre].add(i); 
            }
        }

        Queue<Integer> qu = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (degrees[i] == 0) {
                qu.offer(i);
                dp[i] = times[i]; // 선행 작업이 없는 것은 자기 자신의 시간이 곧 완료 최소 시간
            }
        }

        while (!qu.isEmpty()) {
            int node = qu.poll();

            for (int next : nextTasks[node]) {
                // next의 선행 작업들 중 가장 늦게 끝나는 완료 시간(최댓값)을 계속 갱신
                dp[next] = Math.max(dp[next], dp[node]);
                
                degrees[next]--;
                
                // 모든 선행 작업이 완료되어 진입차수가 0이 되면 Queue에 넣음
                if (degrees[next] == 0) {
                    // 기다림이 끝났으므로 이제 내 작업 시간(times[next])을 더해 최종 완료 시간을 결정함
                    dp[next] += times[next];
                    qu.offer(next);
                }
            }
        }

        // 전체 작업 중 가장 마지막에 끝난 작업의 완료 시간을 찾음
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, dp[i]);
        }

        System.out.print(answer);
    }
}