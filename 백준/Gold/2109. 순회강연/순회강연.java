import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[10001];

        Arrays.sort(arr, new ArrComp());

        for (int i=0; i<n; i++){
            int np = arr[i][0];
            int nd = arr[i][1];

            for (int j=nd; j>0; j--){
                if(dp[j]==0){
                    dp[j]=np;
                    break;
                }
            }
        }
        System.out.println(Arrays.stream(dp).sum());
    }
}

class ArrComp implements Comparator<int[]>{
    public int compare(int[] o1, int[] o2) {
        if(o1[0]!=o2[0]){
            return o2[0]-o1[0];
        }

        return o1[1]-o2[1];
    }
}