import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<int[]> houses = new ArrayList<>();
    private static List<int[]> chickens = new ArrayList<>();

    private static int N = 0;
    private static int M = 0;
    private static int answer = Integer.MAX_VALUE;

    private static int[][] distances;
    private static int[] chickenIndexes;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=1; j<=N; j++) {
                int value = Integer.parseInt(st.nextToken());

                if (value == 1) houses.add(new int[]{i, j});
                else if (value == 2) chickens.add(new int[]{i, j});
            }
        }
    }

    private static void getDistances() {
        distances = new int[houses.size()][chickens.size()];
        chickenIndexes = new int[M];

        for (int i=0; i<houses.size(); i++) {
            for (int j=0; j<chickens.size(); j++) {
                int xD = Math.abs(houses.get(i)[0] - chickens.get(j)[0]);
                int yD = Math.abs(houses.get(i)[1] - chickens.get(j)[1]);

                distances[i][j] = xD + yD;
            }
        }

    }

    private static void calculateMin() {
        int result = 0;

        for (int i=0; i<houses.size(); i++) {
            int minDistance = Integer.MAX_VALUE;

            for (int j=0; j<M; j++) {
                minDistance = Math.min(minDistance, distances[i][chickenIndexes[j]]);
            }

            result += minDistance;
        }

        answer = Math.min(answer, result);
    }

    private static void combProcess(int start, int count) {
        if (count == M) {
            calculateMin();
            return;
        }

        for (int i=start; i<chickens.size(); i++) {
            chickenIndexes[count] = i;
            combProcess(i + 1, count + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        getDistances();
        combProcess(0, 0);
        System.out.print(answer);
    }
}
