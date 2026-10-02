import java.util.*;
import java.io.*;

public class Main {

    private static class Man {
        int index;
        Man prev, next;

        public Man(int i) {
            this.index = i;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        Map<Integer, Man> map = new HashMap<>();

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int count = Integer.parseInt(st.nextToken());

            Man root = new Man(0);
            root.next = root;
            root.prev = root;
            Man current = root;

            for (int j = 1; j <= count; j++) {
                int target = Integer.parseInt(st.nextToken());
                map.put(target, new Man(target));
                insertAfter(current, map.get(target));
                current = map.get(target);
            }

            remove(root);
        }

        for (int i = 1; i <= Q; i++) {
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = (command != 3) ? Integer.parseInt(st.nextToken()) : 0;

            if (command == 1) {
                insertCircle(map.get(a), map.get(b));                
            }
            
            if (command == 2) {
                splitCircle(map.get(a), map.get(b));
            }

            if (command == 3) {
                Man root = map.get(a);
                Man minMan = root;
                Man current = root.next;

                while (current != root) {
                    if (current.index < minMan.index) {
                        minMan = current;
                    }
                    current = current.next;
                }

                current = minMan;
                do {
                    answer.append(current.index).append(" ");
                    current = current.prev;
                } while (current != minMan);

                answer.append("\n");
            }
        }

        System.out.print(answer);
    }

    private static void insertAfter(Man first, Man second) {
        second.prev = first;
        second.next = first.next;

        first.next.prev = second;
        first.next = second;
    }

    private static void insertCircle(Man first, Man second) {
        first.next.prev = second.prev;
        second.prev.next = first.next;

        first.next = second;
        second.prev = first;
    }

    private static void splitCircle(Man first, Man second) {
    Man firstPrev = first.prev;
    Man secondPrev = second.prev;

    firstPrev.next = second;
    second.prev = firstPrev;

    secondPrev.next = first;
    first.prev = secondPrev;
}

    private static void remove(Man target) {
        target.prev.next = target.next;
        target.next.prev = target.prev;
    }
}