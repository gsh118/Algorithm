import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j=0; j<n; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            bw.write(getMinAccumulateCost(arr)+"\n");
        }

        br.close();
        bw.close();
    }

    public static int getMinAccumulateCost(int[] arr){
        int n = arr.length;

        int[][] dp = new int[n+1][n+1];
        int[] accSum = new int[n+1];
        for (int i=1; i<=n; i++){
            accSum[i] = accSum[i-1]+arr[i-1];
        }

        return recursiveDp(dp, accSum, 1, n);
    }

    static int recursiveDp(int[][] dp, int[] accSum, int i, int j){
        if(i==j || dp[i][j]>0){
            return dp[i][j];
        }

        dp[i][j] = Integer.MAX_VALUE;

        for (int k=i; k<=j-1; k++){
            dp[i][j] = Math.min(dp[i][j],
                    recursiveDp(dp, accSum, i,k)+recursiveDp(dp,accSum,k+1,j)
                                +accSum[j]-accSum[i-1]);
        }

        return dp[i][j];
    }
}