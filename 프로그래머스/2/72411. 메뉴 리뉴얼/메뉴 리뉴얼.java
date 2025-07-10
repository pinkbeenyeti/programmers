import java.util.*;

class Solution {
    Map<String, Integer> allCourse = new HashMap<>();
    int[] maxCount;
    
    private void combination(StringBuilder str, char[] array, int start, int number) {
        if (str.length() == number) {
            String course = str.toString();
            int count = allCourse.getOrDefault(course, 0) + 1;
            
            allCourse.put(course, count);
            maxCount[number] = Math.max(maxCount[number], count);
            
            return;
        }
        
        for (int i=start; i<array.length; i++) {
            str.append(array[i]);
            combination(str, array, i + 1, number);
            str.deleteCharAt(str.length() - 1);
        }
    }
    
    private void makeCourse(int number, String order) {
        char[] array = order.toCharArray();
        Arrays.sort(array);
        combination(new StringBuilder(), array, 0, number);
    }
    
    public String[] solution(String[] orders, int[] course) {
        maxCount = new int[11];
        
        for (int number : course) {
            for (String order : orders) {
                if (order.length() >= number) makeCourse(number, order);
            }
        }
        
        List<String> result = new ArrayList<>();
        for (String key : allCourse.keySet()) {
            if (maxCount[key.length()] > 1 && allCourse.get(key) == maxCount[key.length()]) {
                result.add(key);
            }
        }
        
        Collections.sort(result);
        return result.toArray(new String[0]);
    }
}