import java.io.*;
import java.util.*;

public class Main {

    private static class Node {
        String city;
        Node l, r;

        public Node(String city) {
            this.city = city;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Node root = new Node(st.nextToken());
        Node current = root;

        for (int i = 2; i <= N; i++) {
            Node next = new Node(st.nextToken());

            current.r = next;
            next.l = current;

            current = next;
        }

        current.r = root;
        root.l = current;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());

            if (command == 1 && root.r != null) 
                root = root.r;
            else if (command == 2 && root.l != null)
                root = root.l;
            else if (command == 3 && root.r != root) {
                root.r = root.r.r;
                root.r.l = root;
            }
            else {
                Node newNode = new Node(st.nextToken());
                Node next = root.r;

                newNode.r = next;
                newNode.l = root;

                root.r = newNode;
                next.l = newNode;
            }

            if (root.r == root.l) 
                answer.append(-1).append("\n");
            else
                answer.append(root.l.city + " " + root.r.city).append("\n");
        }

        System.out.print(answer);
    }
}