import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[][] map;
    private static int[][] dicts = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private static int babyR, babyC;
    private static int babySize = 2, eat = 0, time = 0;

    private static class Node implements Comparable<Node> {
        int r, c, dist;

        public Node(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node other) {
            if (dist != other.dist) return dist - other.dist;
            else if (r != other.r) return r - other.r;
            else return c - other.c;
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 9) {
                    babyR = i;
                    babyC = j;
                    map[i][j] = 0;
                }
            }
        }
    }

    private static Node findFish() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(babyR, babyC, 0));

        boolean[][] visited = new boolean[N][N];
        visited[babyR][babyC] = true;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (map[curr.r][curr.c] > 0 && map[curr.r][curr.c] < babySize) {
                return curr;
            }

            for (int[] dict : dicts) {
                int r = dict[0] + curr.r;
                int c = dict[1] + curr.c;

                if (r >= 0 && r < N && c >= 0 && c < N && !visited[r][c]) {
                    if (map[r][c] <= babySize) {
                        visited[r][c] = true;
                        pq.offer(new Node(r, c, curr.dist + 1));
                    }
                }
            }
        }

        return null;
    }

    private static void process() {
        while (true) {
            Node fish = findFish();

            if (fish != null) {
                time += fish.dist;

                babyR = fish.r;
                babyC = fish.c;

                map[babyR][babyC] = 0;

                if (++eat == babySize) {
                    babySize++;
                    eat = 0;
                }

                continue;
            }

            break;
        }

        System.out.print(time);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
