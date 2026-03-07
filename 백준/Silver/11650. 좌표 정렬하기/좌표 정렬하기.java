import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int[][] coordinates;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        coordinates = new int[N][2];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            coordinates[i][0] = x;
            coordinates[i][1] = y;
        }

        Arrays.sort(coordinates, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        for (int i=0; i<N; i++) {
            answer.append(coordinates[i][0]).append(" ").append(coordinates[i][1]).append("\n");
        }
        
        System.out.print(answer);
    }
}
