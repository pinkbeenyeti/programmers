import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<N; i++) {
            String target = br.readLine();

            try {
                int command = Integer.parseInt(target);

                switch (command) {
                    case 2:
                        answer.append((stack.isEmpty()) ? -1 : stack.pop()).append("\n");
                        break;

                    case 3:
                        answer.append(stack.size()).append("\n");
                        break;

                    case 4:
                        answer.append((stack.isEmpty()) ? 1 : 0).append("\n");
                        break;

                    case 5:
                        answer.append((stack.isEmpty()) ? -1 : stack.peek()).append("\n");
                        break;
                }
            } catch (Exception e) {
                String[] splited = target.split(" ");
                stack.push(Integer.parseInt(splited[1]));
            }
        }

        System.out.print(answer);
    }
}
