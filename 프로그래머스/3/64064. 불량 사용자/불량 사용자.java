import java.util.*;

class Solution {
    Set<Set<Integer>> result = new HashSet<>();
    int banSize;
    
    private boolean fillDB(String ban, String user) {
        if(ban.length() != user.length()) return false;
        
        for(int i=0; i<ban.length(); i++) {
            if(ban.charAt(i) == '*') continue;
            if(ban.charAt(i) != user.charAt(i)) return false;
        }
        
        return true;
    }
    
    private void dfs(ArrayList<ArrayList<Integer>> db, int depth, Set<Integer> set) {
        if(depth == db.size()) {
            if (set.size() == banSize) result.add(new HashSet<>(set));
            return;
        }
        
        for(int index : db.get(depth)) {
            if(!set.contains(index)) {
                set.add(index);
                dfs(db, depth+1, set);
                set.remove(index);
            }
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        ArrayList<ArrayList<Integer>> db = new ArrayList<>();
        banSize = banned_id.length;
        
        for(int i=0; i<banSize; i++) {
            ArrayList<Integer> userIds = new ArrayList<>();
            for(int j=0; j<user_id.length; j++) {
                boolean isBanned = fillDB(banned_id[i], user_id[j]);
                if(isBanned) userIds.add(j);
            }
            db.add(userIds);
        }
        
        dfs(db, 0, new HashSet<>());
        
        return result.size();
    }
}