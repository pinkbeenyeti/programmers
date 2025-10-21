class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0, left = 1, wifiRange = w * 2 + 1;

        for (int right : stations) {
            int buildingRange = (right - w) - left;
            
            if (buildingRange > 0) { 
                int count = buildingRange / wifiRange, plus = buildingRange % wifiRange;
                answer += (plus == 0) ? count : count + 1;
            }
            
            left = right + w + 1;
        }
        
        if (left <= n) {
            int buildingRange = n - left + 1;
            int count = buildingRange / wifiRange, plus = buildingRange % wifiRange;
            
            answer += (plus == 0) ? count : count + 1;
        }

        return answer;
    }
}