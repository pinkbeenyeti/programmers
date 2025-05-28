class Solution {
    private String getByteString(int num, int n) {
        char[] bytes = new char[n];
        for (int i=0; i<n; i++) bytes[i] = '0';
        
        int number = num, diff = 1;
        while (number > 1) {
            bytes[n-diff] = (char)(number%2 + '0');
            number = number/2;
            diff++;
        }
        
        bytes[n-diff] = (char)(number + '0');
        for (int i=0; i<n-diff; i++) {
            bytes[i] = '0';
        }
        
        return String.valueOf(bytes);
    }
    
    private void fillMap(String bytes, char[][] map, int n, int row) {
        for (int i=0; i<n; i++) {
            if (bytes.charAt(i) == '1') {
                map[row][i] = '#';
            }
        }
    }
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        char[][] map = new char[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                map[i][j] = ' ';
            }
        }
        
        for (int i=0; i<n; i++) {
            String bytes1 = getByteString(arr1[i], n);
            String bytes2 = getByteString(arr2[i], n);
            fillMap(bytes1, map, n, i);
            fillMap(bytes2, map, n, i);
        }
        
        String[] answer = new String[n];
        for (int i=0; i<n; i++) {
            answer[i] = String.valueOf(map[i]);
        }
        return answer;
    }
}