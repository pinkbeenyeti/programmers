import java.io.*;
import java.util.*;

public class Main {

    private static class Node {
        int number;
        Node l, r;

        public Node(int number) {
            this.number = number;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Map<Integer, Node> nodes = new HashMap<>();

        Node root = new Node(Integer.parseInt(st.nextToken()));
        Node prev = root;

        nodes.put(root.number, root);

        for (int i = 2; i <= N; i++) {
            Node current = new Node(Integer.parseInt(st.nextToken()));
            nodes.put(current.number, current);

            prev.r = current;
            current.l = prev;

            prev = current;
        }

        root.l = prev;
        prev.r = root;

        for (int i = 0; i < M; i++) {
            int leave = Integer.parseInt(br.readLine());

            Node node = nodes.get(leave);
            Node nodeL = node.l;
            Node nodeR = node.r;

            nodeL.r = nodeR;
            nodeR.l = nodeL;

            answer.append(node.r.number + " " + node.l.number).append("\n");
        }

        System.out.print(answer);
    }
}