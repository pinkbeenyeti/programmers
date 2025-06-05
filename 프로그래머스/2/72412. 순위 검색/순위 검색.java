import java.util.*;

class Solution {
    static class Node {
        Map<String, Node> children = new HashMap<>();
        List<Integer> scores = new ArrayList<>();
    }

    Node root = new Node();

    private void insert(String[] info, int score) {
        insertRecursive(root, info, 0, score);
    }

    private void insertRecursive(Node node, String[] info, int depth, int score) {
        if (depth == 4) {
            node.scores.add(score);
            return;
        }

        String key = info[depth];

        // 실제 값 추가
        node.children.computeIfAbsent(key, k -> new Node());
        insertRecursive(node.children.get(key), info, depth + 1, score);

        // "-" 조건 대응: 와일드카드도 추가
        node.children.computeIfAbsent("-", k -> new Node());
        insertRecursive(node.children.get("-"), info, depth + 1, score);
    }

    private int search(Node node, String[] query, int depth, int score) {
        if (node == null) return 0;
        if (depth == 4) {
            List<Integer> list = node.scores;
            // 이진 탐색
            int left = 0, right = list.size();
            while (left < right) {
                int mid = (left + right) / 2;
                if (list.get(mid) < score) left = mid + 1;
                else right = mid;
            }
            return list.size() - left;
        }

        return search(node.children.get(query[depth]), query, depth + 1, score);
    }

    public int[] solution(String[] info, String[] query) {
        for (String str : info) {
            String[] split = str.split(" ");
            String[] keys = Arrays.copyOf(split, 4);
            int score = Integer.parseInt(split[4]);
            insert(keys, score);
        }

        // ⚠️ 모든 노드에서 scores 정렬 (단 1회만)
        sortAllScores(root);

        int[] answer = new int[query.length];

        for (int i = 0; i < query.length; i++) {
            String[] parts = Arrays.stream(query[i].split(" "))
                    .filter(s -> !s.equals("and"))
                    .toArray(String[]::new);
            String[] keys = Arrays.copyOf(parts, 4);
            int score = Integer.parseInt(parts[4]);

            answer[i] = search(root, keys, 0, score);
        }

        return answer;
    }

    // 모든 노드의 scores 정렬
    private void sortAllScores(Node node) {
        if (node == null) return;
        Collections.sort(node.scores);
        for (Node child : node.children.values()) {
            sortAllScores(child);
        }
    }
}
