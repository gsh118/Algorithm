import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int cnt=0;

        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            cnt++;
        }
        br.close();

        int[] d = new int[n-1];
        for (int i=0; i<n-1; i++){
            d[i] = arr[i+1]-arr[i]-1;
        }

        Arrays.sort(d);

        for (int j : d) {
            if (n <= k) {
                break;
            }

            cnt += j;
            n--;
        }

        System.out.println(cnt);
    }
}