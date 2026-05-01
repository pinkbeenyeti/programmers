import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    private static int H, K, R, answer = 0;
    private static int admins, all;

    private static Employeer[] tree;

    private static class Employeer {

        Queue<Integer> left, right, noAdmin;

        public Employeer() {
            left = new LinkedList<>();
            right = new LinkedList<>();
            noAdmin = new LinkedList<>();
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        admins = (int) (Math.pow(2, H)) - 1;
        all = (int) (Math.pow(2, H + 1)) - 1;

        tree = new Employeer[all + 1];
        for (int i = 1; i <= all; i++) tree[i] = new Employeer();

        for (int i = (admins + 1); i <= all; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= K; j++) {
                tree[i].noAdmin.offer(Integer.parseInt(st.nextToken()));
            }
        }
    }

    private static void process() {
        for (int d = 1; d <= R; d++) {
            if (d % 2 == 1) {
                if (!tree[1].left.isEmpty()) answer += tree[1].left.poll();
            } else {
                if (!tree[1].right.isEmpty()) answer += tree[1].right.poll();
            }

            for (int j = 2; j <= admins; j++) {
                int parent = j / 2;
                Integer task = null;

                if (d % 2 == 1) {
                    if (!tree[j].left.isEmpty()) task = tree[j].left.poll();
                } else {
                    if (!tree[j].right.isEmpty()) task = tree[j].right.poll();
                }

                if (task != null) {
                    if (j % 2 == 0) tree[parent].left.offer(task);
                    else tree[parent].right.offer(task);
                }
            }

            for (int j = admins + 1; j <= all; j++) {
                if (!tree[j].noAdmin.isEmpty()) {
                    int parent = j / 2;
                    int task = tree[j].noAdmin.poll();

                    if (j % 2 == 0) tree[parent].left.offer(task);
                    else tree[parent].right.offer(task);
                }
            }
        }

        System.out.print(answer);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}