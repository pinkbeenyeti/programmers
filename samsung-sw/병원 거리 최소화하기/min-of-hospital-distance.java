import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main {

    private static int n, m, answer = Integer.MAX_VALUE;
    private static int[][] map;

    private static List<int[]> people;
    private static List<int[]> hospital;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        people = new ArrayList<>();
        hospital = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) people.add(new int[]{i, j});
                else if (map[i][j] == 2) hospital.add(new int[]{i, j}); 
            }
        }
    }

    private static void process() {
        bfs(new int[m], 0, 0);
        System.out.print(answer);
    }

    private static void bfs(int[] remainHospitals, int count, int start) {
        if (count == m) {
            int result = calculateDistance(remainHospitals);
            answer = Math.min(answer, result);
            return;
        }

        for (int i = start; i < hospital.size(); i++) {
            remainHospitals[count] = i;
            bfs(remainHospitals, count + 1, i + 1);
        }
    }

    private static int calculateDistance(int[] remainHospitals) {
        int result = 0;

        for (int[] man : people) {
            int current = Integer.MAX_VALUE;

            for (int number : remainHospitals) {
                int[] building = hospital.get(number);
                int distance = Math.abs(man[0] - building[0]) + Math.abs(man[1] - building[1]);
                current = Math.min(current, distance);
            }

            result += current;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}