import java.util.*;
import java.io.*;

public class Main {

    private static class Node {
        int num;
        Node prev, next;

        public Node(int num) {
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int Q = Integer.parseInt(st.nextToken());
        int start = 2;

        Map<Integer, Node> map = new HashMap<>();

        map.put(0, new Node(0));
        map.put(1, new Node(1));

        map.get(0).next = map.get(1);
        map.get(1).prev = map.get(0);

        for (int i = 1; i <= Q; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            
            if (command == 1) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                Node head = map.get(a);
                Node tail = head.next;
                
                Node prev = head;
                Node current = null;

                for (int j = start; j < start + b; j++) {
                    current = new Node(j);

                    prev.next = current;
                    current.prev = prev;

                    prev = current;
                    map.put(j, current);
                }

                current.next = tail;
                if (tail != null) tail.prev = current;
                start += b;
            }

            if (command == 2) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                Node tail = map.get(a);
                Node head = tail.prev;
                
                Node prev = head;
                Node current = null;

                for (int j = start; j < start + b; j++) {
                    current = new Node(j);

                    prev.next = current;
                    current.prev = prev;

                    prev = current;
                    map.put(j, current);
                }

                current.next = tail;
                tail.prev = current;
                start += b;
            }

            if (command == 3) {
                int a = Integer.parseInt(st.nextToken());
                Node node = map.get(a);
                
                if (node.prev == null || node.next == null || node.prev.num == 0 || node.next.num == 0) {
                    answer.append(-1);
                }
                else {
                    answer.append(node.prev.num + " " + node.next.num);
                }

                answer.append("\n");
            }
        }
        
        // Node current = map.get(0);
        // while (current != null) {
        //     System.out.print(current.next.num + " ");
        //     current = current.next;
        // }
        
        System.out.print(answer);
    }
}