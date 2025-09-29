import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder answer = new StringBuilder();
    private static int[] heights = new int[21];

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i=1; i<=T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(st.nextToken()), result = 0;
            answer.append(number).append(" ");

            for (int s=1; s<=20; s++) {
                int height = Integer.parseInt(st.nextToken());
                heights[s] = height;

                for (int nowLine=(s-1); nowLine>0; nowLine--) {
                    if (heights[nowLine] > heights[nowLine + 1]) {
                        heights[nowLine + 1] = heights[nowLine];
                        heights[nowLine] = height;
                        result++;
                    } else {
                        break;
                    }
                }
            }

            answer.append(result).append("\n");
        }

        System.out.println(answer.toString());
    }

    public static void main(String[] args) throws IOException {
        process();
    }
}
