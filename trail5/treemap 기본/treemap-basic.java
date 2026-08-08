import java.util.*;
import java.io.*;

public class Main {

    private static Map<Integer, Integer> map = new TreeMap<>();
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            process(command, st);
        }

        System.out.print(answer);
    }

    private static void process(String command, StringTokenizer st) throws IOException {
        if (command.equals("add")) 
            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        else if (command.equals("find")) {
            int key = Integer.parseInt(st.nextToken());
            answer.append(map.containsKey(key) ? map.get(key) : "None").append("\n");
        }
        else if (command.equals("remove"))
            map.remove(Integer.parseInt(st.nextToken()));
        else {
            if (map.isEmpty()) answer.append("None");
            for (int key : map.keySet()) {
                answer.append(map.get(key)).append(" ");
            }
            answer.append("\n");
        }
    }
}