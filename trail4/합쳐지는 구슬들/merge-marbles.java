import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;

public class Main {

    private static int N, M, T;
    private static int count = 0, maxValue = 0;
    private static int[][] dicts = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // U(0), D(1), L(2), R(3)

    private static class Ball {
        int index, value, direction;

        public Ball(int index, int value, int direction) {
            this.index = index;
            this.value = value;
            this.direction = direction;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        Map<Integer, Ball> posBall = new HashMap<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int d = getDirection(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            posBall.put(r * N + c, new Ball(i, v, d));
        }

        for (int i = 0; i < T; i++) {
            Map<Integer, Ball> temp = new HashMap<>();

            for (int posKey : posBall.keySet()) {
                Ball ball = posBall.get(posKey);

                int curR = posKey / N;
                int curC = posKey % N;

                int r = dicts[ball.direction][0] + curR;
                int c = dicts[ball.direction][1] + curC;
                
                int nextKey;
                int nextDir = ball.direction;

                // 1. 벽에 부딪히는 경우: 제자리 유지 및 방향 반전
                if (r < 0 || r >= N || c < 0 || c >= N) {
                    nextKey = posKey; // 제자리
                    if (ball.direction == 0 || ball.direction == 1) {
                        nextDir = 1 - ball.direction;
                    } else {
                        nextDir = 5 - ball.direction;
                    }
                } 
                // 격자 내부로 정상 이동하는 경우
                else {
                    nextKey = r * N + c;
                }

                // 2. 통합 병합 처리 (이동한 구슬이든, 튕겨서 제자리에 있는 구슬이든 똑같이 처리되어야 함)
                if (!temp.containsKey(nextKey)) {
                    temp.put(nextKey, new Ball(ball.index, ball.value, nextDir));
                } else {
                    Ball tempBall = temp.get(nextKey);
                    int totalValue = tempBall.value + ball.value;

                    // 새로 이동해 온 구슬의 index(번호)가 더 클 때만 번호와 방향을 갱신
                    if (ball.index > tempBall.index) {
                        tempBall.index = ball.index;
                        tempBall.direction = nextDir;
                    }
                    // 무게는 무조건 누적합
                    tempBall.value = totalValue;
                }
            }

            posBall = temp;
        }

        for (int posKey : posBall.keySet()) {
            maxValue = Math.max(maxValue, posBall.get(posKey).value);
            count++;
        }

        System.out.print(count + " " + maxValue);
    }

    private static int getDirection(String value) {
        if (value.equals("U")) return 0;
        if (value.equals("D")) return 1;
        if (value.equals("L")) return 2;
        if (value.equals("R")) return 3;
        return -1;
    }
}