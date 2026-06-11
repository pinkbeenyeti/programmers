import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static int answer = Integer.MAX_VALUE;
    private static int N, M;

    private static List<int[]> allLines;
    private static int[][][] ladder;

    private static int[] order;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        allLines = new ArrayList<>();
        ladder = new int[30][N + 5][N + 5];
        order = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int line = Integer.parseInt(st.nextToken());
            int orderVal = Integer.parseInt(st.nextToken());

            allLines.add(new int[]{line, orderVal});
        }

        for (int[] line : allLines) {
            ladder[line[1]][line[0]][line[0] + 1] = 1;
            ladder[line[1]][line[0] + 1][line[0]] = 1;
        }

        down(-1);

        for (int i = 1; i <= N; i++) {
            order[i] = ladder[25][0][i];
            ladder[25][0][i] = 0;
        }

        for (int[] line : allLines) {
            ladder[line[1]][line[0]][line[0] + 1] = 0;
            ladder[line[1]][line[0] + 1][line[0]] = 0;
        }

        for (int i = 0; i <= M; i++) {
            find(0, i, 0);
        }

        System.out.print(M);
    }

    private static void find(int start, int end, int count) {
        if (count == end) {
            down(count);
            return;
        }

        for (int i = start; i < allLines.size(); i++) {
            int[] line = allLines.get(i);

            ladder[line[1]][line[0]][line[0] + 1] = 1;
            ladder[line[1]][line[0] + 1][line[0]] = 1;

            find(i + 1, end, count + 1);

            ladder[line[1]][line[0]][line[0] + 1] = 0;
            ladder[line[1]][line[0] + 1][line[0]] = 0;
        }
    }

    private static void down(int count) {
        for (int i = 1; i <= N; i++) {
            int pos = i;

            for (int j = 1; j <= 20; j++) {
                if (ladder[j][pos - 1][pos] == 1) pos = pos - 1; 
                else if (ladder[j][pos][pos + 1] == 1) pos = pos + 1; 
            }

            ladder[25][0][i] = pos;
        }

        if (count == -1) return;

        boolean isSame = true;
        
        for (int i = 1; i <= N; i++) {
            if (ladder[25][0][i] != order[i]) isSame = false;
            ladder[25][0][i] = 0;
        }

        if (isSame) {
            System.out.print(count);
            System.exit(0);
        }
    }
}