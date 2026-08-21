import java.util.*;
import java.io.*;

public class Main {

    private static class Event {
        int x, y, type, qid;

        public Event(int x, int y, int type, int qid) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.qid = qid;
        }
    }

    private static class Fenwick {
        int[] tree;
        int n;

        public Fenwick(int size) {
            this.tree = new int[size + 1];
            n = size;
        }

        public void update(int i, int value) {
            for (; i <= n; i += (i & -i)) {
                tree[i] += value;
            }
        }

        public int query(int i) {
            int sum = 0;

            for (; i > 0; i -= (i & -i)) {
                sum += tree[i];
            }

            return sum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        
        List<Event> events = new ArrayList<>();

        TreeSet<Integer> treeX = new TreeSet<>();
        TreeSet<Integer> treeY = new TreeSet<>();
        
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            events.add(new Event(x, y, 0, -1));

            treeX.add(x);
            treeY.add(y);
        }

        for (int i = 1; i <= Q; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken());

            events.add(new Event(x1 - 1, y1 - 1, 1, i));
            events.add(new Event(x1 - 1, y2, -1, i));
            events.add(new Event(x2, y1 - 1, -1, i));
            events.add(new Event(x2, y2, 1, i));

            treeX.add(x1 - 1);
            treeX.add(x1);
            treeX.add(x2);

            treeY.add(y1 - 1);
            treeY.add(y1);
            treeY.add(y2);
        }

        Collections.sort(events, (a, b) -> {
            if (a.x == b.x) 
                return Integer.compare(Math.abs(a.type), Math.abs(b.type));
            else
                return Integer.compare(a.x, b.x);
        });

        Map<Integer, Integer> mapX = new HashMap<>();
        Map<Integer, Integer> mapY = new HashMap<>();

        int countX = 1;
        int countY = 1;

        for (int x : treeX) {
            mapX.put(x, countX);
            countX++;
        }

        for (int y : treeY) {
            mapY.put(y, countY);
            countY++;
        } 

        Fenwick fenwick = new Fenwick(treeY.size());
        long[] answers = new long[Q + 1];

        for (Event event : events) {
            event.x = mapX.get(event.x);
            event.y = mapY.get(event.y);

            if (event.type == 0)
                fenwick.update(event.y, 1);
            else
                answers[event.qid] += (long) event.type * fenwick.query(event.y);
        }

        for (int i = 1; i <= Q; i++) {
            answer.append(answers[i]).append("\n");
        }

        System.out.print(answer);
    }
        
}