import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        List<String> list = new LinkedList<>();
        Set<String> set = new HashSet<>();

        for (int i=0; i<N; i++) {
            String target = br.readLine();

            if (set.contains(target)) continue;
            else {
                list.add(target);
                set.add(target);
            }
        }

        list.sort((a, b) -> a.length() == b.length() ? a.compareTo(b) : a.length() - b.length());

        for (String s : list) {
            answer.append(s).append("\n");
        }

        System.out.print(answer);
    }
}
