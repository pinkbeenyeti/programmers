import java.io.*;
import java.util.*;

public class Main {

    private static class Node {
        int number;
        Node prev, next;

        public Node(int number) {
            this.number = number;
        }
    }

    private static void connect(Node left, Node right) {
        if (left != null) left.next = right;
        if (right != null) right.prev = left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[N + 1];

        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 1; i < N; i++) {
            connect(nodes[i], nodes[i + 1]);
        }

        Node head = new Node(-1);
        Node tail = new Node(-1);

        connect(head, nodes[1]);
        connect(nodes[N], tail);

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            Node nodeA = nodes[a];
            Node nodeB = nodes[b];
            Node nodeC = nodes[c];
            Node nodeD = nodes[d];

            Node aPrev = nodeA.prev;
            Node bNext = nodeB.next;
            Node cPrev = nodeC.prev;
            Node dNext = nodeD.next;

            // 1. [a, b] 바로 뒤에 [c, d]가 붙어있는 경우
            if (nodeB.next == nodeC) {
                connect(aPrev, nodeC);
                connect(nodeD, nodeA);
                connect(nodeB, dNext);
            }
            // 2. [c, d] 바로 뒤에 [a, b]가 붙어있는 경우
            else if (nodeD.next == nodeA) {
                connect(cPrev, nodeA);
                connect(nodeB, nodeC);
                connect(nodeD, bNext);
            }
            // 3. 두 구간이 서로 떨어져 있는 경우
            else {
                connect(aPrev, nodeC);
                connect(nodeD, bNext);

                connect(cPrev, nodeA);
                connect(nodeB, dNext);
            }
        }

        Node current = head.next;

        while (current != tail) {
            answer.append(current.number).append(" ");
            current = current.next;
        }

        System.out.print(answer);
    }
}