import java.util.*;

class Solution {
    
    int cnt;
    int[] currentList;
    int[] ans;
    int[][] q;
    
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        this.ans=ans;
        currentList = new int[5];
        this.q=q;
        
        Set<Integer> s = new HashSet<>();
        for (int[] arr:q){
            for (int e:arr){
                s.add(e);
            }
        }

        
        makeCombAndCheck(n, 0, 0);
        return cnt;
    }
    
    
    public void makeCombAndCheck(int n, int idx, int prevIdx){
        // 5개의 조합을 만들어내기
        if(idx==5){
            check();
            return;
        }
        
        
        for (int i=prevIdx+1; i<=n; i++){
            currentList[idx]=i;
            makeCombAndCheck(n, idx+1, i);
        }
    }
    
    
    
    void check(){
        for (int i=0; i<q.length; i++){
            //q[i]   currentList 배열 비교
            int matchCnt=getMatchCount(q[i], currentList);
            
            if(matchCnt!=ans[i]){
                return;
            }   
        }
        cnt++;
    }
    
    int getMatchCount(int[] a, int[] b){
        int cnt=0;
        for (int e1:a){
            for (int e2:b){
                if(e1==e2)
                    cnt++;
            }
        }
        
        return cnt;
    }
}