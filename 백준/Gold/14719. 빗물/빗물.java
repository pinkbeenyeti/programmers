import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int H, W, answer = 0;
    private static int[] heights;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        heights = new int[W];

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<W; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        for (int i=1; i<W-1; i++) {
            int currentHeight = heights[i], leftMax = 0, rightMax = 0;

            for (int l = 0; l < i; l++) {
                leftMax = Math.max(leftMax, heights[l]);
            }

            for (int r = i + 1; r < W; r++) {
                rightMax = Math.max(rightMax, heights[r]);
            }

            int waterHeight = Math.min(leftMax, rightMax);

            if (waterHeight > currentHeight) {
                answer += (waterHeight - currentHeight);
            }
        }
        
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
