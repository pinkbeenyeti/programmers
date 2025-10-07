import java.util.*;

class Solution {
    private Map<String, List<Goal>> map;

    // Goal 클래스는 그대로 유지
    private class Goal implements Comparable<Goal> {
        int index;
        String goal;

        public Goal(int index, String goal) {
            this.index = index;
            this.goal = goal;
        }

        @Override
        public int compareTo(Goal other) {
            return goal.compareTo(other.goal);
        }
    }

    private boolean dfs(Set<Integer> set, List<Integer> answer, Goal current, int limit) {
        if (set.size() == limit) {
            return true;
        }

        // <-- 수정 1: NullPointerException 방지
        // 현재 공항에서 출발하는 티켓이 없는 경우를 확인합니다.
        if (!map.containsKey(current.goal)) {
            return false; // 더 이상 갈 곳이 없으므로 실패
        }

        for (Goal goal : map.get(current.goal)) { // 이제 이 부분은 안전합니다.
            if (!set.contains(goal.index)) {
                set.add(goal.index);
                answer.add(goal.index);

                if (dfs(set, answer, goal, limit)) {
                    return true;
                } else {
                    set.remove(goal.index);
                    answer.remove(answer.size() - 1);
                }
            }
        }

        return false;
    }

    public String[] solution(String[][] tickets) {
        map = new HashMap<>();

        for (int i = 0; i < tickets.length; i++) {
            String[] ticket = tickets[i];
            List<Goal> current;

            if (map.containsKey(ticket[0])) {
                current = map.get(ticket[0]);
            } else {
                current = new LinkedList<>();
            }
            current.add(new Goal(i, ticket[1]));
            // Collections.sort(current); // <-- 비효율적인 정렬은 여기서 제거
            map.put(ticket[0], current);
        }
        
        // <-- 수정 2: 정렬을 모든 티켓을 추가한 후 한 번만 수행
        for (List<Goal> list : map.values()) {
            Collections.sort(list);
        }

        // 이 아래 부분(ICN에서 출발하는 로직)은 기존 구조를 그대로 유지합니다.
        for (Goal goal : map.get("ICN")) {
            Set<Integer> set = new HashSet<>();
            List<Integer> result = new LinkedList<>();

            set.add(goal.index);
            result.add(goal.index);

            if (dfs(set, result, goal, tickets.length)) {
                String[] answer = new String[tickets.length + 1];

                // 결과 배열을 만드는 로직도 그대로 유지
                for (int i = 0; i < result.size(); i++) {
                    answer[i] = tickets[result.get(i)][0];
                }
                answer[answer.length - 1] = tickets[result.get(result.size() - 1)][1];
                return answer;
            }
        }

        return new String[]{"abs"}; // Unreachable, 보존
    }
}