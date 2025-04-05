import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i=0; i<n; i++){
            char[] tmp = br.readLine().toCharArray();
            for (int j=0; j<m; j++){
                arr[i][j] = tmp[j]-'0';
            }
        }

        System.out.println(findMaxArea());
    }

    static int findMaxArea(){
        int maxArea=0;
        for (int i=0; i<arr[0].length; i++){
            for (int j=0; j<=i; j++){
                int[] dp = new int[arr.length];
                dp[0] = isZeroRow(0,j,i)?1:0;
                maxArea = Math.max((i-j+1)*dp[0], maxArea);
                for (int r=1; r<arr.length; r++){
                    if(isZeroRow(r,j,i)){
                        dp[r] = dp[r-1]+1;
                    } else{
                        dp[r] = 0;
                    }
                    maxArea = Math.max((i-j+1)*dp[r], maxArea);
                }
            }
        }

        return maxArea;
    }

    static boolean isZeroRow(int row, int colStart, int colEnd){
        for (int i=colStart; i<=colEnd; i++){
            if (arr[row][i]!=0){
                return false;
            }
        }
        return true;
    }
}