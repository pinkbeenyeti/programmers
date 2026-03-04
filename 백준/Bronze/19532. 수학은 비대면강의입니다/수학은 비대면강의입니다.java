import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void equations() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken()), e =Integer.parseInt(st.nextToken()), f = Integer.parseInt(st.nextToken());

        int x = ((b * f) - (c * e)) / ((b * d) - (a * e));
        int y = (c - (a * x)) / b;

        System.out.print(x + " " + y);
    }

    public static void bfs() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken()), e =Integer.parseInt(st.nextToken()), f = Integer.parseInt(st.nextToken());

        for (int x=-999; x<=999; x++) {
            for (int y=-999; y<=999; y++) {
                if (((a * x) + (b * y)) == c && (((d * x) + (e * y)) == f)) {
                    System.out.print(x + " " + y);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        bfs();
    }
}
