import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(a -> a[0]));

        int cameraCount = 0;
        int currentStart = routes[0][0];
        int currentEnd = routes[0][1];

        for (int i = 1; i < routes.length; i++) {
            int nextStart = routes[i][0];
            int nextEnd = routes[i][1];

            if (nextStart <= currentEnd) {
                currentStart = Math.max(currentStart, nextStart);
                currentEnd = Math.min(currentEnd, nextEnd);
            } else {
                cameraCount++;
                currentStart = nextStart;
                currentEnd = nextEnd;
            }
        }

        // 마지막 구간에 대해서도 카메라 하나 추가
        cameraCount++;

        return cameraCount;
    }
}
