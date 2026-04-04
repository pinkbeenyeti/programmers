import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int R, C, T;

    private static int[][] map;
    private static int[][] dicts = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private static int upR = -1, upC = -1;
    private static int downR = -1, downC = -1;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for (int i=0; i<R ;i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == -1) {
                    if (upR == -1) {
                        upR = i;
                        upC = j;
                    } else {
                        downR = i;
                        downC = j;
                    }
                }
            }
        }
    }

    private static void diffuse() {
        int[][] tempMap = new int[R][C];

        tempMap[upR][0] = -1;
        tempMap[downR][0] = -1;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    int dirt = map[i][j] / 5;
                    int count = 0;

                    for (int[] dict : dicts) {
                        int r = i + dict[0];
                        int c = j + dict[1];

                        if (r >= 0 && r < R && c >= 0 && c < C && map[r][c] != -1) {
                            tempMap[r][c] += dirt;
                            count++;
                        }
                    }
                    tempMap[i][j] += (map[i][j] - (dirt * count));
                }
            }
        }
        map = tempMap;
    }

    private static void airCleaner() {
        for (int i=(upR - 1); i>0; i--) {
            map[i][0] = map[i - 1][0];
        }

        for (int i=(downR + 1); i<(R - 1); i++) {
            map[i][0] = map[i + 1][0];
        }

        for (int i=0; i<(C - 1); i++) {
            map[0][i] = map[0][i + 1];
            map[R - 1][i] = map[R - 1][i + 1];
        }

        for (int i=0; i<upR; i++) {
            map[i][C - 1] = map[i + 1][C - 1];
        }

        for (int i=(R - 1); i>downR; i--) {
            map[i][C - 1] = map[i - 1][C - 1];
        }

        for (int i=(C - 1); i>1; i--) {
            map[upR][i] = map[upR][i - 1];
            map[downR][i] = map[downR][i - 1];
        }

        map[upR][1] = 0;
        map[downR][1] = 0;
    }

    private static void process() {
        long answer = 0;

        for (int i=0; i<T; i++) {
            diffuse();
            airCleaner();
        }

        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                if (map[i][j] != -1) {
                    answer += map[i][j];
                }
            }
        }

        System.out.print(answer);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
