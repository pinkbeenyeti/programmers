import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static int N;
    private static Queue<String> qu;

    private static Pattern pattern;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        qu = new LinkedList<>();

        for (int i=0; i<N; i++) {
            qu.offer(br.readLine());
        }
    }

    private static void process() {
        StringBuilder stb = new StringBuilder();
        pattern = Pattern.compile("^[ABCDEF]?[A]+[F]+[C]+[ABCDEF]?$");

        while (!qu.isEmpty()) {
            Matcher matcher = pattern.matcher(qu.poll());

            if (matcher.find()) {
                stb.append("Infected!").append("\n");
            } else {
                stb.append("Good").append("\n");
            }
        }

        System.out.println(stb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
