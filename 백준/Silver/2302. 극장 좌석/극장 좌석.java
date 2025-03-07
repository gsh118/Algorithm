import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][3];
        boolean[] isFix = new boolean[n+1];

        int m = Integer.parseInt(br.readLine());
        for (int i=0; i<m; i++){
            int cur = Integer.parseInt(br.readLine());
            isFix[cur]=true;
        }

        br.close();

        dp[0][0]=1;
        for (int i=1; i<=n; i++){
            dp[i][0] = dp[i-1][0]+dp[i-1][1];
            if(!isFix[i]){
                dp[i][2] = dp[i][0];
                dp[i][1] = dp[i-1][2];
            }
        }

        int result = dp[n][0] + dp[n][1];
        System.out.println(result);
    }
}