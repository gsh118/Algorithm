import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] ipt = new int[n][m];
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++){
                ipt[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] areaSum = makeAreaSum(ipt);
        int result = findMaxSum(areaSum);
        System.out.println(result);
    }

    private static int findMaxSum(int[][] areaSum) {
        int sum=-2000000000;
        for (int i=1; i<areaSum.length; i++){
            for (int j=1; j<areaSum[0].length; j++){
                for (int k=0; k<i; k++){
                    for (int l=0; l<j; l++){
                        sum = Math.max(sum,
                                areaSum[i][j]-areaSum[i][l]-areaSum[k][j]+areaSum[k][l]);
                    }
                }
            }
        }
        return sum;
    }

    public static int[][] makeAreaSum(int[][] ipt){
        int n= ipt.length;
        int m = ipt[0].length;

        int[][] arr = new int[n+1][m+1];

        for (int i=1; i<=n; i++){
            for (int j=1; j<=m; j++){
                arr[i][j] = arr[i-1][j]+arr[i][j-1]-arr[i-1][j-1]+ipt[i-1][j-1];
            }
        }

        return arr;
    }
}