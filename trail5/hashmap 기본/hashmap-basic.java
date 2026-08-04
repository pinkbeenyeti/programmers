import java.io.*;
import java.util.*;

public class Main {

    private static StringBuilder answer = new StringBuilder();
    private static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            String key = st.nextToken();

            process(command, key, st);
        }

        System.out.print(answer);
    }

    private static void process(String command, String key, StringTokenizer st) throws IOException {
        if (command.equals("add")) map.put(key, st.nextToken());
        else if (command.equals("find")) answer.append(map.getOrDefault(key, "None")).append("\n");
        else map.remove(key);
    }
}