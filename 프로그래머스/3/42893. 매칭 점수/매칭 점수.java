import java.util.Map;
import java.util.HashMap;

import java.util.List;
import java.util.ArrayList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution { 
    private class Page {
        String url;
        List<String> exLinks;
        
        int index, basicScore = 0;
        double linkScore = 0;
        
        public Page(int index, String url) {
            this.index = index;
            this.url = url;
            this.exLinks = new ArrayList<>();
        }
    }
    
    private void excludeInfos(String word, String[] pages, Map<String, Page> pageMap) {
        int index = 0;
        
        Pattern myUrlPattern = Pattern.compile("<meta property=\"og:url\" content=\"(.*?)\"/>");
        Pattern exLinkPattern = Pattern.compile("<a href=\"(.*?)\">");
        Pattern wordPattern = Pattern.compile("(?<![a-zA-Z])" + word + "(?![a-zA-Z])", Pattern.CASE_INSENSITIVE);
        
        for (String page : pages) {
            Matcher myUrlMatcher = myUrlPattern.matcher(page);
            Matcher exLinkMatcher = exLinkPattern.matcher(page);
            Matcher wordMatcher = wordPattern.matcher(page.split("<body>")[1].split("</body>")[0].toLowerCase());
            
            if (myUrlMatcher.find()) {
                String url = myUrlMatcher.group(1);
                Page pg = new Page(index, url);
                
                while (exLinkMatcher.find()) {
                    pg.exLinks.add(exLinkMatcher.group(1));
                }
                
                while (wordMatcher.find()) {
                    pg.basicScore++;
                }
                
                pageMap.put(url, pg);
                index++;
            }
        }
    }
    
    private void calculateLinkScore(Map<String, Page> pageMap) {
        for (String url : pageMap.keySet()) {
            Page page = pageMap.get(url);
            
            if (page.exLinks.size() > 0) {
                double giveScore = (double) page.basicScore / page.exLinks.size();
                
                for (String exLink : page.exLinks) {
                    if (pageMap.containsKey(exLink)) {
                        pageMap.get(exLink).linkScore += giveScore;
                    }
                }
            }
        }
    }
    
    private int process(String word, String[] pages) {
        Map<String, Page> pageMap = new HashMap<>();
        
        double maxScore = -1;
        int answer = -1;
        
        excludeInfos(word.toLowerCase(), pages, pageMap);
        calculateLinkScore(pageMap);
        
        for (String url : pageMap.keySet()) {
            Page page = pageMap.get(url);
            
            if (page.basicScore + page.linkScore > maxScore) {
                maxScore = page.basicScore + page.linkScore;
                answer = page.index;
            } else if (page.basicScore + page.linkScore == maxScore) {
                answer = Math.min(answer, page.index);
            }
        }
        
        return answer;
    }
    
    public int solution(String word, String[] pages) {
        return process(word, pages);
    }
}