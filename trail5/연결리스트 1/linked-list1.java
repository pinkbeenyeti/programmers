import java.io.*;
import java.util.*;

public class Main {

    private static class Node {
        String value;
        Node prev, next;

        public Node(String value) {
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        Node current = new Node(st.nextToken());
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());

            if (command == 1){
                Node newNode = new Node(st.nextToken());

                newNode.prev = current.prev;
                newNode.next = current;
                
                if (current.prev != null) current.prev.next = newNode;
                current.prev = newNode;
            }
            else if (command == 2) {
                Node newNode = new Node(st.nextToken());

                newNode.prev = current;
                newNode.next = current.next;

                if (current.next != null) current.next.prev = newNode;
                current.next = newNode;
            }
            else if (command == 3)
                current = (current.prev == null) ? current : current.prev;
            else
                current = (current.next == null) ? current : current.next;
            
            String prev = (current.prev == null) ? "(Null)" : current.prev.value;
            String next = (current.next == null) ? "(Null)" : current.next.value;

            answer.append(prev + " " + current.value + " " + next).append("\n");
        }

        System.out.print(answer);
    }
}