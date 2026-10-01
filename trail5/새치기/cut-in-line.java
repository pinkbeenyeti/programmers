import java.util.*;
import java.io.*;

public class Main {

    private static class Person {
        int index;
        Person prev, next;

        public Person(int i) {
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

        Person[] persons = new Person[N + 1];
        Person[] lineRoots = new Person[M + 1];

        for (int i = 1; i <= N; i++) {
            persons[i] = new Person(i);
        }

        for (int i = 1; i <= M; i++) {
            lineRoots[i] = new Person(0);
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            Person current = lineRoots[i];

            for (int j = 1; j <= n; j++) {
                int target = Integer.parseInt(st.nextToken());
                Person person = persons[target];

                current.next = person;
                person.prev = current;

                current = person;
            }
        }

        for (int i = 1; i <= Q; i++) {
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());

            int a = Integer.parseInt(st.nextToken());
            int b = (command != 2) ? Integer.parseInt(st.nextToken()) : 0;
            int c = (command == 3) ? Integer.parseInt(st.nextToken()) : 0;


            if (command == 1) {
                Person front = persons[a];
                Person back = persons[b];

                Person fp = front.prev;
                Person fn = front.next;

                Person bp = back.prev;
                
                fp.next = fn;
                if (fn != null) fn.prev = fp;

                bp.next = front;
                front.prev = bp;

                front.next = back;
                back.prev = front;
            }

            if (command == 2) {
                Person home = persons[a];
                Person hp = home.prev;
                Person hn = home.next;

                hp.next = hn;
                if (hn != null) hn.prev = hp;
            }

            if (command == 3) {
                Person start = persons[a];
                Person end = persons[b];
                Person target = persons[c];

                Person rHead = target.prev;
                Person head = start.prev;
                Person tail = end.next;

                head.next = tail;
                if (tail != null) tail.prev = head;

                rHead.next = start;
                start.prev = rHead;

                end.next = target;
                target.prev = end;
            }
        }

        for (int i = 1; i <= M; i++) {
            Person current = lineRoots[i].next;

            if (current == null) 
                answer.append("-1\n");
            else {
                while (current != null) {
                    answer.append(current.index).append(" ");
                    current = current.next;
                }
                answer.append("\n");
            }

        }

        System.out.print(answer);
    }
}