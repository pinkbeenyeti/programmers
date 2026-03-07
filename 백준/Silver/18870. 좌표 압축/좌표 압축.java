import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] compression = new int[N];

        List<Integer> numbers = new ArrayList<>();
        Map<Integer, List<Integer>> count = new HashMap<>();
        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            int target = Integer.parseInt(st.nextToken());

            if (!count.containsKey(target)) {
                numbers.add(target);
            }

            List<Integer> list = count.getOrDefault(target, new ArrayList<>());
            list.add(i);
            count.put(target, list);
        }

        Collections.sort(numbers);

        for (int i=0; i<numbers.size(); i++) {
            for (int coordinate : count.get(numbers.get(i))) {
                compression[coordinate] = i;
            }
        }

        for (int i=0; i<N; i++) {
            answer.append(compression[i]).append(" ");
        }

        System.out.print(answer);
    }
}
