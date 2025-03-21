import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[m][2];
        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<2; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[m][n+1];
        if(arr[0][0]<=n){
            dp[0][arr[0][0]] = arr[0][1];
        }

        for (int i=1; i<m; i++){
            for (int t=0; t<=n; t++){
                dp[i][t] = dp[i-1][t];

                if(arr[i][0]<=t){
                    dp[i][t] = Math.max(dp[i][t], dp[i-1][t-arr[i][0]]+arr[i][1]);
                }
            }
        }

        int result = 0;
        for (int t=0; t<=n; t++){
            result = Math.max(dp[m-1][t], result);
        }

        System.out.println(result);
    }
}