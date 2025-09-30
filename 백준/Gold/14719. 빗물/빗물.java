import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int H, W, answer = 0;
    private static int[] width;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        width = new int[W];

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<W; i++) {
            width[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        for (int w=0; w<H; w++) {
            for (int i=0; i<W; i++) {
                if (i > 0 && i < (W - 1) && width[i] < 1 && width[i - 1] > 0) {
                    int index = i, water = 0;

                    while (index < W && width[index] < 1) {
                        water++;
                        index++;
                    }

                    if (index < W){
                        answer += water;
                    }
                }
            }

            for (int i=0; i<W; i++) {
                width[i]--;
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
