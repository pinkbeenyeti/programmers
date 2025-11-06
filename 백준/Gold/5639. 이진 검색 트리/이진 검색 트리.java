import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static StringBuilder answer;
    private static Queue<Integer> numbers;
    private static Node root;

    private static class Node {
        Node left, right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    private static void dfs(Node current) {
        if (current.left != null) dfs(current.left);
        if (current.right != null) dfs(current.right);

        answer.append(current.value).append("\n");
    }

    private static void process() {
        if (numbers.isEmpty()) {
            return;
        }

        root = new Node(numbers.poll());
        answer = new StringBuilder();

        while (!numbers.isEmpty()) {
            int number = numbers.poll();
            Node current = root, parent = null;

            while (current != null) {
                parent = current;
                if (current.value < number) current = current.right;
                else current = current.left;
            }

            if (parent.value < number) parent.right = new Node(number);
            else parent.left = new Node(number);
        }

        dfs(root);
        System.out.println(answer.toString());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numbers = new LinkedList<>();
        String line;

        while ((line = br.readLine()) != null && !line.isEmpty()) {
            numbers.offer(Integer.parseInt(line));
        }

        br.close();
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
