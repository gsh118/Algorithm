import java.util.*;

class Solution {
    String[] alpha= new String[]{"A","E","I","O","U"};
    List<String> list;
    
    public int solution(String word) {
        list = new ArrayList<String>();
        
        makeWordListRecursive("", 0);
        int answer = list.indexOf(word);   
        return answer;
    }
    
    public void makeWordListRecursive(String cur, int curIdx){  
        list.add(cur);
        
        if(curIdx==5){
            return;
        }
        
        String tmp = new String(cur);
        for (String s:alpha){
            tmp = cur+s;
            makeWordListRecursive(tmp, curIdx+1);
        }
    }
}