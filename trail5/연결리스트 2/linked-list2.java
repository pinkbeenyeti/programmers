import java.util.*;
import java.io.*;

public class Main {

    private static class Node {
        int num;
        Node l, r;

        public Node(int num) {
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(br.readLine());

        Map<Integer, Node> map = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            map.put(i, new Node(i));
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());

            if (command == 1) {
                int num = Integer.parseInt(st.nextToken());

                Node node = map.get(num);
                Node l = node.l;
                Node r = node.r;

                if (l != null) {
                    l.r = r;
                }

                if (r != null) {
                    r.l = l;
                }

                node.l = null;
                node.r = null;
            }

            if (command == 2) {
                int back = Integer.parseInt(st.nextToken());
                int front = Integer.parseInt(st.nextToken());

                Node b = map.get(back);
                Node a = map.get(front);

                Node head = b.l;

                if (head != null) head.r = a;
                a.l = head;
                a.r = b;
                b.l = a;
            }

            if (command == 3) {
                int front = Integer.parseInt(st.nextToken());
                int back = Integer.parseInt(st.nextToken());

                Node a = map.get(front);
                Node b = map.get(back);

                Node third = a.r;
                Node tail = b.r;

                a.r = b;
                b.l = a;
                b.r = third;

                if (third != null) {
                    third.l = b;

                }
            }

            if (command == 4) {
                int target = Integer.parseInt(st.nextToken());

                Node node = map.get(target);

                int a = node.l == null ? 0 : node.l.num;
                int b = node.r == null ? 0 : node.r.num;

                answer.append(a + " " + b).append("\n");
            }
        }

        for (int i = 1; i <= N; i++) {
            Node node = map.get(i);
            answer.append(node.r == null ? 0 : node.r.num).append(" ");
        }

        System.out.print(answer);
    }
}