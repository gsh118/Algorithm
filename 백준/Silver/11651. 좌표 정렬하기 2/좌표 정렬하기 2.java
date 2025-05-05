import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr, (a1,a2)->a1[1]-a2[1]!=0?a1[1]-a2[1]:a1[0]-a2[0]);
        
        for (int i=0; i<n; i++){
            bw.write(arr[i][0]+" "+arr[i][1]+"\n");
        }
        
        br.close();
        bw.close();
    }
}