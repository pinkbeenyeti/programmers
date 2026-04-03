import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    private static int N, ANSWER = 0;

    private static int[][] map;
    private static int[] times = new int[20000];
    private static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r - 1][c - 1] = 1;
        }

        T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            int direction = (st.nextToken().equals("D") ? 1 : 2);

            times[time] = direction;
        }

    }

    private static void process() {
        ArrayDeque<int[]> snake = new ArrayDeque<>();
        snake.add(new int[]{0, 0});

        int dirIndex = 0;

        while (true) {
            int[] head = snake.peek();
            boolean isTouch = false;

            int r = head[0] + directions[dirIndex][0];
            int c = head[1] + directions[dirIndex][1];

            if (r < 0 || r >= N || c < 0 || c >= N) {
                break;
            }

            for (int[] part : snake) {
                if (part[0] == r && part[1] == c) {
                    isTouch = true;
                    break;
                }
            }

            if (isTouch) {
                break;
            }

            if (map[r][c] == 1) {
                snake.offerFirst(new int[]{r, c});
                map[r][c] = 0;
            } else {
                snake.offerFirst(new int[]{r, c});
                snake.pollLast();
            }

            ANSWER++;

            if (times[ANSWER] == 1) dirIndex = (dirIndex + 5) % 4;
            else if (times[ANSWER] == 2) dirIndex = (dirIndex + 3) % 4;
        }

        System.out.print(ANSWER + 1);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
