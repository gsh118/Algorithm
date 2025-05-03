class Solution {
    int[][] dp;
    boolean[][] visit;
    int[][] m;
    
    public int solution(int[][] matrix_sizes) {
        m = matrix_sizes;
        int answer = 0;
        
        initDp();

        answer=getMax(0,m.length-1);
        return answer;
    }
    
    public void initDp(){
        int len = m.length;
        dp = new int[len][len];
        visit = new boolean[len][len];
        
        for (int i=0; i<len; i++){
            visit[i][i]=true;
        }
    }
    
    public int getMax(int i, int j){
        if(visit[i][j])
            return dp[i][j];
        
        dp[i][j] = 2000000000;
        
        for(int k=i; k<j; k++){
            dp[i][j] = Math.min(dp[i][j],
                               getMax(i,k)+getMax(k+1,j)+getMidMultiplyNum(i,k,j));
        }
        
        visit[i][j]=true;
        return dp[i][j];
    }
    
    public int getMidMultiplyNum(int a, int b, int c){
        return m[a][0]*m[b][1]*m[c][1];
    }
}