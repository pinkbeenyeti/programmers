import java.util.*;

class Solution {
    long minX = Long.MAX_VALUE, maxX = Long.MIN_VALUE;
    long minY = Long.MAX_VALUE, maxY = Long.MIN_VALUE;

    private void updateBounds(long x, long y) {
        minX = Math.min(minX, x);
        maxX = Math.max(maxX, x);
        minY = Math.min(minY, y);
        maxY = Math.max(maxY, y);
    }

    private void addIntersection(List<long[]> points, Set<String> seen, int[] line1, int[] line2) {
        long A = line1[0], B = line1[1], E = line1[2];
        long C = line2[0], D = line2[1], F = line2[2];

        long det = A * D - B * C;
        if (det == 0) return;  // 평행하거나 일치

        long xNumer = B * F - E * D;
        long yNumer = E * C - A * F;

        if (xNumer % det != 0 || yNumer % det != 0) return;

        long x = xNumer / det;
        long y = yNumer / det;

        String key = x + "," + y;
        if (seen.add(key)) {  // 중복 방지
            points.add(new long[]{x, y});
            updateBounds(x, y);
        }
    }

    public String[] solution(int[][] line) {
        List<long[]> points = new ArrayList<>();
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                addIntersection(points, seen, line[i], line[j]);
            }
        }

        int width = (int)(maxX - minX + 1);
        int height = (int)(maxY - minY + 1);

        char[][] map = new char[height][width];
        for (char[] row : map) Arrays.fill(row, '.');

        for (long[] point : points) {
            int x = (int)(point[0] - minX);      // 열
            int y = (int)(maxY - point[1]);      // 행 (y축은 위로 갈수록 작아짐)
            map[y][x] = '*';
        }

        String[] result = new String[height];
        for (int i = 0; i < height; i++) {
            result[i] = new String(map[i]);
        }

        return result;
    }
}
