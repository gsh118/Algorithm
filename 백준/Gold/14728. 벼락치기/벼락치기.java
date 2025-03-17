import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[] req = new int[n];
        int[] score = new int[n];

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            req[i] = Integer.parseInt(st.nextToken());
            score[i] = Integer.parseInt(st.nextToken());
        }

        ScoreSolve sc = new ScoreSolve(n,t,req,score);
        int result = sc.getMaxScore();

        System.out.println(result);
    }
}

class ScoreSolve{
    int[][] dp;
    int[] req;
    int[] score;

    public ScoreSolve(int n, int t, int[] req, int[] score){
        dp = new int[n][t+1];
        this.req = req;
        this.score = score;
    }

    public int getMaxScore(){
        int n = dp.length;
        int t = dp[0].length-1;

        if(req[0]<=t){
            dp[0][req[0]] = score[0];
        }

        for (int i=1; i<n; i++){
            for (int j=0; j<=t; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - req[i] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - req[i]] + score[i]);
                }
            }
        }

        int max=0;
        for (int i=0; i<=t; i++){
            max = Math.max(dp[n-1][i], max);
        }

        return max;
    }
}