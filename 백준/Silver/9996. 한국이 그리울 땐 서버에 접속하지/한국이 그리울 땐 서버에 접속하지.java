import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    private static int N;
    private static Queue<String> qu;
    private static Pattern pattern;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        qu = new LinkedList<>();

        String[] splited = br.readLine().split("\\*");
        pattern = Pattern.compile("^" + splited[0] + "[a-z]*" + splited[1] + "$");

        for (int i=0; i<N; i++) {
            qu.offer(br.readLine());
        }
    }

    private static void process() {
        StringBuilder answer = new StringBuilder();

        while(!qu.isEmpty()) {
            String str = qu.poll();
            Matcher matcher = pattern.matcher(str);

            if (matcher.find()) {
                answer.append("DA").append("\n");
            } else {
                answer.append("NE").append("\n");
            }
        }

        System.out.println(answer.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
