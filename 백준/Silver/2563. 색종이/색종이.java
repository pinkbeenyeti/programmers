import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void arraySolution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()), answer = 0;
        int[][] plane = new int[101][101];

        for (int i=0; i<N; i++) {
            String[] spot = br.readLine().split(" ");

            int X = Integer.parseInt(spot[0]);
            int Y = Integer.parseInt(spot[1]);

            for (int x=X; x<X+10; x++) {
                for (int y=Y; y<Y+10; y++) {
                    plane[y][x] = 1;
                }
            }
        }

        for (int i=1; i<=100; i++) {
            for (int j=1; j<=100;j++) {
                answer += plane[i][j];
            }
        }

        System.out.print(answer);
    }

    public static void minMaxSolution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()), overlap = 0;
        int[][] papers = new int[N][2];

        for (int i=0; i<N; i++) {
            String[] spot = br.readLine().split(" ");

            papers[i][0] = Integer.parseInt(spot[0]);
            papers[i][1] = Integer.parseInt(spot[1]);
        }

        for (int i=0; i<N; i++) {
            for (int j=i+1; j<N; j++) {
                if (Math.abs(papers[i][0] - papers[j][0]) >= 10 || Math.abs(papers[i][1] - papers[j][1]) >= 10) {
                    continue;
                }

                int minX = Math.max(papers[i][0], papers[j][0]), minY = Math.max(papers[i][1], papers[j][1]);
                int maxX = Math.min(papers[i][0], papers[j][0]) + 10, maxY = Math.min(papers[i][1], papers[j][1]) + 10;

                overlap += (maxX - minX) * (maxY - minY);
            }
        }

        System.out.print(N * 100 - overlap);
    }

    public static void main(String[] args) throws IOException {
        arraySolution();
    }
}
