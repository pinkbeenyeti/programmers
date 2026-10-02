import java.io.*;
import java.util.*;

public class Main {

    private static class Book {
        int index;
        Book prev, next;

        public Book(int index) {
            this.index = index;
        }
    }

    private static void unlink(Book first, Book last) {
        first.prev.next = last.next;
        last.next.prev = first.prev;
    }

    private static void insertAfter(Book target, Book first, Book last) {
        last.next = target.next;
        target.next.prev = last;

        target.next = first;
        first.prev = target;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(br.readLine());

        Book[] head = new Book[K + 1];
        Book[] tail = new Book[K + 1];

        for (int i = 1; i <= K; i++) {
            head[i] = new Book(0);
            tail[i] = new Book(0);
            head[i].next = tail[i];
            tail[i].prev = head[i];
        }

        Book current = head[1];
        for (int i = 1; i <= N; i++) {
            Book book = new Book(i);
            insertAfter(current, book, book);
            current = book;
        }

        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            if (head[i].next == tail[i]) {
                continue;
            }

            if (command == 1) {
                Book a = head[i].next;
                unlink(a, a);
                insertAfter(tail[j].prev, a, a);
            }

            if (command == 2) {
                Book a = tail[i].prev;
                unlink(a, a);
                insertAfter(head[j], a, a);
            }
            
            if (command == 3) {
                if (i == j) continue;
                Book first = head[i].next;
                Book last = tail[i].prev;
                unlink(first, last);
                insertAfter(head[j], first, last);
            }
            
            if (command == 4) {
                if (i == j) continue;
                Book first = head[i].next;
                Book last = tail[i].prev;
                unlink(first, last);
                insertAfter(tail[j].prev, first, last);
            }
        }

        for (int i = 1; i <= K; i++) {
            int count = 0;
            StringBuilder sb = new StringBuilder();
            Book cur = head[i].next;

            while (cur != tail[i]) {
                count++;
                sb.append(" ").append(cur.index);
                cur = cur.next;
            }

            answer.append(count).append(sb).append("\n");
        }

        System.out.print(answer);
    }
}