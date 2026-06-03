import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.List;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push_back")) list.add(Integer.parseInt(st.nextToken()));
            else if (command.equals("pop_back")) list.remove(list.size() - 1);
            else if (command.equals("size")) answer.append(list.size()).append("\n");
            else if (command.equals("get")) answer.append(list.get(Integer.parseInt(st.nextToken()) - 1)).append("\n");
        }

        System.out.print(answer);
    }
}