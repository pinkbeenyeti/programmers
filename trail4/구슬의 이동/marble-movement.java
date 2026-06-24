import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, T, K, answer = 0;
    private static int[][] dicts = {{0, 0}, {-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    private static class Ball {
        int index, speed, direction;

        public Ball(int index, int speed, int direction) {
            this.index = index;
            this.speed = speed;
            this.direction = direction;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Map<Integer, List<Ball>> posBall = new HashMap<>();
        Map<Integer, List<Ball>> temp = new HashMap<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int d = getDir(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            List<Ball> list = new LinkedList<>();
            list.add(new Ball(i, s, d));

            posBall.put(r * N + c, list);
        }

        for (int i = 0; i < T; i++) {
            for (int posKey : posBall.keySet()) {
                List<Ball> list = posBall.get(posKey);

                for (Ball ball : list) {
                    int nextPos = getPos(posKey, ball);

                    List<Ball> tempList = temp.getOrDefault(nextPos, new LinkedList<>());
                    tempList.add(ball);

                    temp.put(nextPos, tempList);
                }
            }

            for (int posKey : temp.keySet()) {
                List<Ball> list = temp.get(posKey);

                if (list.size() > K) {
                    int count = list.size() - K;

                    Collections.sort(list, (a, b) -> {
                        if (a.speed == b.speed) return a.index - b.index;
                        else return a.speed - b.speed;
                    });

                    for (int j = 0; j < count; j++) {
                        list.remove(0);
                    }
                }
            }

            posBall = temp;
            temp = new HashMap<>();
        }

        for (int posKey : posBall.keySet()) {
            answer += posBall.get(posKey).size();
        }

        System.out.print(answer);
    }

    private static int getDir(String value) {
        if (value.equals("U")) return 1;
        if (value.equals("L")) return 2;
        if (value.equals("R")) return 3;
        if (value.equals("D")) return 4;
        return -1;
    }

    private static int getPos(int pos, Ball ball) {
        int r = pos / N;
        int c = pos % N;

        for (int i = 0; i < ball.speed; i++) {
            int nr = r + dicts[ball.direction][0];
            int nc = c + dicts[ball.direction][1];

            if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                ball.direction = 5 - ball.direction;

                r = r + dicts[ball.direction][0];
                c = c + dicts[ball.direction][1];

                continue;
            }

            r = nr;
            c = nc;
        }

        return r * N + c;
    }
}