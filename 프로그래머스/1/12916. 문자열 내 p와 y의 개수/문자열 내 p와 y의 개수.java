class Solution {
    boolean solution(String s) {
        char[] tmp = s.toLowerCase().toCharArray();
        
        int pcnt=0;
        int scnt=0;
        for (char c:tmp){
            if(c=='p'){
                pcnt++;
            } else if (c=='y'){
                scnt++;
            }
        }
        return pcnt==scnt;
    }
}