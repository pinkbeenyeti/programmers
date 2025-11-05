import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static int N;
    private static char root;
    private static Map<Character, Child> tree;

    private static class Child {
        char left, right;

        public Child(char left, char right) {
            this.left = left;
            this.right = right;
        }
    }

    private static void preDfs(StringBuilder answer, char root) {
        if (root == '.') return;

        answer.append(root);
        preDfs(answer, tree.get(root).left);
        preDfs(answer, tree.get(root).right);
    }

    private static void midDfs(StringBuilder answer, char root) {
        if (root == '.') return;

        midDfs(answer, tree.get(root).left);
        answer.append(root);
        midDfs(answer, tree.get(root).right);
    }

    private static void postDfs(StringBuilder answer, char root) {
        if (root == '.') return;

        postDfs(answer, tree.get(root).left);
        postDfs(answer, tree.get(root).right);
        answer.append(root);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new HashMap<>();

        for (int i=0; i<N; i++) {
            String line = br.readLine();
            Child child = new Child(line.charAt(2), line.charAt(4));

            if (i == 0) root = line.charAt(0);
            tree.put(line.charAt(0), child);
        }
    }

    private static void process() {
        StringBuilder answer1 = new StringBuilder(), answer2 = new StringBuilder(), answer3 = new StringBuilder();

        preDfs(answer1, root);
        midDfs(answer2, root);
        postDfs(answer3, root);

        System.out.println(answer1.toString());
        System.out.println(answer2.toString());
        System.out.println(answer3.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
