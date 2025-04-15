import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int max = Math.max(arr[0],arr[n-1]);
        for (int i=1; i<n-1; i++){
            int curMin = Math.min(arr[i-1], arr[i+1]);
            max = Math.max(max, arr[i]+curMin);
        }

        bw.write(max+"");
        bw.close();
    }
}