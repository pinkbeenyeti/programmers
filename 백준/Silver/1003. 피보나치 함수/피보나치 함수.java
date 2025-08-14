import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static int[] dpZero = new int[41];
    static int[] dpOne = new int[41];
    static Queue<Integer> userInput = new LinkedList<>();

    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            userInput.add(Integer.parseInt(st.nextToken()));
        }

        br.close();
    }

    private static void process() {
        dpZero[0] = 1;
        dpOne[1] = 1;

        for (int i=2; i<41; i++) {
            dpZero[i] = dpZero[i - 1] + dpZero[i - 2];
            dpOne[i] = dpOne[i - 1] + dpOne[i - 2];
        }

        while (!userInput.isEmpty()) {
            int n = userInput.poll();
            System.out.println(dpZero[n] + " " + dpOne[n]);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
